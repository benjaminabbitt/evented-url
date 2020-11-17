package name.benjaminabbitt.wwwwwh.url.businesslogic.bookmarks.statemachine.states

import name.benjaminabbitt.evented.bookmarks.Bookmarks.*
import name.benjaminabbitt.evented.core.Evented
import name.benjaminabbitt.wwwwwh.url.businesslogic.bookmarks.statemachine.InvalidState
import org.slf4j.Logger
import java.util.stream.Stream

abstract class Bookmark(protected val logger: Logger) {
    @Throws(InvalidState::class)
    abstract fun handle(bookmarkDeleted: BookmarkDeleted?): Bookmark?
    @Throws(InvalidState::class)
    abstract fun handle(deleteBookmark: DeleteBookmark?): Stream<Evented.EventPage.Builder?>?
    @Throws(InvalidState::class)
    abstract fun handle(bookmarkCreated: BookmarkCreated?): Bookmark?
    @Throws(InvalidState::class)
    abstract fun handle(createBookmark: CreateBookmark?): Stream<Evented.EventPage.Builder?>?
}