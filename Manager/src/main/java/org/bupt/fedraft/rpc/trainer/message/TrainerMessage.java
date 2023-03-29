// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: trainer_message.proto

package org.bupt.fedraft.rpc.trainer.message;

public final class TrainerMessage {
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_fedraft_ModelClass_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_fedraft_ModelClass_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_fedraft_InitModelRequest_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_fedraft_InitModelRequest_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_fedraft_InitModelResponse_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_fedraft_InitModelResponse_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_fedraft_TrainRequest_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_fedraft_TrainRequest_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_fedraft_TrainResponse_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_fedraft_TrainResponse_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_fedraft_PushModelRequest_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_fedraft_PushModelRequest_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_fedraft_PushModelResponse_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_fedraft_PushModelResponse_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_fedraft_MergeRequest_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_fedraft_MergeRequest_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_fedraft_MergeResponse_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_fedraft_MergeResponse_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.FileDescriptor
            descriptor;

    static {
        java.lang.String[] descriptorData = {
                "\n\025trainer_message.proto\022\007fedraft\"E\n\nMode" +
                        "lClass\022\016\n\006module\030\001 \001(\t\022\022\n\nclass_name\030\002 \001" +
                        "(\t\022\023\n\013local_epoch\030\003 \001(\005\"^\n\020InitModelRequ" +
                        "est\022*\n\013model_class\030\001 \001(\0132\023.fedraft.Model" +
                        "ClassH\000\022\025\n\013model_chunk\030\002 \001(\014H\000B\007\n\005model\"" +
                        "#\n\021InitModelResponse\022\016\n\006status\030\001 \001(\010\"#\n\014" +
                        "TrainRequest\022\023\n\013model_chunk\030\001 \001(\014\"$\n\rTra" +
                        "inResponse\022\023\n\013model_chunk\030\001 \001(\014\"G\n\020PushM" +
                        "odelRequest\022\023\n\tserver_id\030\001 \001(\004H\000\022\025\n\013mode" +
                        "l_chunk\030\002 \001(\014H\000B\007\n\005model\"#\n\021PushModelRes" +
                        "ponse\022\016\n\006status\030\001 \001(\010\"\"\n\014MergeRequest\022\022\n" +
                        "\nserver_ids\030\001 \003(\004\"^\n\rMergeResponse\022\023\n\tse" +
                        "rver_id\030\001 \001(\004H\000\022\025\n\013model_chunk\030\002 \001(\014H\000\022\030" +
                        "\n\016model_eval_log\030\003 \001(\tH\000B\007\n\005modelB(\n$org" +
                        ".bupt.fedraft.rpc.trainer.messageP\001b\006pro" +
                        "to3"
        };
        descriptor = com.google.protobuf.Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[]{
                        });
        internal_static_fedraft_ModelClass_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_fedraft_ModelClass_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_fedraft_ModelClass_descriptor,
                new java.lang.String[]{"Module", "ClassName", "LocalEpoch",});
        internal_static_fedraft_InitModelRequest_descriptor =
                getDescriptor().getMessageTypes().get(1);
        internal_static_fedraft_InitModelRequest_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_fedraft_InitModelRequest_descriptor,
                new java.lang.String[]{"ModelClass", "ModelChunk", "Model",});
        internal_static_fedraft_InitModelResponse_descriptor =
                getDescriptor().getMessageTypes().get(2);
        internal_static_fedraft_InitModelResponse_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_fedraft_InitModelResponse_descriptor,
                new java.lang.String[]{"Status",});
        internal_static_fedraft_TrainRequest_descriptor =
                getDescriptor().getMessageTypes().get(3);
        internal_static_fedraft_TrainRequest_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_fedraft_TrainRequest_descriptor,
                new java.lang.String[]{"ModelChunk",});
        internal_static_fedraft_TrainResponse_descriptor =
                getDescriptor().getMessageTypes().get(4);
        internal_static_fedraft_TrainResponse_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_fedraft_TrainResponse_descriptor,
                new java.lang.String[]{"ModelChunk",});
        internal_static_fedraft_PushModelRequest_descriptor =
                getDescriptor().getMessageTypes().get(5);
        internal_static_fedraft_PushModelRequest_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_fedraft_PushModelRequest_descriptor,
                new java.lang.String[]{"ServerId", "ModelChunk", "Model",});
        internal_static_fedraft_PushModelResponse_descriptor =
                getDescriptor().getMessageTypes().get(6);
        internal_static_fedraft_PushModelResponse_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_fedraft_PushModelResponse_descriptor,
                new java.lang.String[]{"Status",});
        internal_static_fedraft_MergeRequest_descriptor =
                getDescriptor().getMessageTypes().get(7);
        internal_static_fedraft_MergeRequest_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_fedraft_MergeRequest_descriptor,
                new java.lang.String[]{"ServerIds",});
        internal_static_fedraft_MergeResponse_descriptor =
                getDescriptor().getMessageTypes().get(8);
        internal_static_fedraft_MergeResponse_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_fedraft_MergeResponse_descriptor,
                new java.lang.String[]{"ServerId", "ModelChunk", "ModelEvalLog", "Model",});
    }

    private TrainerMessage() {
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
