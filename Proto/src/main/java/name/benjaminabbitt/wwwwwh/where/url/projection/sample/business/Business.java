// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: evented/business/business.proto

package name.benjaminabbitt.wwwwwh.where.url.projection.sample.business;

import name.benjaminabbitt.wwwwwh.where.url.projection.sample.core.Evented;

public final class Business {
  private Business() {}
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
      "\n\037evented/business/business.proto\022\020event" +
      "ed.business\032\032evented/core/evented.proto2" +
      "U\n\rBusinessLogic\022D\n\006Handle\022\037.evented.cor" +
      "e.ContextualCommand\032\027.evented.core.Event" +
      "Book\"\000BA\n$name.benjaminabbitt.evented.bu" +
      "sinessZ\031business;evented_businessb\006proto" +
      "3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          Evented.getDescriptor(),
        });
    Evented.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
