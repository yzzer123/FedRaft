// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: log_message.proto

package org.bupt.cad.fedraft.rpc.message;

public interface LogRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:fedraft.LogRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint32 term = 1;</code>
   * @return The term.
   */
  int getTerm();

    /**
     * <code>uint64 leader_id = 2;</code>
     *
     * @return The leaderId.
     */
    long getLeaderId();

    /**
     * <code>uint32 model_index = 3;</code>
     *
     * @return The modelIndex.
     */
    int getModelIndex();

    /**
     * <pre>
     * 标记日志请求来源
     * </pre>
     *
     * <code>.fedraft.LogType log_type = 4;</code>
     *
     * @return The enum numeric value on the wire for logType.
     */
    int getLogTypeValue();

    /**
     * <pre>
     * 标记日志请求来源
     * </pre>
     *
     * <code>.fedraft.LogType log_type = 4;</code>
     *
     * @return The logType.
     */
    org.bupt.cad.fedraft.rpc.message.LogType getLogType();

    /**
     * <pre>
     * 模型的序列化块
     * </pre>
     *
     * <code>bytes model_chunk = 5;</code>
     *
     * @return The modelChunk.
     */
    com.google.protobuf.ByteString getModelChunk();
}
