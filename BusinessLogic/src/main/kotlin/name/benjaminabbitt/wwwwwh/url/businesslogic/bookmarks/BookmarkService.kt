package name.benjaminabbitt.wwwwwh.url.businesslogic.bookmarks

import io.grpc.stub.StreamObserver
import name.benjaminabbitt.evented.bookmarks.Bookmarks.*
import name.benjaminabbitt.evented.business.BusinessLogicGrpc
import name.benjaminabbitt.evented.core.Evented
import name.benjaminabbitt.wwwwwh.url.businesslogic.bookmarks.statemachine.states.Bookmark
import name.benjaminabbitt.wwwwwh.url.businesslogic.bookmarks.statemachine.states.NotCreatedBookmark
import name.benjaminabbitt.evented.exceptions.UnmatchedCommand
import name.benjaminabbitt.evented.exceptions.UnmatchedEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*
import java.util.concurrent.atomic.AtomicInteger
import java.util.function.Consumer
import java.util.stream.Stream
import javax.inject.Singleton

@Singleton
class BookmarkService(config: BookmarkConfig) : BusinessLogicGrpc.BusinessLogicImplBase() {
    private val logger: Logger = LoggerFactory.getLogger(BookmarkService::class.java)

    /**
     * @param request
     * @param responseObserver
     */
    override fun handle(request: Evented.ContextualCommand, responseObserver: StreamObserver<Evented.EventBook>) {
        var bookmark: Bookmark = NotCreatedBookmark(UUID.nameUUIDFromBytes(request.command.cover.root.value.toByteArray()));

        bookmark = dispatchEvents(request, bookmark)
        val book = dispatchCommands(request, bookmark)

        responseObserver.onNext(book)
        responseObserver.onCompleted()
    }

    private fun dispatchCommands(request: Evented.ContextualCommand, bookmark: Bookmark): Evented.EventBook? {
        val pages = ArrayList<Evented.EventPage>()
        val seq = AtomicInteger(request.command.getPages(0).sequence)
        request.command.pagesList.forEach(Consumer { commandPage: Evented.CommandPage ->
            try {
                val events = dispatchCommand(bookmark, commandPage)
                events.forEach { event: Evented.EventPage.Builder -> pages.add(event.setNum(seq.getAndIncrement()).build()) }
            } catch (e: Exception) {
                logger.warn(e.toString())
            }
        })
        return Evented.EventBook.newBuilder()
                .setCover(request.command.cover)
                .addAllPages(pages)
                .build()
    }

    private fun dispatchEvents(request: Evented.ContextualCommand, bookmark: Bookmark): Bookmark {
        var mark = bookmark;
        request.events.pagesList.forEach(Consumer { ea: Evented.EventPage ->
            try {
                mark = dispatchEvent(bookmark, ea)
            } catch (e: Exception) {
                logger.warn(e.toString())
            }
        })
        return mark
    }


    @Throws(UnmatchedEvent::class)
    private fun dispatchEvent(bookmark: Bookmark, page: Evented.EventPage): Bookmark {
        return when {
            page.event.`is`(BookmarkCreated::class.java) -> {
                bookmark.handle(page.event.unpack(BookmarkCreated::class.java))
            }
            page.event.`is`(BookmarkDeleted::class.java) -> {
                bookmark.handle(page.event.unpack(BookmarkDeleted::class.java))
            }
            else -> throw UnmatchedEvent(page.event)
        }
    }

    @Throws(UnmatchedCommand::class)
    private fun dispatchCommand(bookmark: Bookmark, page: Evented.CommandPage): Stream<Evented.EventPage.Builder> {
        return when {
            page.command.`is`(CreateBookmark::class.java) -> {
                bookmark.handle(page.command.unpack(CreateBookmark::class.java))
            }
            page.command.`is`(DeleteBookmark::class.java) -> {
                bookmark.handle(page.command.unpack(DeleteBookmark::class.java))
            }
            else -> throw UnmatchedCommand(page.command)
        };
    }

    init {
        logger.debug("Bookmark Service Initialized, message = " + config.message)
    }
}