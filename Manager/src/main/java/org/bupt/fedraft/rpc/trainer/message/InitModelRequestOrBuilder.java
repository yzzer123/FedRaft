// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: trainer_message.proto

package org.bupt.fedraft.rpc.trainer.message;

public interface InitModelRequestOrBuilder extends
        // @@protoc_insertion_point(interface_extends:fedraft.InitModelRequest)
        com.google.protobuf.MessageOrBuilder {

    /**
     * <code>.fedraft.ModelClass model_class = 1;</code>
     *
     * @return Whether the modelClass field is set.
     */
    boolean hasModelClass();

    /**
     * <code>.fedraft.ModelClass model_class = 1;</code>
     *
     * @return The modelClass.
     */
    org.bupt.fedraft.rpc.trainer.message.ModelClass getModelClass();

    /**
     * <code>.fedraft.ModelClass model_class = 1;</code>
     */
    org.bupt.fedraft.rpc.trainer.message.ModelClassOrBuilder getModelClassOrBuilder();

    /**
     * <code>bytes model_chunk = 2;</code>
     *
     * @return Whether the modelChunk field is set.
     */
    boolean hasModelChunk();

    /**
     * <code>bytes model_chunk = 2;</code>
     *
     * @return The modelChunk.
     */
    com.google.protobuf.ByteString getModelChunk();

    org.bupt.fedraft.rpc.trainer.message.InitModelRequest.ModelCase getModelCase();
}
