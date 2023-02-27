// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vote_massage.proto

package org.bupt.cad.fedraft.rpc.message;

public interface VoteRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:fedraft.VoteRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint32 term = 1;</code>
   * @return The term.
   */
  int getTerm();

  /**
   * <code>uint64 candidate_id = 2;</code>
   * @return The candidateId.
   */
  long getCandidateId();

  /**
   * <code>uint32 model_index = 3;</code>
   * @return The modelIndex.
   */
  int getModelIndex();

  /**
   * <pre>
   * 请求投票时顺便发送时延投票，防止投票失败，时延拓扑过旧
   * </pre>
   *
   * <code>repeated uint64 node_ids = 5;</code>
   * @return A list containing the nodeIds.
   */
  java.util.List<java.lang.Long> getNodeIdsList();
  /**
   * <pre>
   * 请求投票时顺便发送时延投票，防止投票失败，时延拓扑过旧
   * </pre>
   *
   * <code>repeated uint64 node_ids = 5;</code>
   * @return The count of nodeIds.
   */
  int getNodeIdsCount();
  /**
   * <pre>
   * 请求投票时顺便发送时延投票，防止投票失败，时延拓扑过旧
   * </pre>
   *
   * <code>repeated uint64 node_ids = 5;</code>
   * @param index The index of the element to return.
   * @return The nodeIds at the given index.
   */
  long getNodeIds(int index);

  /**
   * <code>repeated uint32 network_delays = 6;</code>
   * @return A list containing the networkDelays.
   */
  java.util.List<java.lang.Integer> getNetworkDelaysList();
  /**
   * <code>repeated uint32 network_delays = 6;</code>
   * @return The count of networkDelays.
   */
  int getNetworkDelaysCount();
  /**
   * <code>repeated uint32 network_delays = 6;</code>
   * @param index The index of the element to return.
   * @return The networkDelays at the given index.
   */
  int getNetworkDelays(int index);
}