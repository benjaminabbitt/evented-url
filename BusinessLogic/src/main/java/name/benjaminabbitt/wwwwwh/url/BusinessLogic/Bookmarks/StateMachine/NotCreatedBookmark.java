package name.benjaminabbitt.wwwwwh.url.BusinessLogic.Bookmarks.StateMachine;

import com.google.protobuf.Any;
import com.google.protobuf.Timestamp;
import name.benjaminabbitt.wwwwwh.url.BusinessLogic.Bookmarks.Bookmark;
import name.benjaminabbitt.evented.bookmarks.Bookmarks;
import name.benjaminabbitt.evented.core.Evented;

import java.util.stream.Stream;

public class NotCreatedBookmark implements Bookmark {
    private String name;
    private String url;


    @Override
    public Bookmark handle(Bookmarks.BookmarkDeleted bookmarkDeleted) throws InvalidState {
        throw new InvalidState();
    }

    @Override
    public Stream<Evented.EventPage.Builder> handle(Bookmarks.DeleteBookmark deleteBookmark) throws InvalidState {
        throw new InvalidState();
    }

    @Override
    public Bookmark handle(Bookmarks.BookmarkCreated bookmarkCreated) {
        this.url = bookmarkCreated.getUrl();
        this.name = bookmarkCreated.getName();
        return new ExtantBookmark(this);
    }

    @Override
    public Stream<Evented.EventPage.Builder> handle(Bookmarks.CreateBookmark createBookmark) {
        return Stream.of(Evented.EventPage.newBuilder()
                .setCreatedAt(Timestamp.newBuilder().build())
                .setSynchronous(false)
                .setEvent(Any.pack(
                        Bookmarks.BookmarkCreated.newBuilder()
                                .setName(createBookmark.getName())
                                .setUrl(createBookmark.getUrl())
                                .build()
                )));
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}

