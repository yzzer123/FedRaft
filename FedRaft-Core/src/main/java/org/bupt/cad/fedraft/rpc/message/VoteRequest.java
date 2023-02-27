// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vote_massage.proto

package org.bupt.cad.fedraft.rpc.message;

/**
 * Protobuf type {@code fedraft.VoteRequest}
 */
public final class VoteRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:fedraft.VoteRequest)
    VoteRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use VoteRequest.newBuilder() to construct.
  private VoteRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private VoteRequest() {
    nodeIds_ = emptyLongList();
    networkDelays_ = emptyIntList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new VoteRequest();
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
    return org.bupt.cad.fedraft.rpc.message.VoteMassage.internal_static_fedraft_VoteRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.bupt.cad.fedraft.rpc.message.VoteRequest.class, org.bupt.cad.fedraft.rpc.message.VoteRequest.Builder.class);
  }
  public static final int CANDIDATE_ID_FIELD_NUMBER = 2;
  public static final int MODEL_INDEX_FIELD_NUMBER = 3;
  /**
   * <code>uint32 term = 1;</code>
   * @return The term.
   */
  @java.lang.Override
  public int getTerm() {
    return term_;
  }
  public static final int NODE_IDS_FIELD_NUMBER = 5;
  public static final int NETWORK_DELAYS_FIELD_NUMBER = 6;
  /**
   * <code>uint64 candidate_id = 2;</code>
   * @return The candidateId.
   */
  @java.lang.Override
  public long getCandidateId() {
    return candidateId_;
  }
  // @@protoc_insertion_point(class_scope:fedraft.VoteRequest)
  private static final org.bupt.cad.fedraft.rpc.message.VoteRequest DEFAULT_INSTANCE;
  private static final com.google.protobuf.Parser<VoteRequest>
      PARSER = new com.google.protobuf.AbstractParser<VoteRequest>() {
    @java.lang.Override
    public VoteRequest parsePartialFrom(
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
   * <code>uint32 model_index = 3;</code>
   * @return The modelIndex.
   */
  @java.lang.Override
  public int getModelIndex() {
    return modelIndex_;
  }

  static {
    DEFAULT_INSTANCE = new org.bupt.cad.fedraft.rpc.message.VoteRequest();
  }

  private int term_;
  /**
   * <pre>
   * 请求投票时顺便发送时延投票，防止投票失败，时延拓扑过旧
   * </pre>
   *
   * <code>repeated uint64 node_ids = 5;</code>
   * @return A list containing the nodeIds.
   */
  @java.lang.Override
  public java.util.List<java.lang.Long>
      getNodeIdsList() {
    return nodeIds_;
  }
  /**
   * <pre>
   * 请求投票时顺便发送时延投票，防止投票失败，时延拓扑过旧
   * </pre>
   *
   * <code>repeated uint64 node_ids = 5;</code>
   * @return The count of nodeIds.
   */
  public int getNodeIdsCount() {
    return nodeIds_.size();
  }
  /**
   * <pre>
   * 请求投票时顺便发送时延投票，防止投票失败，时延拓扑过旧
   * </pre>
   *
   * <code>repeated uint64 node_ids = 5;</code>
   * @param index The index of the element to return.
   * @return The nodeIds at the given index.
   */
  public long getNodeIds(int index) {
    return nodeIds_.getLong(index);
  }
  private long candidateId_;
  private int modelIndex_;
  private com.google.protobuf.Internal.LongList nodeIds_;
  /**
   * <code>repeated uint32 network_delays = 6;</code>
   * @return A list containing the networkDelays.
   */
  @java.lang.Override
  public java.util.List<java.lang.Integer>
      getNetworkDelaysList() {
    return networkDelays_;
  }
  /**
   * <code>repeated uint32 network_delays = 6;</code>
   * @return The count of networkDelays.
   */
  public int getNetworkDelaysCount() {
    return networkDelays_.size();
  }
  /**
   * <code>repeated uint32 network_delays = 6;</code>
   * @param index The index of the element to return.
   * @return The networkDelays at the given index.
   */
  public int getNetworkDelays(int index) {
    return networkDelays_.getInt(index);
  }
  private int nodeIdsMemoizedSerializedSize = -1;
  private com.google.protobuf.Internal.IntList networkDelays_;
  @java.lang.Override
  public boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    if (term_ != 0) {
      output.writeUInt32(1, term_);
    }
    if (candidateId_ != 0L) {
      output.writeUInt64(2, candidateId_);
    }
    if (modelIndex_ != 0) {
      output.writeUInt32(3, modelIndex_);
    }
    if (getNodeIdsList().size() > 0) {
      output.writeUInt32NoTag(42);
      output.writeUInt32NoTag(nodeIdsMemoizedSerializedSize);
    }
    for (int i = 0; i < nodeIds_.size(); i++) {
      output.writeUInt64NoTag(nodeIds_.getLong(i));
    }
    if (getNetworkDelaysList().size() > 0) {
      output.writeUInt32NoTag(50);
      output.writeUInt32NoTag(networkDelaysMemoizedSerializedSize);
    }
    for (int i = 0; i < networkDelays_.size(); i++) {
      output.writeUInt32NoTag(networkDelays_.getInt(i));
    }
    getUnknownFields().writeTo(output);
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
    if (candidateId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(2, candidateId_);
    }
    if (modelIndex_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(3, modelIndex_);
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
          .computeUInt32SizeNoTag(networkDelays_.getInt(i));
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
  private int networkDelaysMemoizedSerializedSize = -1;

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + TERM_FIELD_NUMBER;
    hash = (53 * hash) + getTerm();
    hash = (37 * hash) + CANDIDATE_ID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getCandidateId());
    hash = (37 * hash) + MODEL_INDEX_FIELD_NUMBER;
    hash = (53 * hash) + getModelIndex();
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

  public static org.bupt.cad.fedraft.rpc.message.VoteRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.bupt.cad.fedraft.rpc.message.VoteRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.bupt.cad.fedraft.rpc.message.VoteRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.bupt.cad.fedraft.rpc.message.VoteRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.bupt.cad.fedraft.rpc.message.VoteRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.bupt.cad.fedraft.rpc.message.VoteRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.bupt.cad.fedraft.rpc.message.VoteRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.bupt.cad.fedraft.rpc.message.VoteRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.bupt.cad.fedraft.rpc.message.VoteRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.bupt.cad.fedraft.rpc.message.VoteRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.bupt.cad.fedraft.rpc.message.VoteRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.bupt.cad.fedraft.rpc.message.VoteRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  private byte memoizedIsInitialized = -1;
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.bupt.cad.fedraft.rpc.message.VoteRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
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

  public static com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.bupt.cad.fedraft.rpc.message.VoteMassage.internal_static_fedraft_VoteRequest_descriptor;
  }

  public static org.bupt.cad.fedraft.rpc.message.VoteRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  public static com.google.protobuf.Parser<VoteRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.bupt.cad.fedraft.rpc.message.VoteRequest)) {
      return super.equals(obj);
    }
    org.bupt.cad.fedraft.rpc.message.VoteRequest other = (org.bupt.cad.fedraft.rpc.message.VoteRequest) obj;

    if (getTerm()
        != other.getTerm()) return false;
    if (getCandidateId()
        != other.getCandidateId()) return false;
    if (getModelIndex()
        != other.getModelIndex()) return false;
    if (!getNodeIdsList()
        .equals(other.getNodeIdsList())) return false;
    if (!getNetworkDelaysList()
        .equals(other.getNetworkDelaysList())) return false;
      return getUnknownFields().equals(other.getUnknownFields());
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }

  @java.lang.Override
  public com.google.protobuf.Parser<VoteRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.bupt.cad.fedraft.rpc.message.VoteRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

  /**
   * Protobuf type {@code fedraft.VoteRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:fedraft.VoteRequest)
      org.bupt.cad.fedraft.rpc.message.VoteRequestOrBuilder {
    public static com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.bupt.cad.fedraft.rpc.message.VoteMassage.internal_static_fedraft_VoteRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.bupt.cad.fedraft.rpc.message.VoteMassage.internal_static_fedraft_VoteRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.bupt.cad.fedraft.rpc.message.VoteRequest.class, org.bupt.cad.fedraft.rpc.message.VoteRequest.Builder.class);
    }

    private int bitField0_;
    private int term_ ;
    @java.lang.Override
    public Builder clear() {
      super.clear();
      term_ = 0;

      candidateId_ = 0L;

      modelIndex_ = 0;

      nodeIds_ = emptyLongList();
      bitField0_ = (bitField0_ & ~0x00000001);
      networkDelays_ = emptyIntList();
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.bupt.cad.fedraft.rpc.message.VoteMassage.internal_static_fedraft_VoteRequest_descriptor;
    }

    @java.lang.Override
    public org.bupt.cad.fedraft.rpc.message.VoteRequest getDefaultInstanceForType() {
      return org.bupt.cad.fedraft.rpc.message.VoteRequest.getDefaultInstance();
    }

    @java.lang.Override
    public org.bupt.cad.fedraft.rpc.message.VoteRequest build() {
      org.bupt.cad.fedraft.rpc.message.VoteRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.bupt.cad.fedraft.rpc.message.VoteRequest buildPartial() {
      org.bupt.cad.fedraft.rpc.message.VoteRequest result = new org.bupt.cad.fedraft.rpc.message.VoteRequest(this);
      int from_bitField0_ = bitField0_;
      result.term_ = term_;
      result.candidateId_ = candidateId_;
      result.modelIndex_ = modelIndex_;
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
      if (other instanceof org.bupt.cad.fedraft.rpc.message.VoteRequest) {
        return mergeFrom((org.bupt.cad.fedraft.rpc.message.VoteRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.bupt.cad.fedraft.rpc.message.VoteRequest other) {
      if (other == org.bupt.cad.fedraft.rpc.message.VoteRequest.getDefaultInstance()) return this;
      if (other.getTerm() != 0) {
        setTerm(other.getTerm());
      }
      if (other.getCandidateId() != 0L) {
        setCandidateId(other.getCandidateId());
      }
      if (other.getModelIndex() != 0) {
        setModelIndex(other.getModelIndex());
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
              candidateId_ = input.readUInt64();

              break;
            } // case 16
            case 24: {
              modelIndex_ = input.readUInt32();

              break;
            } // case 24
            case 40: {
              long v = input.readUInt64();
              ensureNodeIdsIsMutable();
              nodeIds_.addLong(v);
              break;
            } // case 40
            case 42: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              ensureNodeIdsIsMutable();
              while (input.getBytesUntilLimit() > 0) {
                nodeIds_.addLong(input.readUInt64());
              }
              input.popLimit(limit);
              break;
            } // case 42
            case 48: {
              int v = input.readUInt32();
              ensureNetworkDelaysIsMutable();
              networkDelays_.addInt(v);
              break;
            } // case 48
            case 50: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              ensureNetworkDelaysIsMutable();
              while (input.getBytesUntilLimit() > 0) {
                networkDelays_.addInt(input.readUInt32());
              }
              input.popLimit(limit);
              break;
            } // case 50
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

      private long candidateId_;
      private int modelIndex_;
      private com.google.protobuf.Internal.LongList nodeIds_ = emptyLongList();
      private com.google.protobuf.Internal.IntList networkDelays_ = emptyIntList();

      // Construct using org.bupt.cad.fedraft.rpc.message.VoteRequest.newBuilder()
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
       * <code>uint64 candidate_id = 2;</code>
       *
       * @return The candidateId.
       */
      @java.lang.Override
      public long getCandidateId() {
          return candidateId_;
      }

      /**
       * <code>uint64 candidate_id = 2;</code>
       *
       * @param value The candidateId to set.
       * @return This builder for chaining.
       */
      public Builder setCandidateId(long value) {

          candidateId_ = value;
          onChanged();
          return this;
      }

      /**
       * <code>uint64 candidate_id = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCandidateId() {

          candidateId_ = 0L;
          onChanged();
          return this;
      }

      /**
       * <code>uint32 model_index = 3;</code>
       *
       * @return The modelIndex.
       */
      @java.lang.Override
      public int getModelIndex() {
          return modelIndex_;
      }

      /**
       * <code>uint32 model_index = 3;</code>
       * @param value The modelIndex to set.
       * @return This builder for chaining.
     */
    public Builder setModelIndex(int value) {

      modelIndex_ = value;
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
     * <pre>
     * 请求投票时顺便发送时延投票，防止投票失败，时延拓扑过旧
     * </pre>
     *
     * <code>repeated uint64 node_ids = 5;</code>
     * @return A list containing the nodeIds.
     */
    public java.util.List<java.lang.Long>
        getNodeIdsList() {
      return ((bitField0_ & 0x00000001) != 0) ?
               java.util.Collections.unmodifiableList(nodeIds_) : nodeIds_;
    }
    /**
     * <pre>
     * 请求投票时顺便发送时延投票，防止投票失败，时延拓扑过旧
     * </pre>
     *
     * <code>repeated uint64 node_ids = 5;</code>
     * @return The count of nodeIds.
     */
    public int getNodeIdsCount() {
      return nodeIds_.size();
    }
    /**
     * <pre>
     * 请求投票时顺便发送时延投票，防止投票失败，时延拓扑过旧
     * </pre>
     *
     * <code>repeated uint64 node_ids = 5;</code>
     * @param index The index of the element to return.
     * @return The nodeIds at the given index.
     */
    public long getNodeIds(int index) {
      return nodeIds_.getLong(index);
    }
    /**
     * <pre>
     * 请求投票时顺便发送时延投票，防止投票失败，时延拓扑过旧
     * </pre>
     *
     * <code>repeated uint64 node_ids = 5;</code>
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
     * <pre>
     * 请求投票时顺便发送时延投票，防止投票失败，时延拓扑过旧
     * </pre>
     *
     * <code>repeated uint64 node_ids = 5;</code>
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
     * <pre>
     * 请求投票时顺便发送时延投票，防止投票失败，时延拓扑过旧
     * </pre>
     *
     * <code>repeated uint64 node_ids = 5;</code>
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
     * <pre>
     * 请求投票时顺便发送时延投票，防止投票失败，时延拓扑过旧
     * </pre>
     *
     * <code>repeated uint64 node_ids = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearNodeIds() {
      nodeIds_ = emptyLongList();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }

    /**
     * <code>uint32 model_index = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearModelIndex() {

      modelIndex_ = 0;
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
     * <code>repeated uint32 network_delays = 6;</code>
     * @return A list containing the networkDelays.
     */
    public java.util.List<java.lang.Integer>
        getNetworkDelaysList() {
      return ((bitField0_ & 0x00000002) != 0) ?
               java.util.Collections.unmodifiableList(networkDelays_) : networkDelays_;
    }
    /**
     * <code>repeated uint32 network_delays = 6;</code>
     * @return The count of networkDelays.
     */
    public int getNetworkDelaysCount() {
      return networkDelays_.size();
    }
    /**
     * <code>repeated uint32 network_delays = 6;</code>
     * @param index The index of the element to return.
     * @return The networkDelays at the given index.
     */
    public int getNetworkDelays(int index) {
      return networkDelays_.getInt(index);
    }
    /**
     * <code>repeated uint32 network_delays = 6;</code>
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
     * <code>repeated uint32 network_delays = 6;</code>
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
     * <code>repeated uint32 network_delays = 6;</code>
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
     * <code>repeated uint32 network_delays = 6;</code>
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


    // @@protoc_insertion_point(builder_scope:fedraft.VoteRequest)
  }

}

