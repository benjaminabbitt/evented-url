package name.benjaminabbitt.wwwwwh.where.url.projection.sample.projector;

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
    comments = "Source: evented/projector/projector.proto")
public final class ProjectorGrpc {

  private ProjectorGrpc() {}

  public static final String SERVICE_NAME = "evented.projector.Projector";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Evented.EventBook,
      Evented.Projection> getHandleSyncMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HandleSync",
      requestType = Evented.EventBook.class,
      responseType = Evented.Projection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Evented.EventBook,
      Evented.Projection> getHandleSyncMethod() {
    io.grpc.MethodDescriptor<Evented.EventBook, Evented.Projection> getHandleSyncMethod;
    if ((getHandleSyncMethod = ProjectorGrpc.getHandleSyncMethod) == null) {
      synchronized (ProjectorGrpc.class) {
        if ((getHandleSyncMethod = ProjectorGrpc.getHandleSyncMethod) == null) {
          ProjectorGrpc.getHandleSyncMethod = getHandleSyncMethod =
              io.grpc.MethodDescriptor.<Evented.EventBook, Evented.Projection>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HandleSync"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Evented.EventBook.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Evented.Projection.getDefaultInstance()))
              .setSchemaDescriptor(new ProjectorMethodDescriptorSupplier("HandleSync"))
              .build();
        }
      }
    }
    return getHandleSyncMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Evented.EventBook,
      com.google.protobuf.Empty> getHandleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Handle",
      requestType = Evented.EventBook.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Evented.EventBook,
      com.google.protobuf.Empty> getHandleMethod() {
    io.grpc.MethodDescriptor<Evented.EventBook, com.google.protobuf.Empty> getHandleMethod;
    if ((getHandleMethod = ProjectorGrpc.getHandleMethod) == null) {
      synchronized (ProjectorGrpc.class) {
        if ((getHandleMethod = ProjectorGrpc.getHandleMethod) == null) {
          ProjectorGrpc.getHandleMethod = getHandleMethod =
              io.grpc.MethodDescriptor.<Evented.EventBook, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Handle"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Evented.EventBook.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ProjectorMethodDescriptorSupplier("Handle"))
              .build();
        }
      }
    }
    return getHandleMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProjectorStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProjectorStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProjectorStub>() {
        @java.lang.Override
        public ProjectorStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProjectorStub(channel, callOptions);
        }
      };
    return ProjectorStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProjectorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProjectorBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProjectorBlockingStub>() {
        @java.lang.Override
        public ProjectorBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProjectorBlockingStub(channel, callOptions);
        }
      };
    return ProjectorBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProjectorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProjectorFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProjectorFutureStub>() {
        @java.lang.Override
        public ProjectorFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProjectorFutureStub(channel, callOptions);
        }
      };
    return ProjectorFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ProjectorImplBase implements io.grpc.BindableService {

    /**
     */
    public void handleSync(Evented.EventBook request,
                           io.grpc.stub.StreamObserver<Evented.Projection> responseObserver) {
      asyncUnimplementedUnaryCall(getHandleSyncMethod(), responseObserver);
    }

    /**
     */
    public void handle(Evented.EventBook request,
                       io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getHandleMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHandleSyncMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Evented.EventBook,
                Evented.Projection>(
                  this, METHODID_HANDLE_SYNC)))
          .addMethod(
            getHandleMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Evented.EventBook,
                com.google.protobuf.Empty>(
                  this, METHODID_HANDLE)))
          .build();
    }
  }

  /**
   */
  public static final class ProjectorStub extends io.grpc.stub.AbstractAsyncStub<ProjectorStub> {
    private ProjectorStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectorStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectorStub(channel, callOptions);
    }

    /**
     */
    public void handleSync(Evented.EventBook request,
                           io.grpc.stub.StreamObserver<Evented.Projection> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHandleSyncMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void handle(Evented.EventBook request,
                       io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHandleMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ProjectorBlockingStub extends io.grpc.stub.AbstractBlockingStub<ProjectorBlockingStub> {
    private ProjectorBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectorBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectorBlockingStub(channel, callOptions);
    }

    /**
     */
    public Evented.Projection handleSync(Evented.EventBook request) {
      return blockingUnaryCall(
          getChannel(), getHandleSyncMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty handle(Evented.EventBook request) {
      return blockingUnaryCall(
          getChannel(), getHandleMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ProjectorFutureStub extends io.grpc.stub.AbstractFutureStub<ProjectorFutureStub> {
    private ProjectorFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectorFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectorFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Evented.Projection> handleSync(
        Evented.EventBook request) {
      return futureUnaryCall(
          getChannel().newCall(getHandleSyncMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> handle(
        Evented.EventBook request) {
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
    private final ProjectorImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProjectorImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HANDLE_SYNC:
          serviceImpl.handleSync((Evented.EventBook) request,
              (io.grpc.stub.StreamObserver<Evented.Projection>) responseObserver);
          break;
        case METHODID_HANDLE:
          serviceImpl.handle((Evented.EventBook) request,
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

  private static abstract class ProjectorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProjectorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ProjectorOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Projector");
    }
  }

  private static final class ProjectorFileDescriptorSupplier
      extends ProjectorBaseDescriptorSupplier {
    ProjectorFileDescriptorSupplier() {}
  }

  private static final class ProjectorMethodDescriptorSupplier
      extends ProjectorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProjectorMethodDescriptorSupplier(String methodName) {
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
      synchronized (ProjectorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProjectorFileDescriptorSupplier())
              .addMethod(getHandleSyncMethod())
              .addMethod(getHandleMethod())
              .build();
        }
      }
    }
    return result;
  }
}
