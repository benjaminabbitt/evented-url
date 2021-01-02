package name.benjaminabbitt.wwwwwh.where.url.projection.sample.core;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.29.0)",
    comments = "Source: evented/core/evented.proto")
public final class CommandHandlerGrpc {

  private CommandHandlerGrpc() {}

  public static final String SERVICE_NAME = "evented.core.CommandHandler";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Evented.CommandBook,
      Evented.SynchronousProcessingResponse> getHandleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Handle",
      requestType = Evented.CommandBook.class,
      responseType = Evented.SynchronousProcessingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Evented.CommandBook,
      Evented.SynchronousProcessingResponse> getHandleMethod() {
    io.grpc.MethodDescriptor<Evented.CommandBook, Evented.SynchronousProcessingResponse> getHandleMethod;
    if ((getHandleMethod = CommandHandlerGrpc.getHandleMethod) == null) {
      synchronized (CommandHandlerGrpc.class) {
        if ((getHandleMethod = CommandHandlerGrpc.getHandleMethod) == null) {
          CommandHandlerGrpc.getHandleMethod = getHandleMethod =
              io.grpc.MethodDescriptor.<Evented.CommandBook, Evented.SynchronousProcessingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Handle"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Evented.CommandBook.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Evented.SynchronousProcessingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CommandHandlerMethodDescriptorSupplier("Handle"))
              .build();
        }
      }
    }
    return getHandleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Evented.EventBook,
      Evented.SynchronousProcessingResponse> getRecordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Record",
      requestType = Evented.EventBook.class,
      responseType = Evented.SynchronousProcessingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Evented.EventBook,
      Evented.SynchronousProcessingResponse> getRecordMethod() {
    io.grpc.MethodDescriptor<Evented.EventBook, Evented.SynchronousProcessingResponse> getRecordMethod;
    if ((getRecordMethod = CommandHandlerGrpc.getRecordMethod) == null) {
      synchronized (CommandHandlerGrpc.class) {
        if ((getRecordMethod = CommandHandlerGrpc.getRecordMethod) == null) {
          CommandHandlerGrpc.getRecordMethod = getRecordMethod =
              io.grpc.MethodDescriptor.<Evented.EventBook, Evented.SynchronousProcessingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Record"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Evented.EventBook.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Evented.SynchronousProcessingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CommandHandlerMethodDescriptorSupplier("Record"))
              .build();
        }
      }
    }
    return getRecordMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CommandHandlerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommandHandlerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommandHandlerStub>() {
        @java.lang.Override
        public CommandHandlerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommandHandlerStub(channel, callOptions);
        }
      };
    return CommandHandlerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CommandHandlerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommandHandlerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommandHandlerBlockingStub>() {
        @java.lang.Override
        public CommandHandlerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommandHandlerBlockingStub(channel, callOptions);
        }
      };
    return CommandHandlerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CommandHandlerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommandHandlerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommandHandlerFutureStub>() {
        @java.lang.Override
        public CommandHandlerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommandHandlerFutureStub(channel, callOptions);
        }
      };
    return CommandHandlerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CommandHandlerImplBase implements io.grpc.BindableService {

    /**
     */
    public void handle(Evented.CommandBook request,
                       io.grpc.stub.StreamObserver<Evented.SynchronousProcessingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getHandleMethod(), responseObserver);
    }

    /**
     */
    public void record(Evented.EventBook request,
                       io.grpc.stub.StreamObserver<Evented.SynchronousProcessingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRecordMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHandleMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Evented.CommandBook,
                Evented.SynchronousProcessingResponse>(
                  this, METHODID_HANDLE)))
          .addMethod(
            getRecordMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Evented.EventBook,
                Evented.SynchronousProcessingResponse>(
                  this, METHODID_RECORD)))
          .build();
    }
  }

  /**
   */
  public static final class CommandHandlerStub extends io.grpc.stub.AbstractAsyncStub<CommandHandlerStub> {
    private CommandHandlerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommandHandlerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommandHandlerStub(channel, callOptions);
    }

    /**
     */
    public void handle(Evented.CommandBook request,
                       io.grpc.stub.StreamObserver<Evented.SynchronousProcessingResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHandleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void record(Evented.EventBook request,
                       io.grpc.stub.StreamObserver<Evented.SynchronousProcessingResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRecordMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CommandHandlerBlockingStub extends io.grpc.stub.AbstractBlockingStub<CommandHandlerBlockingStub> {
    private CommandHandlerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommandHandlerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommandHandlerBlockingStub(channel, callOptions);
    }

    /**
     */
    public Evented.SynchronousProcessingResponse handle(Evented.CommandBook request) {
      return blockingUnaryCall(
          getChannel(), getHandleMethod(), getCallOptions(), request);
    }

    /**
     */
    public Evented.SynchronousProcessingResponse record(Evented.EventBook request) {
      return blockingUnaryCall(
          getChannel(), getRecordMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CommandHandlerFutureStub extends io.grpc.stub.AbstractFutureStub<CommandHandlerFutureStub> {
    private CommandHandlerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommandHandlerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommandHandlerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Evented.SynchronousProcessingResponse> handle(
        Evented.CommandBook request) {
      return futureUnaryCall(
          getChannel().newCall(getHandleMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Evented.SynchronousProcessingResponse> record(
        Evented.EventBook request) {
      return futureUnaryCall(
          getChannel().newCall(getRecordMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HANDLE = 0;
  private static final int METHODID_RECORD = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CommandHandlerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CommandHandlerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HANDLE:
          serviceImpl.handle((Evented.CommandBook) request,
              (io.grpc.stub.StreamObserver<Evented.SynchronousProcessingResponse>) responseObserver);
          break;
        case METHODID_RECORD:
          serviceImpl.record((Evented.EventBook) request,
              (io.grpc.stub.StreamObserver<Evented.SynchronousProcessingResponse>) responseObserver);
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

  private static abstract class CommandHandlerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CommandHandlerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Evented.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CommandHandler");
    }
  }

  private static final class CommandHandlerFileDescriptorSupplier
      extends CommandHandlerBaseDescriptorSupplier {
    CommandHandlerFileDescriptorSupplier() {}
  }

  private static final class CommandHandlerMethodDescriptorSupplier
      extends CommandHandlerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CommandHandlerMethodDescriptorSupplier(String methodName) {
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
      synchronized (CommandHandlerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CommandHandlerFileDescriptorSupplier())
              .addMethod(getHandleMethod())
              .addMethod(getRecordMethod())
              .build();
        }
      }
    }
    return result;
  }
}
