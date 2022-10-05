// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: log_message.proto

package org.bupt.cad.fedraft.rpc.message;

public final class LogMessage {
  private LogMessage() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_fedraft_LogRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_fedraft_LogRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_fedraft_LogResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_fedraft_LogResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021log_message.proto\022\007fedraft\"\255\002\n\nLogRequ" +
              "est\022\014\n\004term\030\001 \001(\r\022\021\n\tleader_id\030\002 \001(\r\022\027\n\017" +
              "pre_model_index\030\003 \001(\r\022\026\n\016pre_model_term\030" +
              "\004 \001(\r\022-\n\010log_type\030\005 \001(\0162\033.fedraft.LogReq" +
              "uest.LogType\022\025\n\013model_chunk\030\006 \001(\014H\000\022\030\n\016n" +
              "etwork_delays\030\007 \001(\014H\000\"e\n\007LogType\022\026\n\022TRAI" +
              "NER_TO_MANAGER\020\000\022\024\n\020CLIENT_TO_LEADER\020\001\022\024" +
              "\n\020LEADER_TO_CLIENT\020\002\022\026\n\022MANAGER_TO_TRAIN" +
              "ER\020\003B\006\n\004data\"F\n\013LogResponse\022\023\n\013local_ind" +
              "ex\030\001 \001(\r\022\020\n\010log_size\030\002 \001(\004\022\020\n\010response\030\003" +
              " \001(\014B$\n org.bupt.cad.fedraft.rpc.message" +
              "P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_fedraft_LogRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_fedraft_LogRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_fedraft_LogRequest_descriptor,
        new java.lang.String[] { "Term", "LeaderId", "PreModelIndex", "PreModelTerm", "LogType", "ModelChunk", "NetworkDelays", "Data", });
      internal_static_fedraft_LogResponse_descriptor =
              getDescriptor().getMessageTypes().get(1);
      internal_static_fedraft_LogResponse_fieldAccessorTable = new
              com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
              internal_static_fedraft_LogResponse_descriptor,
              new java.lang.String[]{"LocalIndex", "LogSize", "Response",});
  }

  // @@protoc_insertion_point(outer_class_scope)
}
