// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: trainer_message.proto

package org.bupt.fedraft.rpc.trainer.message;

public interface ModelClassOrBuilder extends
        // @@protoc_insertion_point(interface_extends:fedraft.ModelClass)
        com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string module = 1;</code>
     *
     * @return The module.
     */
    java.lang.String getModule();

    /**
     * <code>string module = 1;</code>
     *
     * @return The bytes for module.
     */
    com.google.protobuf.ByteString
    getModuleBytes();

    /**
     * <code>string class_name = 2;</code>
     *
     * @return The className.
     */
    java.lang.String getClassName();

    /**
     * <code>string class_name = 2;</code>
     *
     * @return The bytes for className.
     */
    com.google.protobuf.ByteString
    getClassNameBytes();

    /**
     * <code>int32 local_epoch = 3;</code>
     *
     * @return The localEpoch.
     */
    int getLocalEpoch();
}
