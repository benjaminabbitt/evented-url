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
  private static volatile io.grpc.MethodDescriptor<name.benjaminabbitt.evented.bookmarks.Bookmarks.CreateBookmark,
      com.google.protobuf.Empty> getCreateBookmarkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createBookmark",
      requestType = name.benjaminabbitt.evented.bookmarks.Bookmarks.CreateBookmark.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<name.benjaminabbitt.evented.bookmarks.Bookmarks.CreateBookmark,
      com.google.protobuf.Empty> getCreateBookmarkMethod() {
    io.grpc.MethodDescriptor<name.benjaminabbitt.evented.bookmarks.Bookmarks.CreateBookmark, com.google.protobuf.Empty> getCreateBookmarkMethod;
    if ((getCreateBookmarkMethod = BookmarkGrpc.getCreateBookmarkMethod) == null) {
      synchronized (BookmarkGrpc.class) {
        if ((getCreateBookmarkMethod = BookmarkGrpc.getCreateBookmarkMethod) == null) {
          BookmarkGrpc.getCreateBookmarkMethod = getCreateBookmarkMethod =
              io.grpc.MethodDescriptor.<name.benjaminabbitt.evented.bookmarks.Bookmarks.CreateBookmark, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createBookmark"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  name.benjaminabbitt.evented.bookmarks.Bookmarks.CreateBookmark.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new BookmarkMethodDescriptorSupplier("createBookmark"))
              .build();
        }
      }
    }
    return getCreateBookmarkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<name.benjaminabbitt.evented.bookmarks.Bookmarks.DeleteBookmark,
      com.google.protobuf.Empty> getDeleteBookmarkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteBookmark",
      requestType = name.benjaminabbitt.evented.bookmarks.Bookmarks.DeleteBookmark.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<name.benjaminabbitt.evented.bookmarks.Bookmarks.DeleteBookmark,
      com.google.protobuf.Empty> getDeleteBookmarkMethod() {
    io.grpc.MethodDescriptor<name.benjaminabbitt.evented.bookmarks.Bookmarks.DeleteBookmark, com.google.protobuf.Empty> getDeleteBookmarkMethod;
    if ((getDeleteBookmarkMethod = BookmarkGrpc.getDeleteBookmarkMethod) == null) {
      synchronized (BookmarkGrpc.class) {
        if ((getDeleteBookmarkMethod = BookmarkGrpc.getDeleteBookmarkMethod) == null) {
          BookmarkGrpc.getDeleteBookmarkMethod = getDeleteBookmarkMethod =
              io.grpc.MethodDescriptor.<name.benjaminabbitt.evented.bookmarks.Bookmarks.DeleteBookmark, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteBookmark"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  name.benjaminabbitt.evented.bookmarks.Bookmarks.DeleteBookmark.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new BookmarkMethodDescriptorSupplier("deleteBookmark"))
              .build();
        }
      }
    }
    return getDeleteBookmarkMethod;
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
     */
    public void createBookmark(name.benjaminabbitt.evented.bookmarks.Bookmarks.CreateBookmark request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateBookmarkMethod(), responseObserver);
    }

    /**
     */
    public void deleteBookmark(name.benjaminabbitt.evented.bookmarks.Bookmarks.DeleteBookmark request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteBookmarkMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateBookmarkMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                name.benjaminabbitt.evented.bookmarks.Bookmarks.CreateBookmark,
                com.google.protobuf.Empty>(
                  this, METHODID_CREATE_BOOKMARK)))
          .addMethod(
            getDeleteBookmarkMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                name.benjaminabbitt.evented.bookmarks.Bookmarks.DeleteBookmark,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_BOOKMARK)))
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
     */
    public void createBookmark(name.benjaminabbitt.evented.bookmarks.Bookmarks.CreateBookmark request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateBookmarkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteBookmark(name.benjaminabbitt.evented.bookmarks.Bookmarks.DeleteBookmark request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteBookmarkMethod(), getCallOptions()), request, responseObserver);
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
     */
    public com.google.protobuf.Empty createBookmark(name.benjaminabbitt.evented.bookmarks.Bookmarks.CreateBookmark request) {
      return blockingUnaryCall(
          getChannel(), getCreateBookmarkMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty deleteBookmark(name.benjaminabbitt.evented.bookmarks.Bookmarks.DeleteBookmark request) {
      return blockingUnaryCall(
          getChannel(), getDeleteBookmarkMethod(), getCallOptions(), request);
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
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> createBookmark(
        name.benjaminabbitt.evented.bookmarks.Bookmarks.CreateBookmark request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateBookmarkMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteBookmark(
        name.benjaminabbitt.evented.bookmarks.Bookmarks.DeleteBookmark request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteBookmarkMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_BOOKMARK = 0;
  private static final int METHODID_DELETE_BOOKMARK = 1;

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
        case METHODID_CREATE_BOOKMARK:
          serviceImpl.createBookmark((name.benjaminabbitt.evented.bookmarks.Bookmarks.CreateBookmark) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DELETE_BOOKMARK:
          serviceImpl.deleteBookmark((name.benjaminabbitt.evented.bookmarks.Bookmarks.DeleteBookmark) request,
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
              .addMethod(getCreateBookmarkMethod())
              .addMethod(getDeleteBookmarkMethod())
              .build();
        }
      }
    }
    return result;
  }
}
