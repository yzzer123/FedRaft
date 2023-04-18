// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: trainer_message.proto

package org.bupt.fedraft.rpc.trainer.message;

public interface MergeResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:fedraft.MergeResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 回复第一个缺失的模型ID
   * </pre>
   *
   * <code>uint64 server_id = 1;</code>
   * @return Whether the serverId field is set.
   */
  boolean hasServerId();
  /**
   * <pre>
   * 回复第一个缺失的模型ID
   * </pre>
   *
   * <code>uint64 server_id = 1;</code>
   * @return The serverId.
   */
  long getServerId();

  /**
   * <pre>
   * 合并成功的模型
   * </pre>
   *
   * <code>bytes model_chunk = 2;</code>
   * @return Whether the modelChunk field is set.
   */
  boolean hasModelChunk();
  /**
   * <pre>
   * 合并成功的模型
   * </pre>
   *
   * <code>bytes model_chunk = 2;</code>
   * @return The modelChunk.
   */
  com.google.protobuf.ByteString getModelChunk();

  /**
   * <pre>
   * 合并模型的测试结果
   * </pre>
   *
   * <code>string model_eval_log = 3;</code>
   * @return Whether the modelEvalLog field is set.
   */
  boolean hasModelEvalLog();
  /**
   * <pre>
   * 合并模型的测试结果
   * </pre>
   *
   * <code>string model_eval_log = 3;</code>
   * @return The modelEvalLog.
   */
  java.lang.String getModelEvalLog();
  /**
   * <pre>
   * 合并模型的测试结果
   * </pre>
   *
   * <code>string model_eval_log = 3;</code>
   * @return The bytes for modelEvalLog.
   */
  com.google.protobuf.ByteString
      getModelEvalLogBytes();

  org.bupt.fedraft.rpc.trainer.message.MergeResponse.ModelCase getModelCase();
}
