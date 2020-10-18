package name.benjaminabbitt.evented.Projector;

import com.google.protobuf.Empty;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import name.benjaminabbitt.evented.Projector.Projector.BookmarkProjector;
import name.benjaminabbitt.evented.core.Evented;
import name.benjaminabbitt.evented.projector.ProjectorGrpc.ProjectorImplBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ProjectorService {
    private static final Logger logger = Logger.getLogger(ProjectorService.class.getName());
    private final Server server;

    public ProjectorService(int port, MongoClient mongoClient) {
        this(ServerBuilder.forPort(port), mongoClient);
    }

    public ProjectorService(ServerBuilder<?> serverBuilder, MongoClient mongoClient) {
        this.server = serverBuilder.addService(new BookmarkService(new BookmarkProjector(mongoClient))).build();
    }

    public void start() throws IOException {
        this.server.start();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                try {
                    ProjectorService.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("*** server shut down");
            }
        });
    }

    /**
     * Stop serving requests and shutdown resources.
     */
    public void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static class BookmarkService extends ProjectorImplBase {
        private final EventPageDispatcher dispatcher;

        public BookmarkService(EventPageDispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }


        /**
         * @param request
         * @param responseObserver
         */
        @Override
        public void handleSync(Evented.EventBook request, StreamObserver<Evented.Projection> responseObserver) {
            Evented.Cover cover = request.getCover();
            request.getPagesList().forEach(ea -> {
                dispatcher.dispatch(cover, ea);
            });
        }

        /**
         * @param request
         * @param responseObserver
         */
        @Override
        public void handle(Evented.EventBook request, StreamObserver<Empty> responseObserver) {
            super.handle(request, responseObserver);
        }
    }

    public static void main(String[] args) throws Exception {
        //TODO: get Mongo settings from Consul
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        ProjectorService server = new ProjectorService(Integer.getInteger(System.getenv("GRPC_PORT")), mongoClient);
        server.start();
        server.blockUntilShutdown();
    }
}