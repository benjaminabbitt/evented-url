package name.benjaminabbitt.evented.core.query;

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
    comments = "Source: evented/query/query.proto")
public final class EventQueryGrpc {

  private EventQueryGrpc() {}

  public static final String SERVICE_NAME = "evented.query.EventQuery";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<name.benjaminabbitt.evented.core.query.QueryOuterClass.Query,
      name.benjaminabbitt.evented.core.Evented.EventBook> getGetEventsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEvents",
      requestType = name.benjaminabbitt.evented.core.query.QueryOuterClass.Query.class,
      responseType = name.benjaminabbitt.evented.core.Evented.EventBook.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<name.benjaminabbitt.evented.core.query.QueryOuterClass.Query,
      name.benjaminabbitt.evented.core.Evented.EventBook> getGetEventsMethod() {
    io.grpc.MethodDescriptor<name.benjaminabbitt.evented.core.query.QueryOuterClass.Query, name.benjaminabbitt.evented.core.Evented.EventBook> getGetEventsMethod;
    if ((getGetEventsMethod = EventQueryGrpc.getGetEventsMethod) == null) {
      synchronized (EventQueryGrpc.class) {
        if ((getGetEventsMethod = EventQueryGrpc.getGetEventsMethod) == null) {
          EventQueryGrpc.getGetEventsMethod = getGetEventsMethod =
              io.grpc.MethodDescriptor.<name.benjaminabbitt.evented.core.query.QueryOuterClass.Query, name.benjaminabbitt.evented.core.Evented.EventBook>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEvents"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  name.benjaminabbitt.evented.core.query.QueryOuterClass.Query.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  name.benjaminabbitt.evented.core.Evented.EventBook.getDefaultInstance()))
              .setSchemaDescriptor(new EventQueryMethodDescriptorSupplier("GetEvents"))
              .build();
        }
      }
    }
    return getGetEventsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<name.benjaminabbitt.evented.core.query.QueryOuterClass.Query,
      name.benjaminabbitt.evented.core.Evented.EventBook> getSynchronizeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Synchronize",
      requestType = name.benjaminabbitt.evented.core.query.QueryOuterClass.Query.class,
      responseType = name.benjaminabbitt.evented.core.Evented.EventBook.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<name.benjaminabbitt.evented.core.query.QueryOuterClass.Query,
      name.benjaminabbitt.evented.core.Evented.EventBook> getSynchronizeMethod() {
    io.grpc.MethodDescriptor<name.benjaminabbitt.evented.core.query.QueryOuterClass.Query, name.benjaminabbitt.evented.core.Evented.EventBook> getSynchronizeMethod;
    if ((getSynchronizeMethod = EventQueryGrpc.getSynchronizeMethod) == null) {
      synchronized (EventQueryGrpc.class) {
        if ((getSynchronizeMethod = EventQueryGrpc.getSynchronizeMethod) == null) {
          EventQueryGrpc.getSynchronizeMethod = getSynchronizeMethod =
              io.grpc.MethodDescriptor.<name.benjaminabbitt.evented.core.query.QueryOuterClass.Query, name.benjaminabbitt.evented.core.Evented.EventBook>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Synchronize"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  name.benjaminabbitt.evented.core.query.QueryOuterClass.Query.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  name.benjaminabbitt.evented.core.Evented.EventBook.getDefaultInstance()))
              .setSchemaDescriptor(new EventQueryMethodDescriptorSupplier("Synchronize"))
              .build();
        }
      }
    }
    return getSynchronizeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      name.benjaminabbitt.evented.core.query.QueryOuterClass.AggregateRoot> getGetAggregateRootsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAggregateRoots",
      requestType = com.google.protobuf.Empty.class,
      responseType = name.benjaminabbitt.evented.core.query.QueryOuterClass.AggregateRoot.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      name.benjaminabbitt.evented.core.query.QueryOuterClass.AggregateRoot> getGetAggregateRootsMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, name.benjaminabbitt.evented.core.query.QueryOuterClass.AggregateRoot> getGetAggregateRootsMethod;
    if ((getGetAggregateRootsMethod = EventQueryGrpc.getGetAggregateRootsMethod) == null) {
      synchronized (EventQueryGrpc.class) {
        if ((getGetAggregateRootsMethod = EventQueryGrpc.getGetAggregateRootsMethod) == null) {
          EventQueryGrpc.getGetAggregateRootsMethod = getGetAggregateRootsMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, name.benjaminabbitt.evented.core.query.QueryOuterClass.AggregateRoot>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAggregateRoots"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  name.benjaminabbitt.evented.core.query.QueryOuterClass.AggregateRoot.getDefaultInstance()))
              .setSchemaDescriptor(new EventQueryMethodDescriptorSupplier("GetAggregateRoots"))
              .build();
        }
      }
    }
    return getGetAggregateRootsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EventQueryStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventQueryStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventQueryStub>() {
        @java.lang.Override
        public EventQueryStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventQueryStub(channel, callOptions);
        }
      };
    return EventQueryStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EventQueryBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventQueryBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventQueryBlockingStub>() {
        @java.lang.Override
        public EventQueryBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventQueryBlockingStub(channel, callOptions);
        }
      };
    return EventQueryBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EventQueryFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventQueryFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventQueryFutureStub>() {
        @java.lang.Override
        public EventQueryFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventQueryFutureStub(channel, callOptions);
        }
      };
    return EventQueryFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class EventQueryImplBase implements io.grpc.BindableService {

    /**
     */
    public void getEvents(name.benjaminabbitt.evented.core.query.QueryOuterClass.Query request,
        io.grpc.stub.StreamObserver<name.benjaminabbitt.evented.core.Evented.EventBook> responseObserver) {
      asyncUnimplementedUnaryCall(getGetEventsMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<name.benjaminabbitt.evented.core.query.QueryOuterClass.Query> synchronize(
        io.grpc.stub.StreamObserver<name.benjaminabbitt.evented.core.Evented.EventBook> responseObserver) {
      return asyncUnimplementedStreamingCall(getSynchronizeMethod(), responseObserver);
    }

    /**
     */
    public void getAggregateRoots(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<name.benjaminabbitt.evented.core.query.QueryOuterClass.AggregateRoot> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAggregateRootsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetEventsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                name.benjaminabbitt.evented.core.query.QueryOuterClass.Query,
                name.benjaminabbitt.evented.core.Evented.EventBook>(
                  this, METHODID_GET_EVENTS)))
          .addMethod(
            getSynchronizeMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                name.benjaminabbitt.evented.core.query.QueryOuterClass.Query,
                name.benjaminabbitt.evented.core.Evented.EventBook>(
                  this, METHODID_SYNCHRONIZE)))
          .addMethod(
            getGetAggregateRootsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                name.benjaminabbitt.evented.core.query.QueryOuterClass.AggregateRoot>(
                  this, METHODID_GET_AGGREGATE_ROOTS)))
          .build();
    }
  }

  /**
   */
  public static final class EventQueryStub extends io.grpc.stub.AbstractAsyncStub<EventQueryStub> {
    private EventQueryStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventQueryStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventQueryStub(channel, callOptions);
    }

    /**
     */
    public void getEvents(name.benjaminabbitt.evented.core.query.QueryOuterClass.Query request,
        io.grpc.stub.StreamObserver<name.benjaminabbitt.evented.core.Evented.EventBook> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetEventsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<name.benjaminabbitt.evented.core.query.QueryOuterClass.Query> synchronize(
        io.grpc.stub.StreamObserver<name.benjaminabbitt.evented.core.Evented.EventBook> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getSynchronizeMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void getAggregateRoots(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<name.benjaminabbitt.evented.core.query.QueryOuterClass.AggregateRoot> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetAggregateRootsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EventQueryBlockingStub extends io.grpc.stub.AbstractBlockingStub<EventQueryBlockingStub> {
    private EventQueryBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventQueryBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventQueryBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<name.benjaminabbitt.evented.core.Evented.EventBook> getEvents(
        name.benjaminabbitt.evented.core.query.QueryOuterClass.Query request) {
      return blockingServerStreamingCall(
          getChannel(), getGetEventsMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<name.benjaminabbitt.evented.core.query.QueryOuterClass.AggregateRoot> getAggregateRoots(
        com.google.protobuf.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getGetAggregateRootsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EventQueryFutureStub extends io.grpc.stub.AbstractFutureStub<EventQueryFutureStub> {
    private EventQueryFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventQueryFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventQueryFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_EVENTS = 0;
  private static final int METHODID_GET_AGGREGATE_ROOTS = 1;
  private static final int METHODID_SYNCHRONIZE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EventQueryImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EventQueryImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_EVENTS:
          serviceImpl.getEvents((name.benjaminabbitt.evented.core.query.QueryOuterClass.Query) request,
              (io.grpc.stub.StreamObserver<name.benjaminabbitt.evented.core.Evented.EventBook>) responseObserver);
          break;
        case METHODID_GET_AGGREGATE_ROOTS:
          serviceImpl.getAggregateRoots((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<name.benjaminabbitt.evented.core.query.QueryOuterClass.AggregateRoot>) responseObserver);
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
        case METHODID_SYNCHRONIZE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.synchronize(
              (io.grpc.stub.StreamObserver<name.benjaminabbitt.evented.core.Evented.EventBook>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class EventQueryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EventQueryBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return name.benjaminabbitt.evented.core.query.QueryOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EventQuery");
    }
  }

  private static final class EventQueryFileDescriptorSupplier
      extends EventQueryBaseDescriptorSupplier {
    EventQueryFileDescriptorSupplier() {}
  }

  private static final class EventQueryMethodDescriptorSupplier
      extends EventQueryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EventQueryMethodDescriptorSupplier(String methodName) {
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
      synchronized (EventQueryGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EventQueryFileDescriptorSupplier())
              .addMethod(getGetEventsMethod())
              .addMethod(getSynchronizeMethod())
              .addMethod(getGetAggregateRootsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
