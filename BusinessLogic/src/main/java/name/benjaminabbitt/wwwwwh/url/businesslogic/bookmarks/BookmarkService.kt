package name.benjaminabbitt.wwwwwh.url.businesslogic.bookmarks

import com.google.protobuf.InvalidProtocolBufferException
import io.grpc.stub.StreamObserver
import name.benjaminabbitt.evented.bookmarks.Bookmarks.*
import name.benjaminabbitt.evented.business.BusinessLogicGrpc
import name.benjaminabbitt.evented.core.Evented
import name.benjaminabbitt.wwwwwh.url.businesslogic.bookmarks.statemachine.states.Bookmark
import name.benjaminabbitt.wwwwwh.url.businesslogic.bookmarks.statemachine.states.NotCreatedBookmark
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*
import java.util.concurrent.atomic.AtomicInteger
import java.util.function.Consumer
import java.util.stream.Stream
import javax.inject.Singleton

@Singleton
class BookmarkService(config: BookmarkConfig) : BusinessLogicGrpc.BusinessLogicImplBase() {
    private var bookmark: Bookmark?
    private val logger: Logger

    /**
     * @param request
     * @param responseObserver
     */
    override fun handle(request: Evented.ContextualCommand, responseObserver: StreamObserver<Evented.EventBook>) {
        assert(request != null)
        request.events.pagesList.forEach(Consumer { ea: Evented.EventPage ->
            try {
                bookmark = dispatchEvent(ea)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        })
        val pages = ArrayList<Evented.EventPage>()
        val seq = AtomicInteger(request.command.getPages(0).sequence)
        request.command.pagesList.forEach(Consumer { commandPage: Evented.CommandPage ->
            try {
                val events = dispatchCommand(commandPage)
                events!!.forEach { event: Evented.EventPage.Builder? -> pages.add(event!!.setNum(seq.getAndIncrement()).build()) }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        })
        val book = Evented.EventBook.newBuilder()
                .setCover(request.command.cover)
                .addAllPages(pages)
                .build()
        responseObserver.onNext(book)
        responseObserver.onCompleted()
    }

    @Throws(Exception::class)
    private fun dispatchEvent(page: Evented.EventPage): Bookmark? {
        try {
            return if (page.event.`is`(BookmarkCreated::class.java)) {
                bookmark!!.handle(page.event.unpack(BookmarkCreated::class.java))
            } else if (page.event.`is`(BookmarkDeleted::class.java)) {
                bookmark!!.handle(page.event.unpack(BookmarkDeleted::class.java))
            } else {
                throw Exception("TODO")
            }
        } catch (e: InvalidProtocolBufferException) {
            e.printStackTrace()
        }
        throw IllegalStateException("Event didn't match anything that this application can handle.")
    }

    @Throws(Exception::class)
    private fun dispatchCommand(page: Evented.CommandPage): Stream<Evented.EventPage.Builder?>? {
        try {
            if (page.command.`is`(CreateBookmark::class.java)) {
                return bookmark!!.handle(page.command.unpack(CreateBookmark::class.java))
            } else if (page.command.`is`(DeleteBookmark::class.java)) {
                return bookmark!!.handle(page.command.unpack(DeleteBookmark::class.java))
            }
        } catch (e: InvalidProtocolBufferException) {
            e.printStackTrace()
        }
        throw IllegalStateException("Command didn't match anything that this application can handle")
    }

    init {
        logger = LoggerFactory.getLogger(BookmarkService::class.java)
        logger.debug("Bookmark Service Initialized, message = " + config.message)
        bookmark = NotCreatedBookmark()
    }
}