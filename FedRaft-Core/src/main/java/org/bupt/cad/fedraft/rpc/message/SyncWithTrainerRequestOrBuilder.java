// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: heartbeat_message.proto

package org.bupt.cad.fedraft.rpc.message;

public interface SyncWithTrainerRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:fedraft.SyncWithTrainerRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint32 term = 1;</code>
   * @return The term.
   */
  int getTerm();

  /**
   * <code>uint64 leader_id = 2;</code>
   * @return The leaderId.
   */
  long getLeaderId();

  /**
   * <pre>
   * 当前节点模型的索引
   * </pre>
   *
   * <code>uint32 current_model_index = 3;</code>
   * @return The currentModelIndex.
   */
  int getCurrentModelIndex();

  /**
   * <code>uint64 timestamp = 4;</code>
   * @return The timestamp.
   */
  long getTimestamp();

  /**
   * <code>.fedraft.NodeState node_state = 5;</code>
   * @return The enum numeric value on the wire for nodeState.
   */
  int getNodeStateValue();
  /**
   * <code>.fedraft.NodeState node_state = 5;</code>
   * @return The nodeState.
   */
  org.bupt.cad.fedraft.rpc.message.NodeState getNodeState();

  /**
   * <code>repeated uint64 node_ids = 6;</code>
   * @return A list containing the nodeIds.
   */
  java.util.List<java.lang.Long> getNodeIdsList();
  /**
   * <code>repeated uint64 node_ids = 6;</code>
   * @return The count of nodeIds.
   */
  int getNodeIdsCount();
  /**
   * <code>repeated uint64 node_ids = 6;</code>
   * @param index The index of the element to return.
   * @return The nodeIds at the given index.
   */
  long getNodeIds(int index);
}
