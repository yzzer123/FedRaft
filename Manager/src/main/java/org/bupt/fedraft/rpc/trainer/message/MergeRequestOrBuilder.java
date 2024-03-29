// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: trainer_message.proto

package org.bupt.fedraft.rpc.trainer.message;

public interface MergeRequestOrBuilder extends
        // @@protoc_insertion_point(interface_extends:fedraft.MergeRequest)
        com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     * 接受到的模型来源， 确认Trainer是否存在
     * </pre>
     *
     * <code>repeated uint64 server_ids = 1;</code>
     *
     * @return A list containing the serverIds.
     */
    java.util.List<java.lang.Long> getServerIdsList();

    /**
     * <pre>
     * 接受到的模型来源， 确认Trainer是否存在
     * </pre>
     *
     * <code>repeated uint64 server_ids = 1;</code>
     *
     * @return The count of serverIds.
     */
    int getServerIdsCount();

    /**
     * <pre>
     * 接受到的模型来源， 确认Trainer是否存在
     * </pre>
     *
     * <code>repeated uint64 server_ids = 1;</code>
     *
     * @param index The index of the element to return.
     * @return The serverIds at the given index.
     */
    long getServerIds(int index);
}
