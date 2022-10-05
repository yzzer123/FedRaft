// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: log_message.proto

package org.bupt.cad.fedraft.rpc.message;

public interface LogResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:fedraft.LogResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 备用 本地模型索引
   * </pre>
   *
   * <code>uint32 local_index = 1;</code>
   * @return The localIndex.
   */
  int getLocalIndex();

    /**
     * <pre>
     * 传输模型的大小
     * </pre>
     *
     * <code>uint64 log_size = 2;</code>
     *
     * @return The logSize.
     */
    long getLogSize();

    /**
     * <code>bytes response = 3;</code>
     *
     * @return The response.
     */
    com.google.protobuf.ByteString getResponse();
}
