package name.benjaminabbitt.evented.saga;

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
    comments = "Source: evented/saga/saga.proto")
public final class SagaGrpc {

  private SagaGrpc() {}

  public static final String SERVICE_NAME = "evented.saga.Saga";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<name.benjaminabbitt.evented.core.Evented.EventBook,
      name.benjaminabbitt.evented.core.Evented.EventBook> getHandleSyncMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HandleSync",
      requestType = name.benjaminabbitt.evented.core.Evented.EventBook.class,
      responseType = name.benjaminabbitt.evented.core.Evented.EventBook.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<name.benjaminabbitt.evented.core.Evented.EventBook,
      name.benjaminabbitt.evented.core.Evented.EventBook> getHandleSyncMethod() {
    io.grpc.MethodDescriptor<name.benjaminabbitt.evented.core.Evented.EventBook, name.benjaminabbitt.evented.core.Evented.EventBook> getHandleSyncMethod;
    if ((getHandleSyncMethod = SagaGrpc.getHandleSyncMethod) == null) {
      synchronized (SagaGrpc.class) {
        if ((getHandleSyncMethod = SagaGrpc.getHandleSyncMethod) == null) {
          SagaGrpc.getHandleSyncMethod = getHandleSyncMethod =
              io.grpc.MethodDescriptor.<name.benjaminabbitt.evented.core.Evented.EventBook, name.benjaminabbitt.evented.core.Evented.EventBook>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HandleSync"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  name.benjaminabbitt.evented.core.Evented.EventBook.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  name.benjaminabbitt.evented.core.Evented.EventBook.getDefaultInstance()))
              .setSchemaDescriptor(new SagaMethodDescriptorSupplier("HandleSync"))
              .build();
        }
      }
    }
    return getHandleSyncMethod;
  }

  private static volatile io.grpc.MethodDescriptor<name.benjaminabbitt.evented.core.Evented.EventBook,
      name.benjaminabbitt.evented.core.Evented.EventBook> getHandleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Handle",
      requestType = name.benjaminabbitt.evented.core.Evented.EventBook.class,
      responseType = name.benjaminabbitt.evented.core.Evented.EventBook.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<name.benjaminabbitt.evented.core.Evented.EventBook,
      name.benjaminabbitt.evented.core.Evented.EventBook> getHandleMethod() {
    io.grpc.MethodDescriptor<name.benjaminabbitt.evented.core.Evented.EventBook, name.benjaminabbitt.evented.core.Evented.EventBook> getHandleMethod;
    if ((getHandleMethod = SagaGrpc.getHandleMethod) == null) {
      synchronized (SagaGrpc.class) {
        if ((getHandleMethod = SagaGrpc.getHandleMethod) == null) {
          SagaGrpc.getHandleMethod = getHandleMethod =
              io.grpc.MethodDescriptor.<name.benjaminabbitt.evented.core.Evented.EventBook, name.benjaminabbitt.evented.core.Evented.EventBook>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Handle"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  name.benjaminabbitt.evented.core.Evented.EventBook.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  name.benjaminabbitt.evented.core.Evented.EventBook.getDefaultInstance()))
              .setSchemaDescriptor(new SagaMethodDescriptorSupplier("Handle"))
              .build();
        }
      }
    }
    return getHandleMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SagaStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SagaStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SagaStub>() {
        @java.lang.Override
        public SagaStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SagaStub(channel, callOptions);
        }
      };
    return SagaStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SagaBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SagaBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SagaBlockingStub>() {
        @java.lang.Override
        public SagaBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SagaBlockingStub(channel, callOptions);
        }
      };
    return SagaBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SagaFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SagaFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SagaFutureStub>() {
        @java.lang.Override
        public SagaFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SagaFutureStub(channel, callOptions);
        }
      };
    return SagaFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SagaImplBase implements io.grpc.BindableService {

    /**
     */
    public void handleSync(name.benjaminabbitt.evented.core.Evented.EventBook request,
        io.grpc.stub.StreamObserver<name.benjaminabbitt.evented.core.Evented.EventBook> responseObserver) {
      asyncUnimplementedUnaryCall(getHandleSyncMethod(), responseObserver);
    }

    /**
     */
    public void handle(name.benjaminabbitt.evented.core.Evented.EventBook request,
        io.grpc.stub.StreamObserver<name.benjaminabbitt.evented.core.Evented.EventBook> responseObserver) {
      asyncUnimplementedUnaryCall(getHandleMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHandleSyncMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                name.benjaminabbitt.evented.core.Evented.EventBook,
                name.benjaminabbitt.evented.core.Evented.EventBook>(
                  this, METHODID_HANDLE_SYNC)))
          .addMethod(
            getHandleMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                name.benjaminabbitt.evented.core.Evented.EventBook,
                name.benjaminabbitt.evented.core.Evented.EventBook>(
                  this, METHODID_HANDLE)))
          .build();
    }
  }

  /**
   */
  public static final class SagaStub extends io.grpc.stub.AbstractAsyncStub<SagaStub> {
    private SagaStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SagaStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SagaStub(channel, callOptions);
    }

    /**
     */
    public void handleSync(name.benjaminabbitt.evented.core.Evented.EventBook request,
        io.grpc.stub.StreamObserver<name.benjaminabbitt.evented.core.Evented.EventBook> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHandleSyncMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void handle(name.benjaminabbitt.evented.core.Evented.EventBook request,
        io.grpc.stub.StreamObserver<name.benjaminabbitt.evented.core.Evented.EventBook> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHandleMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SagaBlockingStub extends io.grpc.stub.AbstractBlockingStub<SagaBlockingStub> {
    private SagaBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SagaBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SagaBlockingStub(channel, callOptions);
    }

    /**
     */
    public name.benjaminabbitt.evented.core.Evented.EventBook handleSync(name.benjaminabbitt.evented.core.Evented.EventBook request) {
      return blockingUnaryCall(
          getChannel(), getHandleSyncMethod(), getCallOptions(), request);
    }

    /**
     */
    public name.benjaminabbitt.evented.core.Evented.EventBook handle(name.benjaminabbitt.evented.core.Evented.EventBook request) {
      return blockingUnaryCall(
          getChannel(), getHandleMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SagaFutureStub extends io.grpc.stub.AbstractFutureStub<SagaFutureStub> {
    private SagaFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SagaFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SagaFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<name.benjaminabbitt.evented.core.Evented.EventBook> handleSync(
        name.benjaminabbitt.evented.core.Evented.EventBook request) {
      return futureUnaryCall(
          getChannel().newCall(getHandleSyncMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<name.benjaminabbitt.evented.core.Evented.EventBook> handle(
        name.benjaminabbitt.evented.core.Evented.EventBook request) {
      return futureUnaryCall(
          getChannel().newCall(getHandleMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HANDLE_SYNC = 0;
  private static final int METHODID_HANDLE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SagaImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SagaImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HANDLE_SYNC:
          serviceImpl.handleSync((name.benjaminabbitt.evented.core.Evented.EventBook) request,
              (io.grpc.stub.StreamObserver<name.benjaminabbitt.evented.core.Evented.EventBook>) responseObserver);
          break;
        case METHODID_HANDLE:
          serviceImpl.handle((name.benjaminabbitt.evented.core.Evented.EventBook) request,
              (io.grpc.stub.StreamObserver<name.benjaminabbitt.evented.core.Evented.EventBook>) responseObserver);
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

  private static abstract class SagaBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SagaBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return name.benjaminabbitt.evented.saga.SagaOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Saga");
    }
  }

  private static final class SagaFileDescriptorSupplier
      extends SagaBaseDescriptorSupplier {
    SagaFileDescriptorSupplier() {}
  }

  private static final class SagaMethodDescriptorSupplier
      extends SagaBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SagaMethodDescriptorSupplier(String methodName) {
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
      synchronized (SagaGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SagaFileDescriptorSupplier())
              .addMethod(getHandleSyncMethod())
              .addMethod(getHandleMethod())
              .build();
        }
      }
    }
    return result;
  }
}
