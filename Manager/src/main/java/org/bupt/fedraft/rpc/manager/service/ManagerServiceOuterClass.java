// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: manager_service.proto

package org.bupt.fedraft.rpc.manager.service;

public final class ManagerServiceOuterClass {
  private ManagerServiceOuterClass() {}
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
      "\n\025manager_service.proto\022\007fedraft\032\025manage" +
      "r_message.proto\032\030jobmanager_message.prot" +
      "o2\300\002\n\016ManagerService\022P\n\rAppendEntries\022\035." +
      "fedraft.AppendEntriesRequest\032\036.fedraft.A" +
      "ppendEntriesResponse\"\000\022F\n\007VoteFor\022\033.fedr" +
      "aft.ManagerVoteRequest\032\034.fedraft.Manager" +
      "VoteResponse\"\000\022H\n\tJobSubmit\022\031.fedraft.Jo" +
      "bSubmitRequest\032\032.fedraft.JobSubmitRespon" +
      "se\"\000(\0010\001\022J\n\013JobShutdown\022\033.fedraft.JobShu" +
      "tdownRequest\032\034.fedraft.JobShutdownRespon" +
      "se\"\0002\212\003\n\021JobManagerService\022J\n\tAppendLog\022" +
      "\034.fedraft.AppendJobLogRequest\032\035.fedraft." +
      "AppendJobLogResponse\"\000\022M\n\014AppendModels\022\034" +
      ".fedraft.AppendModelsRequest\032\035.fedraft.A" +
      "ppendModelsResponse\"\000\022>\n\007JobVote\022\027.fedra" +
      "ft.JobVoteRequest\032\030.fedraft.JobVoteRespo" +
      "nse\"\000\022L\n\tPullModel\022\034.fedraft.JobPullMode" +
      "lRequest\032\035.fedraft.JobPullModelResponse\"" +
      "\0000\001\022L\n\tPushModel\022\034.fedraft.JobPushModelR" +
      "equest\032\035.fedraft.JobPushModelResponse\"\000(" +
      "\001B(\n$org.bupt.fedraft.rpc.manager.servic" +
      "eP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          org.bupt.fedraft.rpc.manager.message.ManagerMessage.getDescriptor(),
          org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.getDescriptor(),
        });
    org.bupt.fedraft.rpc.manager.message.ManagerMessage.getDescriptor();
    org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
