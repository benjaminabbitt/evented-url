import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import name.benjaminabbitt.evented.bookmarks.BookmarkGrpc;
import name.benjaminabbitt.evented.bookmarks.BookmarkGrpc.BookmarkBlockingStub;
import name.benjaminabbitt.evented.bookmarks.Bookmarks;

public class Client {
    private final BookmarkBlockingStub blockingStub;

    public Client(BookmarkBlockingStub blockingStub) {
        this.blockingStub = blockingStub;
        Empty test = blockingStub.rCreateBookmark(Bookmarks.CreateBookmarkIntent.newBuilder().setName("test").setUrl("http://test.example").build());
    }

    public static void main(String[] args) {
        String target = "localhost:1747";
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();
        BookmarkBlockingStub stub = BookmarkGrpc.newBlockingStub(channel);
        Client client = new Client(stub);
        System.out.println("Hello World");
    }
}
