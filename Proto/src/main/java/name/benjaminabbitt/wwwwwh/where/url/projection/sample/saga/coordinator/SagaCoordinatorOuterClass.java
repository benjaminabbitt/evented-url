// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: evented/sagaCoordinator/sagaCoordinator.proto

package name.benjaminabbitt.wwwwwh.where.url.projection.sample.saga.coordinator;

import name.benjaminabbitt.wwwwwh.where.url.projection.sample.core.Evented;

public final class SagaCoordinatorOuterClass {
  private SagaCoordinatorOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n-evented/sagaCoordinator/sagaCoordinato" +
      "r.proto\022\030evented.saga.coordinator\032\032event" +
      "ed/core/evented.proto\032\033google/protobuf/e" +
      "mpty.proto2\244\001\n\017SagaCoordinator\022T\n\nHandle" +
      "Sync\022\027.evented.core.EventBook\032+.evented." +
      "core.SynchronousProcessingResponse\"\000\022;\n\006" +
      "Handle\022\027.evented.core.EventBook\032\026.google" +
      ".protobuf.Empty\"\000BX\n,name.benjaminabbitt" +
      ".evented.saga.coordinatorZ(sagaCoordinat" +
      "or;evented_saga_coordinatorb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          Evented.getDescriptor(),
          com.google.protobuf.EmptyProto.getDescriptor(),
        });
    Evented.getDescriptor();
    com.google.protobuf.EmptyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
