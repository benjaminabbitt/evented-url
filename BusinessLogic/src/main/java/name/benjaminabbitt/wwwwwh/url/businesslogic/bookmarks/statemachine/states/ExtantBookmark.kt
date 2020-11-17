package name.benjaminabbitt.wwwwwh.url.businesslogic.bookmarks.statemachine.states

import com.google.protobuf.Any
import com.google.protobuf.Timestamp
import name.benjaminabbitt.evented.bookmarks.Bookmarks.*
import name.benjaminabbitt.evented.core.Evented
import name.benjaminabbitt.wwwwwh.url.businesslogic.bookmarks.statemachine.InvalidState
import org.slf4j.LoggerFactory
import java.util.stream.Stream

class ExtantBookmark(old: NotCreatedBookmark) : Bookmark(LoggerFactory.getLogger(ExtantBookmark::class.java)) {
    val name: String?
    val url: String?
    override fun handle(bookmarkDeleted: BookmarkDeleted?): Bookmark? {
        return DeletedBookmark(this)
    }

    override fun handle(deleteBookmark: DeleteBookmark?): Stream<Evented.EventPage.Builder?>? {
        return Stream.of(name.benjaminabbitt.evented.core.Evented.EventPage.newBuilder()
                .setEvent(Any.pack(BookmarkDeleted.newBuilder().build()))
                .setCreatedAt(Timestamp.newBuilder().build())
                .setSynchronous(false))
    }

    @Throws(InvalidState::class)
    override fun handle(bookmarkCreated: BookmarkCreated?): Bookmark? {
        throw InvalidState()
    }

    @Throws(InvalidState::class)
    override fun handle(createBookmark: CreateBookmark?): Stream<Evented.EventPage.Builder?>? {
        throw InvalidState()
    }

    init {
        name = old.name
        url = old.url
    }
}