package name.benjaminabbitt.wwwwwh.where.url.projection.sample.bookmark;

import com.google.protobuf.Any;
import com.google.protobuf.util.Timestamps;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.grpc.stub.StreamObserver;
import name.benjaminabbitt.wwwwwh.where.url.projection.sample.EnhancedProtoUUID;
import name.benjaminabbitt.wwwwwh.where.url.projection.sample.projector.BookmarkProjector;
import name.benjaminabbitt.wwwwwh.where.url.projection.sample.ProjectorService;
import name.benjaminabbitt.wwwwwh.where.url.projection.sample.bookmarks.Bookmarks;
import name.benjaminabbitt.wwwwwh.where.url.projection.sample.core.Evented;

import java.util.UUID;

import static org.mockito.Mockito.*;

public class BookmarkDeletedDriver {
    private MongoClient mockClient;
    private ProjectorService.BookmarkService bookmarkService;
    private StreamObserver<Evented.Projection> syncResponseStream;
    private MongoDatabase mockDatabase;
    private MongoCollection mockCollection;
    private UUID id;
    private Evented.Cover cover;
    private int sequence;

    @Given("The Bookmark does already exist in the projection")
    public void bookmarkDeletedGiven() {
        mockClient = mock(MongoClient.class);
        mockDatabase = mock(MongoDatabase.class);
        mockCollection = mock(MongoCollection.class);
        when(mockClient.getDatabase("projection")).thenReturn(mockDatabase);
        when(mockDatabase.getCollection("test")).thenReturn(mockCollection);
        bookmarkService = new ProjectorService.BookmarkService(new BookmarkProjector(mockClient));
        syncResponseStream = (StreamObserver<Evented.Projection>) mock(StreamObserver.class);
        id = UUID.randomUUID();
        cover = Evented.Cover.newBuilder()
                .setDomain("")
                .setRoot(new EnhancedProtoUUID(id).getNetworkId())
                .build();
        sequence = 0;
    }

    @When("I send an event that specifies that it's been deleted")
    public void bookmarkDeletedWhen() {
        Evented.EventBook eb = Evented.EventBook.newBuilder()
                .setCover(cover)
                .addPages(Evented.EventPage.newBuilder()
                        .setSynchronous(false)
                        .setCreatedAt(Timestamps.fromNanos(System.nanoTime()))
                        .setNum(sequence)
                        .setEvent(Any.pack(Bookmarks.BookmarkDeleted.newBuilder()
                                .build()
                        ))
                ).build();

        bookmarkService.handleSync(eb, this.syncResponseStream);
    }

    @Then("The event should be marked as deleted in the database")
    public void bookmarkDeletedThen() {
        verify(mockCollection).updateOne(Filters.eq("_id", new EnhancedProtoUUID(cover.getRoot()).toString()),
                Updates.combine(
                        Updates.set("deleted", true),
                        Updates.set("sequence", sequence + 1)
                ));
    }
}


