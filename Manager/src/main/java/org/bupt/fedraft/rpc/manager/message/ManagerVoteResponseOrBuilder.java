// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: manager_message.proto

package org.bupt.fedraft.rpc.manager.message;

public interface ManagerVoteResponseOrBuilder extends
        // @@protoc_insertion_point(interface_extends:fedraft.ManagerVoteResponse)
        com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 term = 1;</code>
     *
     * @return The term.
     */
    int getTerm();

    /**
     * <pre>
     * 是否投票
     * </pre>
     *
     * <code>bool voteGranted = 2;</code>
     *
     * @return The voteGranted.
     */
    boolean getVoteGranted();
}
