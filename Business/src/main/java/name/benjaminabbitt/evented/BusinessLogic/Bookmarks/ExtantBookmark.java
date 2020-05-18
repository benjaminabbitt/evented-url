package name.benjaminabbitt.evented.BusinessLogic.Bookmarks;


import com.google.protobuf.Any;
import com.google.protobuf.Timestamp;
import name.benjaminabbitt.evented.bookmarks.Bookmarks;
import name.benjaminabbitt.evented.core.Evented;

import java.util.stream.Stream;

public class ExtantBookmark implements Bookmark {
    private final String name;
    private final String url;


    public ExtantBookmark(NotCreatedBookmark old) {
        this.name = old.getName();
        this.url = old.getUrl();

    }

    @Override
    public Bookmark handle(Bookmarks.BookmarkDeleted bookmarkDeleted) {
        return new DeletedBookmark(this);
    }

    @Override
    public Stream<Evented.EventPage.Builder> handle(Bookmarks.DeleteBookmark deleteBookmark) {
        return Stream.of(Evented.EventPage.newBuilder()
                .setEvent(Any.pack(Bookmarks.BookmarkDeleted.newBuilder().build()))
                .setCreatedAt(Timestamp.newBuilder().build())
                .setSynchronous(false));
    }

    @Override
    public Bookmark handle(Bookmarks.BookmarkCreated bookmarkCreated) throws InvalidState {
        throw new InvalidState();
    }

    @Override
    public Stream<Evented.EventPage.Builder> handle(Bookmarks.CreateBookmark createBookmark) throws InvalidState {
        throw new InvalidState();
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
