import com.google.protobuf.Any;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.opentracing.Tracer;
import io.opentracing.contrib.grpc.TracingClientInterceptor;
import name.benjaminabbitt.wwwwwh.where.url.projection.sample.bookmarks.Bookmarks;
import name.benjaminabbitt.wwwwwh.where.url.projection.sample.business.BusinessLogicGrpc;
import name.benjaminabbitt.wwwwwh.where.url.projection.sample.core.Evented;
import name.benjaminabbitt.wwwwwh.where.url.projection.sample.opentracing.TracerSupport;

public class ClientBusiness {
    private final BusinessLogicGrpc.BusinessLogicBlockingStub blockingStub;

    public ClientBusiness(BusinessLogicGrpc.BusinessLogicBlockingStub blockingStub) {
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
        ClientBusiness client = new ClientBusiness(stub);
        Bookmarks.CreateBookmark test = Bookmarks.CreateBookmark.newBuilder().setName("test").setUrl("http://test.example").build();
        Evented.CommandBook commandBook = Evented.CommandBook.newBuilder().setCover(Evented.Cover.newBuilder().setRoot(Evented.UUID.newBuilder().build()).setDomain("").build()).addPages(Evented.CommandPage.newBuilder().setCommand(Any.pack(test)).setSequence(0).build()).build();
        Evented.ContextualCommand command = Evented.ContextualCommand.newBuilder().setCommand(commandBook).build();
        client.blockingStub.handle(command);
        System.out.println("Hello World");
    }
}
