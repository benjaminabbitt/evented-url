package name.benjaminabbitt.evented.bookmarks;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.29.0)",
    comments = "Source: bookmarks.proto")
public final class BookmarkGrpc {

  private BookmarkGrpc() {}

  public static final String SERVICE_NAME = "Bookmark";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<name.benjaminabbitt.evented.bookmarks.Bookmarks.CreateBookmarkIntent,
      com.google.protobuf.Empty> getRCreateBookmarkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "rCreateBookmark",
      requestType = name.benjaminabbitt.evented.bookmarks.Bookmarks.CreateBookmarkIntent.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<name.benjaminabbitt.evented.bookmarks.Bookmarks.CreateBookmarkIntent,
      com.google.protobuf.Empty> getRCreateBookmarkMethod() {
    io.grpc.MethodDescriptor<name.benjaminabbitt.evented.bookmarks.Bookmarks.CreateBookmarkIntent, com.google.protobuf.Empty> getRCreateBookmarkMethod;
    if ((getRCreateBookmarkMethod = BookmarkGrpc.getRCreateBookmarkMethod) == null) {
      synchronized (BookmarkGrpc.class) {
        if ((getRCreateBookmarkMethod = BookmarkGrpc.getRCreateBookmarkMethod) == null) {
          BookmarkGrpc.getRCreateBookmarkMethod = getRCreateBookmarkMethod =
              io.grpc.MethodDescriptor.<name.benjaminabbitt.evented.bookmarks.Bookmarks.CreateBookmarkIntent, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "rCreateBookmark"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  name.benjaminabbitt.evented.bookmarks.Bookmarks.CreateBookmarkIntent.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new BookmarkMethodDescriptorSupplier("rCreateBookmark"))
              .build();
        }
      }
    }
    return getRCreateBookmarkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<name.benjaminabbitt.evented.bookmarks.Bookmarks.DeleteBookmarkIntent,
      com.google.protobuf.Empty> getRDeleteBookmarkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "rDeleteBookmark",
      requestType = name.benjaminabbitt.evented.bookmarks.Bookmarks.DeleteBookmarkIntent.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<name.benjaminabbitt.evented.bookmarks.Bookmarks.DeleteBookmarkIntent,
      com.google.protobuf.Empty> getRDeleteBookmarkMethod() {
    io.grpc.MethodDescriptor<name.benjaminabbitt.evented.bookmarks.Bookmarks.DeleteBookmarkIntent, com.google.protobuf.Empty> getRDeleteBookmarkMethod;
    if ((getRDeleteBookmarkMethod = BookmarkGrpc.getRDeleteBookmarkMethod) == null) {
      synchronized (BookmarkGrpc.class) {
        if ((getRDeleteBookmarkMethod = BookmarkGrpc.getRDeleteBookmarkMethod) == null) {
          BookmarkGrpc.getRDeleteBookmarkMethod = getRDeleteBookmarkMethod =
              io.grpc.MethodDescriptor.<name.benjaminabbitt.evented.bookmarks.Bookmarks.DeleteBookmarkIntent, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "rDeleteBookmark"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  name.benjaminabbitt.evented.bookmarks.Bookmarks.DeleteBookmarkIntent.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new BookmarkMethodDescriptorSupplier("rDeleteBookmark"))
              .build();
        }
      }
    }
    return getRDeleteBookmarkMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BookmarkStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BookmarkStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BookmarkStub>() {
        @java.lang.Override
        public BookmarkStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BookmarkStub(channel, callOptions);
        }
      };
    return BookmarkStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BookmarkBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BookmarkBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BookmarkBlockingStub>() {
        @java.lang.Override
        public BookmarkBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BookmarkBlockingStub(channel, callOptions);
        }
      };
    return BookmarkBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BookmarkFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BookmarkFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BookmarkFutureStub>() {
        @java.lang.Override
        public BookmarkFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BookmarkFutureStub(channel, callOptions);
        }
      };
    return BookmarkFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class BookmarkImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *I dislike using this r prefix for remote procedure calls, but we have all kinds of name collisions otherwise
     *(with event, command, method call, and method call parameters all having the same semantic meaning
     * </pre>
     */
    public void rCreateBookmark(name.benjaminabbitt.evented.bookmarks.Bookmarks.CreateBookmarkIntent request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getRCreateBookmarkMethod(), responseObserver);
    }

    /**
     */
    public void rDeleteBookmark(name.benjaminabbitt.evented.bookmarks.Bookmarks.DeleteBookmarkIntent request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getRDeleteBookmarkMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRCreateBookmarkMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                name.benjaminabbitt.evented.bookmarks.Bookmarks.CreateBookmarkIntent,
                com.google.protobuf.Empty>(
                  this, METHODID_R_CREATE_BOOKMARK)))
          .addMethod(
            getRDeleteBookmarkMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                name.benjaminabbitt.evented.bookmarks.Bookmarks.DeleteBookmarkIntent,
                com.google.protobuf.Empty>(
                  this, METHODID_R_DELETE_BOOKMARK)))
          .build();
    }
  }

  /**
   */
  public static final class BookmarkStub extends io.grpc.stub.AbstractAsyncStub<BookmarkStub> {
    private BookmarkStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookmarkStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BookmarkStub(channel, callOptions);
    }

    /**
     * <pre>
     *I dislike using this r prefix for remote procedure calls, but we have all kinds of name collisions otherwise
     *(with event, command, method call, and method call parameters all having the same semantic meaning
     * </pre>
     */
    public void rCreateBookmark(name.benjaminabbitt.evented.bookmarks.Bookmarks.CreateBookmarkIntent request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRCreateBookmarkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void rDeleteBookmark(name.benjaminabbitt.evented.bookmarks.Bookmarks.DeleteBookmarkIntent request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRDeleteBookmarkMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BookmarkBlockingStub extends io.grpc.stub.AbstractBlockingStub<BookmarkBlockingStub> {
    private BookmarkBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookmarkBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BookmarkBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *I dislike using this r prefix for remote procedure calls, but we have all kinds of name collisions otherwise
     *(with event, command, method call, and method call parameters all having the same semantic meaning
     * </pre>
     */
    public com.google.protobuf.Empty rCreateBookmark(name.benjaminabbitt.evented.bookmarks.Bookmarks.CreateBookmarkIntent request) {
      return blockingUnaryCall(
          getChannel(), getRCreateBookmarkMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty rDeleteBookmark(name.benjaminabbitt.evented.bookmarks.Bookmarks.DeleteBookmarkIntent request) {
      return blockingUnaryCall(
          getChannel(), getRDeleteBookmarkMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BookmarkFutureStub extends io.grpc.stub.AbstractFutureStub<BookmarkFutureStub> {
    private BookmarkFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookmarkFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BookmarkFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *I dislike using this r prefix for remote procedure calls, but we have all kinds of name collisions otherwise
     *(with event, command, method call, and method call parameters all having the same semantic meaning
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> rCreateBookmark(
        name.benjaminabbitt.evented.bookmarks.Bookmarks.CreateBookmarkIntent request) {
      return futureUnaryCall(
          getChannel().newCall(getRCreateBookmarkMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> rDeleteBookmark(
        name.benjaminabbitt.evented.bookmarks.Bookmarks.DeleteBookmarkIntent request) {
      return futureUnaryCall(
          getChannel().newCall(getRDeleteBookmarkMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_R_CREATE_BOOKMARK = 0;
  private static final int METHODID_R_DELETE_BOOKMARK = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BookmarkImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BookmarkImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_R_CREATE_BOOKMARK:
          serviceImpl.rCreateBookmark((name.benjaminabbitt.evented.bookmarks.Bookmarks.CreateBookmarkIntent) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_R_DELETE_BOOKMARK:
          serviceImpl.rDeleteBookmark((name.benjaminabbitt.evented.bookmarks.Bookmarks.DeleteBookmarkIntent) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class BookmarkBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BookmarkBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return name.benjaminabbitt.evented.bookmarks.Bookmarks.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Bookmark");
    }
  }

  private static final class BookmarkFileDescriptorSupplier
      extends BookmarkBaseDescriptorSupplier {
    BookmarkFileDescriptorSupplier() {}
  }

  private static final class BookmarkMethodDescriptorSupplier
      extends BookmarkBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BookmarkMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (BookmarkGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BookmarkFileDescriptorSupplier())
              .addMethod(getRCreateBookmarkMethod())
              .addMethod(getRDeleteBookmarkMethod())
              .build();
        }
      }
    }
    return result;
  }
}
