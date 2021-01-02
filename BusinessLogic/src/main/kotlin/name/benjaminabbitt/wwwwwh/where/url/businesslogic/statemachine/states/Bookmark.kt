package name.benjaminabbitt.wwwwwh.where.url.businesslogic.statemachine.states

import name.benjaminabbitt.wwwwwh.where.url.projection.sample.bookmarks.Bookmarks.*
import name.benjaminabbitt.wwwwwh.where.url.projection.sample.core.Evented
import name.benjaminabbitt.wwwwwh.where.url.businesslogic.statemachine.InvalidState
import org.slf4j.Logger
import java.util.*
import java.util.stream.Stream

abstract class Bookmark(val id: UUID, protected val logger: Logger) {
    @Throws(InvalidState::class)
    abstract fun handle(bookmarkDeleted: BookmarkDeleted): Bookmark

    @Throws(InvalidState::class)
    abstract fun handle(deleteBookmark: DeleteBookmark): Stream<Evented.EventPage.Builder>

    @Throws(InvalidState::class)
    abstract fun handle(bookmarkCreated: BookmarkCreated): Bookmark

    @Throws(InvalidState::class)
    abstract fun handle(createBookmark: CreateBookmark): Stream<Evented.EventPage.Builder>
}