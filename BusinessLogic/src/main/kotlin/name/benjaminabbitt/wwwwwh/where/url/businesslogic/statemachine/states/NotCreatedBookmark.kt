package name.benjaminabbitt.wwwwwh.where.url.businesslogic.statemachine.states

import com.google.protobuf.Any
import com.google.protobuf.Timestamp
import name.benjaminabbitt.wwwwwh.where.url.projection.sample.bookmarks.Bookmarks.*
import name.benjaminabbitt.wwwwwh.where.url.projection.sample.core.Evented
import name.benjaminabbitt.wwwwwh.where.url.businesslogic.statemachine.InvalidState
import org.slf4j.LoggerFactory
import java.util.*
import java.util.stream.Stream

class NotCreatedBookmark(id: UUID) : Bookmark(id, LoggerFactory.getLogger(NotCreatedBookmark::class.java)) {
    @Throws(InvalidState::class)
    override fun handle(bookmarkDeleted: BookmarkDeleted): Bookmark {
        throw InvalidState()
    }

    @Throws(InvalidState::class)
    override fun handle(deleteBookmark: DeleteBookmark): Stream<Evented.EventPage.Builder> {
        throw InvalidState()
    }

    override fun handle(bookmarkCreated: BookmarkCreated): Bookmark {
        return ExtantBookmark(id, bookmarkCreated.name, bookmarkCreated.url)
    }

    override fun handle(createBookmark: CreateBookmark): Stream<Evented.EventPage.Builder> {
        return Stream.of(
            Evented.EventPage.newBuilder()
                .setCreatedAt(Timestamp.newBuilder().build())
                .setSynchronous(false)
                .setEvent(Any.pack(
                        BookmarkCreated.newBuilder()
                                .setName(createBookmark.name)
                                .setUrl(createBookmark.url)
                                .build()
                )))
    }
}