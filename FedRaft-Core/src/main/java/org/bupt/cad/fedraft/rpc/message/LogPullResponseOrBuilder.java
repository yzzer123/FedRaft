// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: log_message.proto

package org.bupt.cad.fedraft.rpc.message;

public interface LogPullResponseOrBuilder extends
        // @@protoc_insertion_point(interface_extends:fedraft.LogPullResponse)
        com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     * 模型的序列化块
     * </pre>
     *
     * <code>bytes model_chunk = 1;</code>
     *
     * @return The modelChunk.
     */
    com.google.protobuf.ByteString getModelChunk();

    /**
     * <code>uint32 model_index = 2;</code>
     *
     * @return The modelIndex.
     */
    int getModelIndex();
}
