// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: jobmanager_message.proto

package org.bupt.fedraft.rpc.jobmanager.message;

public interface JobVoteRequestOrBuilder extends
        // @@protoc_insertion_point(interface_extends:fedraft.JobVoteRequest)
        com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 term = 1;</code>
     *
     * @return The term.
     */
    int getTerm();

    /**
     * <code>int64 candidateId = 2;</code>
     *
     * @return The candidateId.
     */
    long getCandidateId();

    /**
     * <pre>
     * 拓扑索引
     * </pre>
     *
     * <code>int64 modelIndex = 3;</code>
     *
     * @return The modelIndex.
     */
    long getModelIndex();

    /**
     * <code>int32 modelTerm = 4;</code>
     *
     * @return The modelTerm.
     */
    int getModelTerm();
}
