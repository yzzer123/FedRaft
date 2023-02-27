// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: heartbeat_message.proto

package org.bupt.cad.fedraft.rpc.message;

/**
 * Protobuf type {@code fedraft.HeartbeatRequest}
 */
public final class HeartbeatRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:fedraft.HeartbeatRequest)
    HeartbeatRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use HeartbeatRequest.newBuilder() to construct.
  private HeartbeatRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private HeartbeatRequest() {
    leaderState_ = 0;
    nodeIds_ = emptyLongList();
    networkDelays_ = emptyIntList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new HeartbeatRequest();
  }

  @java.lang.Override
  public com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final int TERM_FIELD_NUMBER = 1;

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.bupt.cad.fedraft.rpc.message.HeartbeatMessage.internal_static_fedraft_HeartbeatRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.bupt.cad.fedraft.rpc.message.HeartbeatRequest.class, org.bupt.cad.fedraft.rpc.message.HeartbeatRequest.Builder.class);
  }
  public static final int LEADER_ID_FIELD_NUMBER = 2;
  public static final int LEADER_STATE_FIELD_NUMBER = 3;
  /**
   * <code>uint32 term = 1;</code>
   * @return The term.
   */
  @java.lang.Override
  public int getTerm() {
    return term_;
  }
  public static final int LEADER_MODEL_INDEX_FIELD_NUMBER = 4;
  public static final int TIMESTAMP_FIELD_NUMBER = 5;
  /**
   * <code>uint64 leader_id = 2;</code>
   * @return The leaderId.
   */
  @java.lang.Override
  public long getLeaderId() {
    return leaderId_;
  }
  public static final int NODE_IDS_FIELD_NUMBER = 6;
  public static final int NETWORK_DELAYS_FIELD_NUMBER = 7;
  /**
   * <code>.fedraft.NodeState leader_state = 3;</code>
   * @return The enum numeric value on the wire for leaderState.
   */
  @java.lang.Override public int getLeaderStateValue() {
    return leaderState_;
  }
  /**
   * <code>.fedraft.NodeState leader_state = 3;</code>
   * @return The leaderState.
   */
  @java.lang.Override public org.bupt.cad.fedraft.rpc.message.NodeState getLeaderState() {
    @SuppressWarnings("deprecation")
    org.bupt.cad.fedraft.rpc.message.NodeState result = org.bupt.cad.fedraft.rpc.message.NodeState.valueOf(leaderState_);
    return result == null ? org.bupt.cad.fedraft.rpc.message.NodeState.UNRECOGNIZED : result;
  }
  // @@protoc_insertion_point(class_scope:fedraft.HeartbeatRequest)
  private static final org.bupt.cad.fedraft.rpc.message.HeartbeatRequest DEFAULT_INSTANCE;
  private static final com.google.protobuf.Parser<HeartbeatRequest>
      PARSER = new com.google.protobuf.AbstractParser<HeartbeatRequest>() {
    @java.lang.Override
    public HeartbeatRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };
  /**
   * <pre>
   * 之前发送模型的任期
   * </pre>
   *
   * <code>uint32 leader_model_index = 4;</code>
   * @return The leaderModelIndex.
   */
  @java.lang.Override
  public int getLeaderModelIndex() {
    return leaderModelIndex_;
  }

  static {
    DEFAULT_INSTANCE = new org.bupt.cad.fedraft.rpc.message.HeartbeatRequest();
  }

  private int term_;
  /**
   * <code>uint64 timestamp = 5;</code>
   * @return The timestamp.
   */
  @java.lang.Override
  public long getTimestamp() {
    return timestamp_;
  }
  private long leaderId_;
  private int leaderState_;
  /**
   * <code>repeated uint64 node_ids = 6;</code>
   * @return A list containing the nodeIds.
   */
  @java.lang.Override
  public java.util.List<java.lang.Long>
      getNodeIdsList() {
    return nodeIds_;
  }
  /**
   * <code>repeated uint64 node_ids = 6;</code>
   * @return The count of nodeIds.
   */
  public int getNodeIdsCount() {
    return nodeIds_.size();
  }
  /**
   * <code>repeated uint64 node_ids = 6;</code>
   * @param index The index of the element to return.
   * @return The nodeIds at the given index.
   */
  public long getNodeIds(int index) {
    return nodeIds_.getLong(index);
  }
  private int nodeIdsMemoizedSerializedSize = -1;
  private int leaderModelIndex_;
  private com.google.protobuf.Internal.IntList networkDelays_;
  /**
   * <pre>
   * 网络时延拓扑
   * </pre>
   *
   * <code>repeated int32 network_delays = 7;</code>
   * @return A list containing the networkDelays.
   */
  @java.lang.Override
  public java.util.List<java.lang.Integer>
      getNetworkDelaysList() {
    return networkDelays_;
  }
  /**
   * <pre>
   * 网络时延拓扑
   * </pre>
   *
   * <code>repeated int32 network_delays = 7;</code>
   * @return The count of networkDelays.
   */
  public int getNetworkDelaysCount() {
    return networkDelays_.size();
  }
  /**
   * <pre>
   * 网络时延拓扑
   * </pre>
   *
   * <code>repeated int32 network_delays = 7;</code>
   * @param index The index of the element to return.
   * @return The networkDelays at the given index.
   */
  public int getNetworkDelays(int index) {
    return networkDelays_.getInt(index);
  }
  private int networkDelaysMemoizedSerializedSize = -1;
  private long timestamp_;
  private com.google.protobuf.Internal.LongList nodeIds_;

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    if (term_ != 0) {
      output.writeUInt32(1, term_);
    }
    if (leaderId_ != 0L) {
      output.writeUInt64(2, leaderId_);
    }
    if (leaderState_ != org.bupt.cad.fedraft.rpc.message.NodeState.SAFE_MODE.getNumber()) {
      output.writeEnum(3, leaderState_);
    }
    if (leaderModelIndex_ != 0) {
      output.writeUInt32(4, leaderModelIndex_);
    }
    if (timestamp_ != 0L) {
      output.writeUInt64(5, timestamp_);
    }
    if (getNodeIdsList().size() > 0) {
      output.writeUInt32NoTag(50);
      output.writeUInt32NoTag(nodeIdsMemoizedSerializedSize);
    }
    for (int i = 0; i < nodeIds_.size(); i++) {
      output.writeUInt64NoTag(nodeIds_.getLong(i));
    }
    if (getNetworkDelaysList().size() > 0) {
        output.writeUInt32NoTag(58);
        output.writeUInt32NoTag(networkDelaysMemoizedSerializedSize);
    }
      for (int i = 0; i < networkDelays_.size(); i++) {
          output.writeInt32NoTag(networkDelays_.getInt(i));
      }
      getUnknownFields().writeTo(output);
  }

    private byte memoizedIsInitialized = -1;

    public static com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
        return org.bupt.cad.fedraft.rpc.message.HeartbeatMessage.internal_static_fedraft_HeartbeatRequest_descriptor;
    }

    public static org.bupt.cad.fedraft.rpc.message.HeartbeatRequest parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static org.bupt.cad.fedraft.rpc.message.HeartbeatRequest parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static org.bupt.cad.fedraft.rpc.message.HeartbeatRequest parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static org.bupt.cad.fedraft.rpc.message.HeartbeatRequest parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static org.bupt.cad.fedraft.rpc.message.HeartbeatRequest parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static org.bupt.cad.fedraft.rpc.message.HeartbeatRequest parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static org.bupt.cad.fedraft.rpc.message.HeartbeatRequest parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static org.bupt.cad.fedraft.rpc.message.HeartbeatRequest parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static org.bupt.cad.fedraft.rpc.message.HeartbeatRequest parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    public static org.bupt.cad.fedraft.rpc.message.HeartbeatRequest parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static org.bupt.cad.fedraft.rpc.message.HeartbeatRequest parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static org.bupt.cad.fedraft.rpc.message.HeartbeatRequest parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(org.bupt.cad.fedraft.rpc.message.HeartbeatRequest prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    public static org.bupt.cad.fedraft.rpc.message.HeartbeatRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<HeartbeatRequest> parser() {
        return PARSER;
    }

    @java.lang.Override
    public boolean isInitialized() {
        byte isInitialized = memoizedIsInitialized;
        if (isInitialized == 1) return true;
        if (isInitialized == 0) return false;

        memoizedIsInitialized = 1;
        return true;
    }

    @java.lang.Override
    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) return size;

        size = 0;
        if (term_ != 0) {
            size += com.google.protobuf.CodedOutputStream
                    .computeUInt32Size(1, term_);
        }
        if (leaderId_ != 0L) {
            size += com.google.protobuf.CodedOutputStream
                    .computeUInt64Size(2, leaderId_);
        }
        if (leaderState_ != org.bupt.cad.fedraft.rpc.message.NodeState.SAFE_MODE.getNumber()) {
            size += com.google.protobuf.CodedOutputStream
                    .computeEnumSize(3, leaderState_);
        }
        if (leaderModelIndex_ != 0) {
            size += com.google.protobuf.CodedOutputStream
                    .computeUInt32Size(4, leaderModelIndex_);
        }
        if (timestamp_ != 0L) {
            size += com.google.protobuf.CodedOutputStream
                    .computeUInt64Size(5, timestamp_);
        }
        {
            int dataSize = 0;
            for (int i = 0; i < nodeIds_.size(); i++) {
                dataSize += com.google.protobuf.CodedOutputStream
                        .computeUInt64SizeNoTag(nodeIds_.getLong(i));
            }
            size += dataSize;
            if (!getNodeIdsList().isEmpty()) {
                size += 1;
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32SizeNoTag(dataSize);
            }
            nodeIdsMemoizedSerializedSize = dataSize;
        }
        {
            int dataSize = 0;
            for (int i = 0; i < networkDelays_.size(); i++) {
                dataSize += com.google.protobuf.CodedOutputStream
                        .computeInt32SizeNoTag(networkDelays_.getInt(i));
            }
            size += dataSize;
            if (!getNetworkDelaysList().isEmpty()) {
                size += 1;
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32SizeNoTag(dataSize);
            }
            networkDelaysMemoizedSerializedSize = dataSize;
        }
        size += getUnknownFields().getSerializedSize();
        memoizedSize = size;
        return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof org.bupt.cad.fedraft.rpc.message.HeartbeatRequest)) {
            return super.equals(obj);
        }
        org.bupt.cad.fedraft.rpc.message.HeartbeatRequest other = (org.bupt.cad.fedraft.rpc.message.HeartbeatRequest) obj;

        if (getTerm()
                != other.getTerm()) return false;
        if (getLeaderId()
                != other.getLeaderId()) return false;
        if (leaderState_ != other.leaderState_) return false;
        if (getLeaderModelIndex()
                != other.getLeaderModelIndex()) return false;
        if (getTimestamp()
                != other.getTimestamp()) return false;
        if (!getNodeIdsList()
                .equals(other.getNodeIdsList())) return false;
        if (!getNetworkDelaysList()
                .equals(other.getNetworkDelaysList())) return false;
        return getUnknownFields().equals(other.getUnknownFields());
    }

    @java.lang.Override
    public int hashCode() {
        if (memoizedHashCode != 0) {
            return memoizedHashCode;
        }
        int hash = 41;
        hash = (19 * hash) + getDescriptor().hashCode();
        hash = (37 * hash) + TERM_FIELD_NUMBER;
        hash = (53 * hash) + getTerm();
        hash = (37 * hash) + LEADER_ID_FIELD_NUMBER;
        hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                getLeaderId());
        hash = (37 * hash) + LEADER_STATE_FIELD_NUMBER;
        hash = (53 * hash) + leaderState_;
        hash = (37 * hash) + LEADER_MODEL_INDEX_FIELD_NUMBER;
        hash = (53 * hash) + getLeaderModelIndex();
        hash = (37 * hash) + TIMESTAMP_FIELD_NUMBER;
        hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                getTimestamp());
    if (getNodeIdsCount() > 0) {
      hash = (37 * hash) + NODE_IDS_FIELD_NUMBER;
      hash = (53 * hash) + getNodeIdsList().hashCode();
    }
        if (getNetworkDelaysCount() > 0) {
            hash = (37 * hash) + NETWORK_DELAYS_FIELD_NUMBER;
            hash = (53 * hash) + getNetworkDelaysList().hashCode();
        }
        hash = (29 * hash) + getUnknownFields().hashCode();
        memoizedHashCode = hash;
        return hash;
    }

    @java.lang.Override
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @java.lang.Override
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE
                ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
            com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        Builder builder = new Builder(parent);
        return builder;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<HeartbeatRequest> getParserForType() {
        return PARSER;
    }

    @java.lang.Override
    public org.bupt.cad.fedraft.rpc.message.HeartbeatRequest getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

  /**
   * Protobuf type {@code fedraft.HeartbeatRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:fedraft.HeartbeatRequest)
      org.bupt.cad.fedraft.rpc.message.HeartbeatRequestOrBuilder {
    public static com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.bupt.cad.fedraft.rpc.message.HeartbeatMessage.internal_static_fedraft_HeartbeatRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.bupt.cad.fedraft.rpc.message.HeartbeatMessage.internal_static_fedraft_HeartbeatRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.bupt.cad.fedraft.rpc.message.HeartbeatRequest.class, org.bupt.cad.fedraft.rpc.message.HeartbeatRequest.Builder.class);
    }

    private int bitField0_;
    private int term_ ;
    @java.lang.Override
    public Builder clear() {
      super.clear();
      term_ = 0;

      leaderId_ = 0L;

      leaderState_ = 0;

      leaderModelIndex_ = 0;

      timestamp_ = 0L;

      nodeIds_ = emptyLongList();
      bitField0_ = (bitField0_ & ~0x00000001);
      networkDelays_ = emptyIntList();
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.bupt.cad.fedraft.rpc.message.HeartbeatMessage.internal_static_fedraft_HeartbeatRequest_descriptor;
    }

    @java.lang.Override
    public org.bupt.cad.fedraft.rpc.message.HeartbeatRequest getDefaultInstanceForType() {
      return org.bupt.cad.fedraft.rpc.message.HeartbeatRequest.getDefaultInstance();
    }

    @java.lang.Override
    public org.bupt.cad.fedraft.rpc.message.HeartbeatRequest build() {
      org.bupt.cad.fedraft.rpc.message.HeartbeatRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.bupt.cad.fedraft.rpc.message.HeartbeatRequest buildPartial() {
      org.bupt.cad.fedraft.rpc.message.HeartbeatRequest result = new org.bupt.cad.fedraft.rpc.message.HeartbeatRequest(this);
      int from_bitField0_ = bitField0_;
      result.term_ = term_;
      result.leaderId_ = leaderId_;
      result.leaderState_ = leaderState_;
      result.leaderModelIndex_ = leaderModelIndex_;
      result.timestamp_ = timestamp_;
      if (((bitField0_ & 0x00000001) != 0)) {
        nodeIds_.makeImmutable();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.nodeIds_ = nodeIds_;
      if (((bitField0_ & 0x00000002) != 0)) {
        networkDelays_.makeImmutable();
        bitField0_ = (bitField0_ & ~0x00000002);
      }
      result.networkDelays_ = networkDelays_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.bupt.cad.fedraft.rpc.message.HeartbeatRequest) {
        return mergeFrom((org.bupt.cad.fedraft.rpc.message.HeartbeatRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.bupt.cad.fedraft.rpc.message.HeartbeatRequest other) {
      if (other == org.bupt.cad.fedraft.rpc.message.HeartbeatRequest.getDefaultInstance()) return this;
      if (other.getTerm() != 0) {
        setTerm(other.getTerm());
      }
      if (other.getLeaderId() != 0L) {
        setLeaderId(other.getLeaderId());
      }
      if (other.leaderState_ != 0) {
        setLeaderStateValue(other.getLeaderStateValue());
      }
      if (other.getLeaderModelIndex() != 0) {
        setLeaderModelIndex(other.getLeaderModelIndex());
      }
      if (other.getTimestamp() != 0L) {
        setTimestamp(other.getTimestamp());
      }
      if (!other.nodeIds_.isEmpty()) {
        if (nodeIds_.isEmpty()) {
          nodeIds_ = other.nodeIds_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureNodeIdsIsMutable();
          nodeIds_.addAll(other.nodeIds_);
        }
        onChanged();
      }
      if (!other.networkDelays_.isEmpty()) {
        if (networkDelays_.isEmpty()) {
          networkDelays_ = other.networkDelays_;
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          ensureNetworkDelaysIsMutable();
          networkDelays_.addAll(other.networkDelays_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              term_ = input.readUInt32();

              break;
            } // case 8
            case 16: {
              leaderId_ = input.readUInt64();

              break;
            } // case 16
            case 24: {
              leaderState_ = input.readEnum();

              break;
            } // case 24
            case 32: {
              leaderModelIndex_ = input.readUInt32();

              break;
            } // case 32
            case 40: {
              timestamp_ = input.readUInt64();

              break;
            } // case 40
            case 48: {
              long v = input.readUInt64();
              ensureNodeIdsIsMutable();
              nodeIds_.addLong(v);
              break;
            } // case 48
            case 50: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              ensureNodeIdsIsMutable();
              while (input.getBytesUntilLimit() > 0) {
                nodeIds_.addLong(input.readUInt64());
              }
              input.popLimit(limit);
              break;
            } // case 50
            case 56: {
              int v = input.readInt32();
              ensureNetworkDelaysIsMutable();
              networkDelays_.addInt(v);
              break;
            } // case 56
            case 58: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              ensureNetworkDelaysIsMutable();
              while (input.getBytesUntilLimit() > 0) {
                networkDelays_.addInt(input.readInt32());
              }
              input.popLimit(limit);
              break;
            } // case 58
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.unwrapIOException();
      } finally {
          onChanged();
      } // finally
        return this;
    }

      private long leaderId_;
      private int leaderState_ = 0;
      private int leaderModelIndex_;
      private long timestamp_;
      private com.google.protobuf.Internal.LongList nodeIds_ = emptyLongList();
      private com.google.protobuf.Internal.IntList networkDelays_ = emptyIntList();

      // Construct using org.bupt.cad.fedraft.rpc.message.HeartbeatRequest.newBuilder()
      private Builder() {

      }

      private Builder(
              com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
          super(parent);

      }

      /**
       * <code>uint32 term = 1;</code>
       *
       * @return The term.
       */
      @java.lang.Override
      public int getTerm() {
          return term_;
      }

      /**
       * <code>uint32 term = 1;</code>
       *
       * @param value The term to set.
       * @return This builder for chaining.
       */
      public Builder setTerm(int value) {

          term_ = value;
          onChanged();
          return this;
      }

      /**
       * <code>uint32 term = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTerm() {

          term_ = 0;
          onChanged();
          return this;
      }

      /**
       * <code>uint64 leader_id = 2;</code>
       *
       * @return The leaderId.
       */
      @java.lang.Override
      public long getLeaderId() {
          return leaderId_;
      }

      /**
       * <code>uint64 leader_id = 2;</code>
       *
       * @param value The leaderId to set.
       * @return This builder for chaining.
       */
      public Builder setLeaderId(long value) {

          leaderId_ = value;
          onChanged();
          return this;
      }

      /**
       * <code>uint64 leader_id = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearLeaderId() {

          leaderId_ = 0L;
          onChanged();
          return this;
      }

      /**
       * <code>.fedraft.NodeState leader_state = 3;</code>
       *
       * @return The enum numeric value on the wire for leaderState.
       */
      @java.lang.Override
      public int getLeaderStateValue() {
          return leaderState_;
      }

      /**
       * <code>.fedraft.NodeState leader_state = 3;</code>
       *
       * @param value The enum numeric value on the wire for leaderState to set.
       * @return This builder for chaining.
       */
      public Builder setLeaderStateValue(int value) {

          leaderState_ = value;
          onChanged();
          return this;
      }

      /**
       * <code>.fedraft.NodeState leader_state = 3;</code>
       *
       * @return The leaderState.
       */
      @java.lang.Override
      public org.bupt.cad.fedraft.rpc.message.NodeState getLeaderState() {
          @SuppressWarnings("deprecation")
          org.bupt.cad.fedraft.rpc.message.NodeState result = org.bupt.cad.fedraft.rpc.message.NodeState.valueOf(leaderState_);
          return result == null ? org.bupt.cad.fedraft.rpc.message.NodeState.UNRECOGNIZED : result;
      }

      /**
       * <code>.fedraft.NodeState leader_state = 3;</code>
       *
       * @param value The leaderState to set.
       * @return This builder for chaining.
       */
      public Builder setLeaderState(org.bupt.cad.fedraft.rpc.message.NodeState value) {
          if (value == null) {
              throw new NullPointerException();
          }

          leaderState_ = value.getNumber();
          onChanged();
          return this;
      }

      /**
       * <code>.fedraft.NodeState leader_state = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearLeaderState() {

          leaderState_ = 0;
          onChanged();
          return this;
      }

      /**
       * <pre>
       * 之前发送模型的任期
       * </pre>
       *
       * <code>uint32 leader_model_index = 4;</code>
     * @return The leaderModelIndex.
     */
    @java.lang.Override
    public int getLeaderModelIndex() {
      return leaderModelIndex_;
    }

    /**
     * <pre>
     * 之前发送模型的任期
     * </pre>
     *
     * <code>uint32 leader_model_index = 4;</code>
     * @param value The leaderModelIndex to set.
     * @return This builder for chaining.
     */
    public Builder setLeaderModelIndex(int value) {

        leaderModelIndex_ = value;
        onChanged();
        return this;
    }

      /**
       * <pre>
       * 之前发送模型的任期
       * </pre>
       *
       * <code>uint32 leader_model_index = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearLeaderModelIndex() {

          leaderModelIndex_ = 0;
          onChanged();
          return this;
      }

      /**
       * <code>uint64 timestamp = 5;</code>
       *
       * @return The timestamp.
       */
      @java.lang.Override
      public long getTimestamp() {
          return timestamp_;
      }

    /**
     * <code>uint64 timestamp = 5;</code>
     * @param value The timestamp to set.
     * @return This builder for chaining.
     */
    public Builder setTimestamp(long value) {

      timestamp_ = value;
      onChanged();
      return this;
    }
    private void ensureNodeIdsIsMutable() {
      if ((bitField0_ & 0x00000001) == 0) {
        nodeIds_ = mutableCopy(nodeIds_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated uint64 node_ids = 6;</code>
     * @return A list containing the nodeIds.
     */
    public java.util.List<java.lang.Long>
        getNodeIdsList() {
      return ((bitField0_ & 0x00000001) != 0) ?
               java.util.Collections.unmodifiableList(nodeIds_) : nodeIds_;
    }
    /**
     * <code>repeated uint64 node_ids = 6;</code>
     * @return The count of nodeIds.
     */
    public int getNodeIdsCount() {
      return nodeIds_.size();
    }
    /**
     * <code>repeated uint64 node_ids = 6;</code>
     * @param index The index of the element to return.
     * @return The nodeIds at the given index.
     */
    public long getNodeIds(int index) {
      return nodeIds_.getLong(index);
    }
    /**
     * <code>repeated uint64 node_ids = 6;</code>
     * @param index The index to set the value at.
     * @param value The nodeIds to set.
     * @return This builder for chaining.
     */
    public Builder setNodeIds(
        int index, long value) {
      ensureNodeIdsIsMutable();
      nodeIds_.setLong(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated uint64 node_ids = 6;</code>
     * @param value The nodeIds to add.
     * @return This builder for chaining.
     */
    public Builder addNodeIds(long value) {
      ensureNodeIdsIsMutable();
      nodeIds_.addLong(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated uint64 node_ids = 6;</code>
     * @param values The nodeIds to add.
     * @return This builder for chaining.
     */
    public Builder addAllNodeIds(
        java.lang.Iterable<? extends java.lang.Long> values) {
      ensureNodeIdsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, nodeIds_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated uint64 node_ids = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearNodeIds() {
      nodeIds_ = emptyLongList();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }

    /**
     * <code>uint64 timestamp = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearTimestamp() {

      timestamp_ = 0L;
      onChanged();
      return this;
    }
    private void ensureNetworkDelaysIsMutable() {
      if ((bitField0_ & 0x00000002) == 0) {
        networkDelays_ = mutableCopy(networkDelays_);
        bitField0_ |= 0x00000002;
       }
    }
    /**
     * <pre>
     * 网络时延拓扑
     * </pre>
     *
     * <code>repeated int32 network_delays = 7;</code>
     * @return A list containing the networkDelays.
     */
    public java.util.List<java.lang.Integer>
        getNetworkDelaysList() {
      return ((bitField0_ & 0x00000002) != 0) ?
               java.util.Collections.unmodifiableList(networkDelays_) : networkDelays_;
    }
    /**
     * <pre>
     * 网络时延拓扑
     * </pre>
     *
     * <code>repeated int32 network_delays = 7;</code>
     * @return The count of networkDelays.
     */
    public int getNetworkDelaysCount() {
      return networkDelays_.size();
    }
    /**
     * <pre>
     * 网络时延拓扑
     * </pre>
     *
     * <code>repeated int32 network_delays = 7;</code>
     * @param index The index of the element to return.
     * @return The networkDelays at the given index.
     */
    public int getNetworkDelays(int index) {
      return networkDelays_.getInt(index);
    }
    /**
     * <pre>
     * 网络时延拓扑
     * </pre>
     *
     * <code>repeated int32 network_delays = 7;</code>
     * @param index The index to set the value at.
     * @param value The networkDelays to set.
     * @return This builder for chaining.
     */
    public Builder setNetworkDelays(
        int index, int value) {
      ensureNetworkDelaysIsMutable();
      networkDelays_.setInt(index, value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 网络时延拓扑
     * </pre>
     *
     * <code>repeated int32 network_delays = 7;</code>
     * @param value The networkDelays to add.
     * @return This builder for chaining.
     */
    public Builder addNetworkDelays(int value) {
      ensureNetworkDelaysIsMutable();
      networkDelays_.addInt(value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 网络时延拓扑
     * </pre>
     *
     * <code>repeated int32 network_delays = 7;</code>
     * @param values The networkDelays to add.
     * @return This builder for chaining.
     */
    public Builder addAllNetworkDelays(
        java.lang.Iterable<? extends java.lang.Integer> values) {
      ensureNetworkDelaysIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, networkDelays_);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 网络时延拓扑
     * </pre>
     *
     * <code>repeated int32 network_delays = 7;</code>
     * @return This builder for chaining.
     */
    public Builder clearNetworkDelays() {
      networkDelays_ = emptyIntList();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    @java.lang.Override
    public Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:fedraft.HeartbeatRequest)
  }

}

