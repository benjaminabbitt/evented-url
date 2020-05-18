package name.benjaminabbitt.evented.bookmark;

import com.google.protobuf.Any;
import com.google.protobuf.util.Timestamps;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.grpc.stub.StreamObserver;
import name.benjaminabbitt.evented.Projector.Projector.BookmarkProjector;
import name.benjaminabbitt.evented.Projector.ProjectorService;
import name.benjaminabbitt.evented.bookmarks.Bookmarks;
import name.benjaminabbitt.evented.core.Evented;

import java.util.UUID;

import static org.mockito.Mockito.*;

public class BookmarkCreatedDriver {
    private MongoClient mockClient;
    private ProjectorService.BookmarkService bookmarkService;
    private StreamObserver<Evented.Projection> syncResponseStream;
    private MongoDatabase mockDatabase;
    private MongoCollection mockCollection;
    private UUID id;

    @Given("The Bookmark doesn't already exist in the projection")
    public void cucumberGiven() {
        mockClient = mock(MongoClient.class);
        mockDatabase = mock(MongoDatabase.class);
        mockCollection = mock(MongoCollection.class);
        when(mockClient.getDatabase("projection")).thenReturn(mockDatabase);
        when(mockDatabase.getCollection("test")).thenReturn(mockCollection);
        bookmarkService = new ProjectorService.BookmarkService(new BookmarkProjector(mockClient));
        syncResponseStream = (StreamObserver<Evented.Projection>) mock(StreamObserver.class);
        id = UUID.randomUUID();
    }

    @When("I send an event that specifies that it's been created")
    public void cucumberWhen() {
        Evented.EventBook eb = Evented.EventBook.newBuilder()
                .setCover(Evented.Cover.newBuilder()
                        .setDomain("")
                        .setRoot(name.benjaminabbitt.evented.java.UUIDAdapters.uuuidToeuuid(id))
                ).addPages(Evented.EventPage.newBuilder()
                        .setSynchronous(false)
                        .setCreatedAt(Timestamps.fromNanos(System.nanoTime()))
                        .setNum(0)
                        .setEvent(Any.pack(Bookmarks.BookmarkCreated.newBuilder()
                                .setName("name")
                                .setUrl("http://example.example")
                                .build()
                        ))
                ).build();

        bookmarkService.handleSync(eb, this.syncResponseStream);
    }

    @Then("The event should be put into the database")
    public void cucumberThen() {
        verify(mockCollection).insertOne(any());
    }
}


