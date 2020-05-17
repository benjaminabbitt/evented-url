package name.benjaminabbitt.evented.Projector.Projector;

import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import name.benjaminabbitt.evented.Projector.EventPageDispatcher;
import name.benjaminabbitt.evented.bookmarks.Bookmarks;
import name.benjaminabbitt.evented.core.Evented;
import org.bson.Document;

import static name.benjaminabbitt.evented.java.UUIDAdapters.euuidTouuuid;

public class BookmarkProjector implements EventPageDispatcher {
    private final MongoCollection<Document> collection;

    public BookmarkProjector(MongoClient client) {
        MongoDatabase db = client.getDatabase("projection");
        collection = db.getCollection("test");

    }

    @Override
    public void dispatch(Evented.Cover cover, Evented.EventPage message) {
        Any event = message.getEvent();
        try {
            if (event.is(Bookmarks.BookmarkCreated.class)) {
                this.handle(cover, message, event.unpack(Bookmarks.BookmarkCreated.class));
            } else if (event.is(Bookmarks.BookmarkDeleted.class)) {
                this.handle(cover, message, event.unpack(Bookmarks.BookmarkDeleted.class));
            }
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }

    private void handle(Evented.Cover cover, Evented.EventPage page, Bookmarks.BookmarkCreated bookmarkCreated) {
        collection.insertOne(new Document("name", bookmarkCreated.getName())
                .append("url", bookmarkCreated.getUrl())
                .append("deleted", false)
                .append("sequence", page.getSequenceCase().getNumber())
                .append("_id", euuidTouuuid(cover.getRoot()).toString())
        );
    }

    private void handle(Evented.Cover cover, Evented.EventPage page, Bookmarks.BookmarkDeleted bookmarkDeleted) {
        collection.updateOne(
                Filters.eq("_id", euuidTouuuid(cover.getRoot()).toString()),
                Updates.combine(
                        Updates.set("deleted", true),
                        Updates.set("sequence", page.getSequenceCase().getNumber())
                )
        );
    }
}
