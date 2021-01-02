package name.benjaminabbitt.wwwwwh.where.url.businesslogic.statemachine.states

import name.benjaminabbitt.wwwwwh.where.url.projection.sample.bookmarks.Bookmarks.*
import name.benjaminabbitt.wwwwwh.where.url.projection.sample.core.Evented
import name.benjaminabbitt.wwwwwh.where.url.businesslogic.statemachine.InvalidState
import org.slf4j.LoggerFactory
import java.util.*
import java.util.stream.Stream

class DeletedBookmark(id: UUID) : Bookmark(id, LoggerFactory.getLogger(DeletedBookmark::class.java)) {
    @Throws(InvalidState::class)
    override fun handle(bookmarkDeleted: BookmarkDeleted): Bookmark {
        throw InvalidState()
    }

    @Throws(InvalidState::class)
    override fun handle(deleteBookmark: DeleteBookmark): Stream<Evented.EventPage.Builder> {
        throw InvalidState()
    }

    @Throws(InvalidState::class)
    override fun handle(bookmarkCreated: BookmarkCreated): Bookmark {
        throw InvalidState()
    }

    @Throws(InvalidState::class)
    override fun handle(createBookmark: CreateBookmark): Stream<Evented.EventPage.Builder> {
        throw InvalidState()
    }
}