package name.benjaminabbitt.evented

import com.google.protobuf.Empty
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import io.grpc.Server
import io.grpc.ServerBuilder
import io.grpc.stub.StreamObserver
import name.benjaminabbitt.evented.projector.BookmarkProjector
import name.benjaminabbitt.evented.core.Evented
import name.benjaminabbitt.evented.projector.ProjectorGrpc
import java.io.IOException
import java.util.concurrent.TimeUnit
import java.util.function.Consumer
import java.util.logging.Logger

class ProjectorService(serverBuilder: ServerBuilder<*>, mongoClient: MongoClient) {
    private val server: Server?

    constructor(port: Int, mongoClient: MongoClient) : this(ServerBuilder.forPort(port), mongoClient) {}

    @Throws(IOException::class)
    fun start() {
        server!!.start()
        Runtime.getRuntime().addShutdownHook(object : Thread() {
            override fun run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                logger.info("*** shutting down gRPC server since JVM is shutting down")
                try {
                    this@ProjectorService.stop()
                } catch (e: InterruptedException) {
                    logger.warning(e.toString())
                }
                logger.info("*** server shut down")
            }
        })
    }

    /**
     * Stop serving requests and shutdown resources.
     */
    @Throws(InterruptedException::class)
    fun stop() {
        server?.shutdown()?.awaitTermination(30, TimeUnit.SECONDS)
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    @Throws(InterruptedException::class)
    private fun blockUntilShutdown() {
        server?.awaitTermination()
    }

    class BookmarkService(private val dispatcher: EventPageDispatcher) : ProjectorGrpc.ProjectorImplBase() {
        /**
         * @param request
         * @param responseObserver
         */
        override fun handleSync(request: Evented.EventBook, responseObserver: StreamObserver<Evented.Projection>) {
            val cover = request.cover
            request.pagesList.forEach(Consumer { ea: Evented.EventPage -> dispatcher.dispatch(cover, ea) })
        }

        /**
         * @param request
         * @param responseObserver
         */
        override fun handle(request: Evented.EventBook, responseObserver: StreamObserver<Empty>) {
            super.handle(request, responseObserver)
        }
    }

    companion object {
        private val logger = Logger.getLogger(ProjectorService::class.java.name)
        @Throws(Exception::class)
        @JvmStatic
        fun main(args: Array<String>) {
            //TODO: get Mongo settings from Consul
            val mongoClient = MongoClients.create("mongodb://localhost:27017")
            val server = ProjectorService(Integer.getInteger(System.getenv("GRPC_PORT")), mongoClient)
            server.start()
            server.blockUntilShutdown()
        }
    }

    init {
        server = serverBuilder.addService(BookmarkService(BookmarkProjector(mongoClient))).build()
    }
}