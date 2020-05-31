package name.benjaminabbitt.evented.wwwwwh.url.BusinessLogic.Bookmarks;

import name.benjaminabbitt.evented.wwwwwh.url.BusinessLogic.Bookmarks.StateMachine.InvalidState;
import name.benjaminabbitt.evented.bookmarks.Bookmarks;
import name.benjaminabbitt.evented.core.Evented;

import java.util.stream.Stream;

public interface Bookmark {
    Bookmark handle(Bookmarks.BookmarkDeleted bookmarkDeleted) throws InvalidState;

    Stream<Evented.EventPage.Builder> handle(Bookmarks.DeleteBookmark deleteBookmark) throws InvalidState;

    Bookmark handle(Bookmarks.BookmarkCreated bookmarkCreated) throws InvalidState;

    Stream<Evented.EventPage.Builder> handle(Bookmarks.CreateBookmark createBookmark) throws InvalidState;
}
