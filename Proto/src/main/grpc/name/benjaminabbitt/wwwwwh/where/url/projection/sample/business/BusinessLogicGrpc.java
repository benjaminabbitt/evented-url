package name.benjaminabbitt.wwwwwh.where.url.projection.sample.business;

import name.benjaminabbitt.wwwwwh.where.url.projection.sample.core.Evented;

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
    comments = "Source: evented/business/business.proto")
public final class BusinessLogicGrpc {

  private BusinessLogicGrpc() {}

  public static final String SERVICE_NAME = "evented.business.BusinessLogic";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Evented.ContextualCommand,
      Evented.EventBook> getHandleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Handle",
      requestType = Evented.ContextualCommand.class,
      responseType = Evented.EventBook.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Evented.ContextualCommand,
      Evented.EventBook> getHandleMethod() {
    io.grpc.MethodDescriptor<Evented.ContextualCommand, Evented.EventBook> getHandleMethod;
    if ((getHandleMethod = BusinessLogicGrpc.getHandleMethod) == null) {
      synchronized (BusinessLogicGrpc.class) {
        if ((getHandleMethod = BusinessLogicGrpc.getHandleMethod) == null) {
          BusinessLogicGrpc.getHandleMethod = getHandleMethod =
              io.grpc.MethodDescriptor.<Evented.ContextualCommand, Evented.EventBook>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Handle"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Evented.ContextualCommand.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Evented.EventBook.getDefaultInstance()))
              .setSchemaDescriptor(new BusinessLogicMethodDescriptorSupplier("Handle"))
              .build();
        }
      }
    }
    return getHandleMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BusinessLogicStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BusinessLogicStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BusinessLogicStub>() {
        @java.lang.Override
        public BusinessLogicStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BusinessLogicStub(channel, callOptions);
        }
      };
    return BusinessLogicStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BusinessLogicBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BusinessLogicBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BusinessLogicBlockingStub>() {
        @java.lang.Override
        public BusinessLogicBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BusinessLogicBlockingStub(channel, callOptions);
        }
      };
    return BusinessLogicBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BusinessLogicFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BusinessLogicFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BusinessLogicFutureStub>() {
        @java.lang.Override
        public BusinessLogicFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BusinessLogicFutureStub(channel, callOptions);
        }
      };
    return BusinessLogicFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class BusinessLogicImplBase implements io.grpc.BindableService {

    /**
     */
    public void handle(Evented.ContextualCommand request,
                       io.grpc.stub.StreamObserver<Evented.EventBook> responseObserver) {
      asyncUnimplementedUnaryCall(getHandleMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHandleMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Evented.ContextualCommand,
                Evented.EventBook>(
                  this, METHODID_HANDLE)))
          .build();
    }
  }

  /**
   */
  public static final class BusinessLogicStub extends io.grpc.stub.AbstractAsyncStub<BusinessLogicStub> {
    private BusinessLogicStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BusinessLogicStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BusinessLogicStub(channel, callOptions);
    }

    /**
     */
    public void handle(Evented.ContextualCommand request,
                       io.grpc.stub.StreamObserver<Evented.EventBook> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHandleMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BusinessLogicBlockingStub extends io.grpc.stub.AbstractBlockingStub<BusinessLogicBlockingStub> {
    private BusinessLogicBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BusinessLogicBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BusinessLogicBlockingStub(channel, callOptions);
    }

    /**
     */
    public Evented.EventBook handle(Evented.ContextualCommand request) {
      return blockingUnaryCall(
          getChannel(), getHandleMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BusinessLogicFutureStub extends io.grpc.stub.AbstractFutureStub<BusinessLogicFutureStub> {
    private BusinessLogicFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BusinessLogicFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BusinessLogicFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Evented.EventBook> handle(
        Evented.ContextualCommand request) {
      return futureUnaryCall(
          getChannel().newCall(getHandleMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HANDLE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BusinessLogicImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BusinessLogicImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HANDLE:
          serviceImpl.handle((Evented.ContextualCommand) request,
              (io.grpc.stub.StreamObserver<Evented.EventBook>) responseObserver);
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

  private static abstract class BusinessLogicBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BusinessLogicBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Business.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BusinessLogic");
    }
  }

  private static final class BusinessLogicFileDescriptorSupplier
      extends BusinessLogicBaseDescriptorSupplier {
    BusinessLogicFileDescriptorSupplier() {}
  }

  private static final class BusinessLogicMethodDescriptorSupplier
      extends BusinessLogicBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BusinessLogicMethodDescriptorSupplier(String methodName) {
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
      synchronized (BusinessLogicGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BusinessLogicFileDescriptorSupplier())
              .addMethod(getHandleMethod())
              .build();
        }
      }
    }
    return result;
  }
}
