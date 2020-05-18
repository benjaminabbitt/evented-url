package name.benjaminabbitt.evented.BusinessLogic.Bookmarks;

import name.benjaminabbitt.evented.core.Evented;
import name.benjaminabbitt.evented.bookmarks.Bookmarks;

import java.util.stream.Stream;

public class DeletedBookmark implements Bookmark {
    public DeletedBookmark(ExtantBookmark old) {

    }

    @Override
    public Bookmark handle(Bookmarks.BookmarkDeleted bookmarkDeleted) throws InvalidState {
        throw new InvalidState();
    }

    @Override
    public Stream<Evented.EventPage.Builder> handle(Bookmarks.DeleteBookmark deleteBookmark) throws InvalidState {
        throw new InvalidState();
    }

    @Override
    public Bookmark handle(Bookmarks.BookmarkCreated bookmarkCreated) throws InvalidState {
        throw new InvalidState();
    }

    @Override
    public Stream<Evented.EventPage.Builder> handle(Bookmarks.CreateBookmark createBookmark) throws InvalidState {
        throw new InvalidState();
    }

}
