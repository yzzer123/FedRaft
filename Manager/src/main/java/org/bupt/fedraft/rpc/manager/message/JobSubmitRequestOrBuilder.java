// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: manager_message.proto

package org.bupt.fedraft.rpc.manager.message;

public interface JobSubmitRequestOrBuilder extends
        // @@protoc_insertion_point(interface_extends:fedraft.JobSubmitRequest)
        com.google.protobuf.MessageOrBuilder {

    /**
     * <code>.fedraft.JobConfiguration conf = 1;</code>
     *
     * @return Whether the conf field is set.
     */
    boolean hasConf();

    /**
     * <code>.fedraft.JobConfiguration conf = 1;</code>
     *
     * @return The conf.
     */
  org.bupt.fedraft.rpc.manager.message.JobConfiguration getConf();
  /**
   * <code>.fedraft.JobConfiguration conf = 1;</code>
   */
  org.bupt.fedraft.rpc.manager.message.JobConfigurationOrBuilder getConfOrBuilder();

  /**
   * <code>bytes modelChunk = 2;</code>
   * @return Whether the modelChunk field is set.
   */
  boolean hasModelChunk();
  /**
   * <code>bytes modelChunk = 2;</code>
   * @return The modelChunk.
   */
  com.google.protobuf.ByteString getModelChunk();

  org.bupt.fedraft.rpc.manager.message.JobSubmitRequest.JobInfoCase getJobInfoCase();
}
