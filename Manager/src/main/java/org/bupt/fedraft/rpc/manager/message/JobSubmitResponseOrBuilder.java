// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: manager_message.proto

package org.bupt.fedraft.rpc.manager.message;

public interface JobSubmitResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:fedraft.JobSubmitResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bool success = 1;</code>
   * @return Whether the success field is set.
   */
  boolean hasSuccess();
  /**
   * <code>bool success = 1;</code>
   * @return The success.
   */
  boolean getSuccess();

  /**
   * <code>string logs = 2;</code>
   * @return Whether the logs field is set.
   */
  boolean hasLogs();
  /**
   * <code>string logs = 2;</code>
   * @return The logs.
   */
  java.lang.String getLogs();
  /**
   * <code>string logs = 2;</code>
   * @return The bytes for logs.
   */
  com.google.protobuf.ByteString
      getLogsBytes();

  /**
   * <code>bytes chunk = 3;</code>
   * @return Whether the chunk field is set.
   */
  boolean hasChunk();
  /**
   * <code>bytes chunk = 3;</code>
   * @return The chunk.
   */
  com.google.protobuf.ByteString getChunk();

  org.bupt.fedraft.rpc.manager.message.JobSubmitResponse.LogCase getLogCase();
}
