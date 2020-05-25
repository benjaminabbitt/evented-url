import com.google.protobuf.Any;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.opentracing.Tracer;
import io.opentracing.contrib.grpc.TracingClientInterceptor;
import name.benjaminabbitt.evented.bookmarks.Bookmarks;
import name.benjaminabbitt.evented.business.BusinessLogicGrpc;
import name.benjaminabbitt.evented.core.Evented;
import name.benjaminabbitt.evented.opentracing.TracerSupport;

public class Client {
    private final BusinessLogicGrpc.BusinessLogicBlockingStub blockingStub;

    public Client(BusinessLogicGrpc.BusinessLogicBlockingStub blockingStub) {
        this.blockingStub = blockingStub;
    }

    public static void main(String[] args) {
        String target = "localhost:1748";
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();
        Tracer tracer = TracerSupport.getTracer();
        TracingClientInterceptor tracingClientInterceptor = TracingClientInterceptor
                .newBuilder()
                .withTracer(tracer)
                .withVerbosity()
                .build();
        BusinessLogicGrpc.BusinessLogicBlockingStub stub = BusinessLogicGrpc.newBlockingStub(tracingClientInterceptor.intercept(channel));
        Client client = new Client(stub);
        Bookmarks.CreateBookmarkIntent test = Bookmarks.CreateBookmarkIntent.newBuilder().setName("test").setUrl("http://test.example").build();
        Evented.CommandBook commandBook = Evented.CommandBook.newBuilder().setCover(Evented.Cover.newBuilder().setRoot(Evented.UUID.newBuilder().build()).setDomain("").build()).addPages(Evented.CommandPage.newBuilder().setCommand(Any.pack(test)).setSequence(0).build()).build();
        Evented.ContextualCommand ccommand = Evented.ContextualCommand.newBuilder().setCommand(commandBook).build();
        client.blockingStub.handle(ccommand);
        System.out.println("Hello World");
    }
}
