package name.benjaminabbitt.wwwwwh.url.businesslogic.bookmarks.statemachine.states

import com.google.protobuf.Any
import com.google.protobuf.Timestamp
import name.benjaminabbitt.evented.bookmarks.Bookmarks.*
import name.benjaminabbitt.evented.core.Evented
import name.benjaminabbitt.wwwwwh.url.businesslogic.bookmarks.statemachine.InvalidState
import org.slf4j.LoggerFactory
import java.util.stream.Stream

class NotCreatedBookmark : Bookmark(LoggerFactory.getLogger(NotCreatedBookmark::class.java)) {
    var name: String? = null
        private set
    var url: String? = null
        private set

    @Throws(InvalidState::class)
    override fun handle(bookmarkDeleted: BookmarkDeleted?): Bookmark? {
        throw InvalidState()
    }

    @Throws(InvalidState::class)
    override fun handle(deleteBookmark: DeleteBookmark?): Stream<Evented.EventPage.Builder?>? {
        throw InvalidState()
    }

    override fun handle(bookmarkCreated: BookmarkCreated?): Bookmark? {
        url = bookmarkCreated!!.url
        name = bookmarkCreated.name
        return ExtantBookmark(this)
    }

    override fun handle(createBookmark: CreateBookmark?): Stream<Evented.EventPage.Builder?>? {
        return Stream.of(name.benjaminabbitt.evented.core.Evented.EventPage.newBuilder()
                .setCreatedAt(Timestamp.newBuilder().build())
                .setSynchronous(false)
                .setEvent(Any.pack(
                        BookmarkCreated.newBuilder()
                                .setName(createBookmark!!.name)
                                .setUrl(createBookmark.url)
                                .build()
                )))
    }
}