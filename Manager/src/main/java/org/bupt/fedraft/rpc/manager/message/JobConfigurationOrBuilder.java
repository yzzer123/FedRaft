// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: manager_message.proto

package org.bupt.fedraft.rpc.manager.message;

public interface JobConfigurationOrBuilder extends
        // @@protoc_insertion_point(interface_extends:fedraft.JobConfiguration)
        com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 uuid = 1;</code>
     *
     * @return The uuid.
     */
    int getUuid();

    /**
     * <pre>
     * 提交任务的源节点
     * </pre>
     *
     * <code>int64 sourceId = 2;</code>
     *
     * @return The sourceId.
     */
    long getSourceId();

    /**
     * <pre>
     * 训练任务的参与者
     * </pre>
     *
     * <code>repeated int64 participants = 3;</code>
     *
     * @return A list containing the participants.
     */
    java.util.List<java.lang.Long> getParticipantsList();

    /**
     * <pre>
     * 训练任务的参与者
     * </pre>
     *
     * <code>repeated int64 participants = 3;</code>
     *
     * @return The count of participants.
     */
    int getParticipantsCount();

    /**
     * <pre>
     * 训练任务的参与者
     * </pre>
     *
     * <code>repeated int64 participants = 3;</code>
     *
     * @param index The index of the element to return.
     * @return The participants at the given index.
     */
    long getParticipants(int index);

    /**
     * <pre>
     * 任务代码
     * </pre>
     *
     * <code>.fedraft.CodeFile codeFile = 4;</code>
     *
     * @return Whether the codeFile field is set.
     */
    boolean hasCodeFile();

    /**
     * <pre>
     * 任务代码
     * </pre>
     *
     * <code>.fedraft.CodeFile codeFile = 4;</code>
     *
     * @return The codeFile.
     */
    org.bupt.fedraft.rpc.manager.message.CodeFile getCodeFile();

    /**
     * <pre>
     * 任务代码
     * </pre>
     *
     * <code>.fedraft.CodeFile codeFile = 4;</code>
     */
    org.bupt.fedraft.rpc.manager.message.CodeFileOrBuilder getCodeFileOrBuilder();
}
