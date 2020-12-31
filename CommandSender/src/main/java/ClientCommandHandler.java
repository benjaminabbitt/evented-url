import com.google.protobuf.Any;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.opentracing.Tracer;
import io.opentracing.contrib.grpc.TracingClientInterceptor;
import name.benjaminabbitt.evented.EnhancedProtoUUID;
import name.benjaminabbitt.evented.bookmarks.Bookmarks;
import name.benjaminabbitt.evented.core.CommandHandlerGrpc;
import name.benjaminabbitt.evented.core.Evented;
import name.benjaminabbitt.evented.opentracing.TracerSupport;

import java.util.UUID;


public class ClientCommandHandler {
    public static void main(String[] args) {
        String target = "localhost:1747";
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();
        Tracer tracer = TracerSupport.getTracer();
        TracingClientInterceptor tracingClientInterceptor = TracingClientInterceptor
                .newBuilder()
                .withTracer(tracer)
                .withVerbosity()
                .build();
        CommandHandlerGrpc.CommandHandlerBlockingStub stub = CommandHandlerGrpc.newBlockingStub(tracingClientInterceptor.intercept(channel));
        Bookmarks.CreateBookmark test = Bookmarks.CreateBookmark.newBuilder().setName("test").setUrl("http://test.example").build();
        Evented.CommandBook commandBook = Evented.CommandBook.newBuilder().setCover(Evented.Cover.newBuilder().setRoot(new EnhancedProtoUUID(UUID.randomUUID()).getNetworkId())).addPages(Evented.CommandPage.newBuilder().setCommand(Any.pack(test)).setSequence(0).build()).build();
        Evented.SynchronousProcessingResponse response = stub.handle(commandBook);
        System.out.println(response);
        channel.shutdownNow();
        System.out.println("Hello World");
    }
}
