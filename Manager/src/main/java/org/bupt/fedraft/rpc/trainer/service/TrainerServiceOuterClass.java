// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: trainer_service.proto

package org.bupt.fedraft.rpc.trainer.service;

public final class TrainerServiceOuterClass {
  private TrainerServiceOuterClass() {}
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
  private static final com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025trainer_service.proto\022\007fedraft\032\025traine" +
      "r_message.proto2\244\002\n\016TrainerService\022A\n\nTr" +
      "ainModel\022\025.fedraft.TrainRequest\032\026.fedraf" +
      "t.TrainResponse\"\000(\0010\001\022F\n\tPushModel\022\031.fed" +
      "raft.PushModelRequest\032\032.fedraft.PushMode" +
      "lResponse\"\000(\001\022?\n\nMergeModel\022\025.fedraft.Me" +
      "rgeRequest\032\026.fedraft.MergeResponse\"\0000\001\022F" +
      "\n\tInitModel\022\031.fedraft.InitModelRequest\032\032" +
      ".fedraft.InitModelResponse\"\000(\001B(\n$org.bu" +
      "pt.fedraft.rpc.trainer.serviceP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          org.bupt.fedraft.rpc.trainer.message.TrainerMessage.getDescriptor(),
        });
    org.bupt.fedraft.rpc.trainer.message.TrainerMessage.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
