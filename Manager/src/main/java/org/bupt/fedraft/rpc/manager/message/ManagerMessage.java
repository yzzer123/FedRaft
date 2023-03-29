// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: manager_message.proto

package org.bupt.fedraft.rpc.manager.message;

public final class ManagerMessage {
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_fedraft_AppendEntriesRequest_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_fedraft_AppendEntriesRequest_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_fedraft_AppendEntriesResponse_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_fedraft_AppendEntriesResponse_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_fedraft_ManagerVoteRequest_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_fedraft_ManagerVoteRequest_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_fedraft_ManagerVoteResponse_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_fedraft_ManagerVoteResponse_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_fedraft_CodeFile_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_fedraft_CodeFile_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_fedraft_JobConfiguration_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_fedraft_JobConfiguration_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_fedraft_JobSubmitRequest_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_fedraft_JobSubmitRequest_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_fedraft_JobSubmitResponse_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_fedraft_JobSubmitResponse_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.FileDescriptor
            descriptor;

    static {
        java.lang.String[] descriptorData = {
                "\n\025manager_message.proto\022\007fedraft\032\025traine" +
                        "r_message.proto\"j\n\024AppendEntriesRequest\022" +
                        "\014\n\004term\030\001 \001(\005\022\020\n\010leaderId\030\002 \001(\003\022\022\n\nentry" +
                        "Index\030\003 \001(\003\022\017\n\007nodeIds\030\004 \003(\003\022\r\n\005delay\030\005 " +
                        "\003(\005\"4\n\025AppendEntriesResponse\022\014\n\004term\030\001 \001" +
                        "(\005\022\r\n\005delay\030\002 \001(\005\"K\n\022ManagerVoteRequest\022" +
                        "\014\n\004term\030\001 \001(\005\022\023\n\013candidateId\030\002 \001(\003\022\022\n\nen" +
                        "tryIndex\030\003 \001(\003\"8\n\023ManagerVoteResponse\022\014\n" +
                        "\004term\030\001 \001(\005\022\023\n\013voteGranted\030\002 \001(\010\"*\n\010Code" +
                        "File\022\020\n\010fileName\030\001 \001(\t\022\014\n\004code\030\002 \001(\t\"\304\001\n" +
                        "\020JobConfiguration\022\014\n\004uuid\030\001 \001(\005\022\020\n\010sourc" +
                        "eId\030\002 \001(\003\022\024\n\014participants\030\003 \003(\003\022#\n\010codeF" +
                        "ile\030\004 \001(\0132\021.fedraft.CodeFile\022\024\n\014global_e" +
                        "poch\030\005 \001(\005\022\025\n\rdatasets_name\030\006 \001(\t\022(\n\013mod" +
                        "el_class\030\007 \001(\0132\023.fedraft.ModelClass\"^\n\020J" +
                        "obSubmitRequest\022)\n\004conf\030\001 \001(\0132\031.fedraft." +
                        "JobConfigurationH\000\022\024\n\nmodelChunk\030\002 \001(\014H\000" +
                        "B\t\n\007JobInfo\"N\n\021JobSubmitResponse\022\021\n\007succ" +
                        "ess\030\001 \001(\010H\000\022\016\n\004logs\030\002 \001(\tH\000\022\017\n\005chunk\030\003 \001" +
                        "(\014H\000B\005\n\003Log*8\n\rManagerStatus\022\n\n\006LEADER\020\000" +
                        "\022\r\n\tCANDIDATE\020\001\022\014\n\010FOLLOWER\020\002B(\n$org.bup" +
                        "t.fedraft.rpc.manager.messageP\001b\006proto3"
        };
        descriptor = com.google.protobuf.Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[]{
                                org.bupt.fedraft.rpc.trainer.message.TrainerMessage.getDescriptor(),
                        });
        internal_static_fedraft_AppendEntriesRequest_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_fedraft_AppendEntriesRequest_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_fedraft_AppendEntriesRequest_descriptor,
                new java.lang.String[]{"Term", "LeaderId", "EntryIndex", "NodeIds", "Delay",});
        internal_static_fedraft_AppendEntriesResponse_descriptor =
                getDescriptor().getMessageTypes().get(1);
        internal_static_fedraft_AppendEntriesResponse_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_fedraft_AppendEntriesResponse_descriptor,
                new java.lang.String[]{"Term", "Delay",});
        internal_static_fedraft_ManagerVoteRequest_descriptor =
                getDescriptor().getMessageTypes().get(2);
        internal_static_fedraft_ManagerVoteRequest_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_fedraft_ManagerVoteRequest_descriptor,
                new java.lang.String[]{"Term", "CandidateId", "EntryIndex",});
        internal_static_fedraft_ManagerVoteResponse_descriptor =
                getDescriptor().getMessageTypes().get(3);
        internal_static_fedraft_ManagerVoteResponse_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_fedraft_ManagerVoteResponse_descriptor,
                new java.lang.String[]{"Term", "VoteGranted",});
        internal_static_fedraft_CodeFile_descriptor =
                getDescriptor().getMessageTypes().get(4);
        internal_static_fedraft_CodeFile_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_fedraft_CodeFile_descriptor,
                new java.lang.String[]{"FileName", "Code",});
        internal_static_fedraft_JobConfiguration_descriptor =
                getDescriptor().getMessageTypes().get(5);
        internal_static_fedraft_JobConfiguration_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_fedraft_JobConfiguration_descriptor,
                new java.lang.String[]{"Uuid", "SourceId", "Participants", "CodeFile", "GlobalEpoch", "DatasetsName", "ModelClass",});
        internal_static_fedraft_JobSubmitRequest_descriptor =
                getDescriptor().getMessageTypes().get(6);
        internal_static_fedraft_JobSubmitRequest_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_fedraft_JobSubmitRequest_descriptor,
                new java.lang.String[]{"Conf", "ModelChunk", "JobInfo",});
        internal_static_fedraft_JobSubmitResponse_descriptor =
                getDescriptor().getMessageTypes().get(7);
        internal_static_fedraft_JobSubmitResponse_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_fedraft_JobSubmitResponse_descriptor,
                new java.lang.String[]{"Success", "Logs", "Chunk", "Log",});
        org.bupt.fedraft.rpc.trainer.message.TrainerMessage.getDescriptor();
    }

    private ManagerMessage() {
    }

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

    // @@protoc_insertion_point(outer_class_scope)
}
