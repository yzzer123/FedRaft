// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: jobmanager_message.proto

package org.bupt.fedraft.rpc.jobmanager.message;

public interface AppendModelsRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:fedraft.AppendModelsRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 term = 1;</code>
   * @return The term.
   */
  int getTerm();

  /**
   * <code>int64 leaderId = 2;</code>
   * @return The leaderId.
   */
  long getLeaderId();

  /**
   * <code>int64 modelIndex = 3;</code>
   * @return The modelIndex.
   */
  long getModelIndex();

  /**
   * <code>bool canSendModel = 4;</code>
   * @return The canSendModel.
   */
  boolean getCanSendModel();
}
