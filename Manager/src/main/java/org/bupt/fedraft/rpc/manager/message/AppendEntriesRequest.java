// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: manager_message.proto

package org.bupt.fedraft.rpc.manager.message;

/**
 * Protobuf type {@code fedraft.AppendEntriesRequest}
 */
public final class AppendEntriesRequest extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:fedraft.AppendEntriesRequest)
        AppendEntriesRequestOrBuilder {
  public static final int TERM_FIELD_NUMBER = 1;
  public static final int LEADERID_FIELD_NUMBER = 2;
  public static final int ENTRYINDEX_FIELD_NUMBER = 3;
  public static final int NODEIDS_FIELD_NUMBER = 4;
  public static final int DELAY_FIELD_NUMBER = 5;
  private static final long serialVersionUID = 0L;
  // @@protoc_insertion_point(class_scope:fedraft.AppendEntriesRequest)
  private static final org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest DEFAULT_INSTANCE;
  private static final com.google.protobuf.Parser<AppendEntriesRequest>
          PARSER = new com.google.protobuf.AbstractParser<AppendEntriesRequest>() {
    @java.lang.Override
    public AppendEntriesRequest parsePartialFrom(
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

  static {
    DEFAULT_INSTANCE = new org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest();
  }

  private int term_;
  private long leaderId_;
  private long entryIndex_;
  private com.google.protobuf.Internal.LongList nodeIds_;
  private int nodeIdsMemoizedSerializedSize = -1;
  private com.google.protobuf.Internal.IntList delay_;
  private int delayMemoizedSerializedSize = -1;
  private byte memoizedIsInitialized = -1;

  // Use AppendEntriesRequest.newBuilder() to construct.
  private AppendEntriesRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private AppendEntriesRequest() {
    nodeIds_ = emptyLongList();
    delay_ = emptyIntList();
  }

  public static com.google.protobuf.Descriptors.Descriptor
  getDescriptor() {
    return org.bupt.fedraft.rpc.manager.message.ManagerMessage.internal_static_fedraft_AppendEntriesRequest_descriptor;
  }

  public static org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest parseFrom(
          java.nio.ByteBuffer data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest parseFrom(
          java.nio.ByteBuffer data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest parseFrom(
          com.google.protobuf.ByteString data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest parseFrom(
          com.google.protobuf.ByteString data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest parseFrom(byte[] data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest parseFrom(
          byte[] data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest parseFrom(java.io.InputStream input)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input);
  }

  public static org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest parseFrom(
          java.io.InputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest parseDelimitedFrom(java.io.InputStream input)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseDelimitedWithIOException(PARSER, input);
  }

  public static org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest parseDelimitedFrom(
          java.io.InputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest parseFrom(
          com.google.protobuf.CodedInputStream input)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input);
  }

  public static org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest parseFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public static org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  public static com.google.protobuf.Parser<AppendEntriesRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
          UnusedPrivateParameter unused) {
    return new AppendEntriesRequest();
  }

  @java.lang.Override
  public com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
  internalGetFieldAccessorTable() {
    return org.bupt.fedraft.rpc.manager.message.ManagerMessage.internal_static_fedraft_AppendEntriesRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                    org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest.class, org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest.Builder.class);
  }

  /**
   * <code>int32 term = 1;</code>
   *
   * @return The term.
   */
  @java.lang.Override
  public int getTerm() {
    return term_;
  }

  /**
   * <code>int64 leaderId = 2;</code>
   *
   * @return The leaderId.
   */
  @java.lang.Override
  public long getLeaderId() {
    return leaderId_;
  }

  /**
   * <pre>
   * 拓扑索引
   * </pre>
   *
   * <code>int64 entryIndex = 3;</code>
   *
   * @return The entryIndex.
   */
  @java.lang.Override
  public long getEntryIndex() {
    return entryIndex_;
  }

  /**
   * <pre>
   * 拓扑信息
   * </pre>
   *
   * <code>repeated int64 nodeIds = 4;</code>
   *
   * @return A list containing the nodeIds.
   */
  @java.lang.Override
  public java.util.List<java.lang.Long>
  getNodeIdsList() {
    return nodeIds_;
  }

  /**
   * <pre>
   * 拓扑信息
   * </pre>
   *
   * <code>repeated int64 nodeIds = 4;</code>
   *
   * @return The count of nodeIds.
   */
  public int getNodeIdsCount() {
    return nodeIds_.size();
  }

  /**
   * <pre>
   * 拓扑信息
   * </pre>
   *
   * <code>repeated int64 nodeIds = 4;</code>
   *
   * @param index The index of the element to return.
   * @return The nodeIds at the given index.
   */
  public long getNodeIds(int index) {
    return nodeIds_.getLong(index);
  }

  /**
   * <code>repeated int32 delay = 5;</code>
   *
   * @return A list containing the delay.
   */
  @java.lang.Override
  public java.util.List<java.lang.Integer>
  getDelayList() {
    return delay_;
  }

  /**
   * <code>repeated int32 delay = 5;</code>
   *
   * @return The count of delay.
   */
  public int getDelayCount() {
    return delay_.size();
  }

  /**
   * <code>repeated int32 delay = 5;</code>
   *
   * @param index The index of the element to return.
   * @return The delay at the given index.
   */
  public int getDelay(int index) {
    return delay_.getInt(index);
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
  public void writeTo(com.google.protobuf.CodedOutputStream output)
          throws java.io.IOException {
    getSerializedSize();
    if (term_ != 0) {
      output.writeInt32(1, term_);
    }
    if (leaderId_ != 0L) {
      output.writeInt64(2, leaderId_);
    }
    if (entryIndex_ != 0L) {
      output.writeInt64(3, entryIndex_);
    }
    if (getNodeIdsList().size() > 0) {
      output.writeUInt32NoTag(34);
      output.writeUInt32NoTag(nodeIdsMemoizedSerializedSize);
    }
    for (int i = 0; i < nodeIds_.size(); i++) {
      output.writeInt64NoTag(nodeIds_.getLong(i));
    }
    if (getDelayList().size() > 0) {
      output.writeUInt32NoTag(42);
      output.writeUInt32NoTag(delayMemoizedSerializedSize);
    }
    for (int i = 0; i < delay_.size(); i++) {
      output.writeInt32NoTag(delay_.getInt(i));
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
              .computeInt32Size(1, term_);
    }
    if (leaderId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
              .computeInt64Size(2, leaderId_);
    }
    if (entryIndex_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
              .computeInt64Size(3, entryIndex_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < nodeIds_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
                .computeInt64SizeNoTag(nodeIds_.getLong(i));
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
      for (int i = 0; i < delay_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
                .computeInt32SizeNoTag(delay_.getInt(i));
      }
      size += dataSize;
      if (!getDelayList().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
                .computeInt32SizeNoTag(dataSize);
      }
      delayMemoizedSerializedSize = dataSize;
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
    if (!(obj instanceof org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest)) {
      return super.equals(obj);
    }
    org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest other = (org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest) obj;

    if (getTerm()
            != other.getTerm()) return false;
    if (getLeaderId()
            != other.getLeaderId()) return false;
    if (getEntryIndex()
            != other.getEntryIndex()) return false;
    if (!getNodeIdsList()
            .equals(other.getNodeIdsList())) return false;
    if (!getDelayList()
            .equals(other.getDelayList())) return false;
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
    hash = (37 * hash) + LEADERID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
            getLeaderId());
    hash = (37 * hash) + ENTRYINDEX_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
            getEntryIndex());
    if (getNodeIdsCount() > 0) {
      hash = (37 * hash) + NODEIDS_FIELD_NUMBER;
      hash = (53 * hash) + getNodeIdsList().hashCode();
    }
    if (getDelayCount() > 0) {
      hash = (37 * hash) + DELAY_FIELD_NUMBER;
      hash = (53 * hash) + getDelayList().hashCode();
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
  public com.google.protobuf.Parser<AppendEntriesRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

  /**
   * Protobuf type {@code fedraft.AppendEntriesRequest}
   */
  public static final class Builder extends
          com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
          // @@protoc_insertion_point(builder_implements:fedraft.AppendEntriesRequest)
          org.bupt.fedraft.rpc.manager.message.AppendEntriesRequestOrBuilder {
    private int bitField0_;
    private int term_;
    private long leaderId_;
    private long entryIndex_;
    private com.google.protobuf.Internal.LongList nodeIds_ = emptyLongList();
    private com.google.protobuf.Internal.IntList delay_ = emptyIntList();

    // Construct using org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest.newBuilder()
    private Builder() {

    }

    private Builder(
            com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }

    public static com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
      return org.bupt.fedraft.rpc.manager.message.ManagerMessage.internal_static_fedraft_AppendEntriesRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
      return org.bupt.fedraft.rpc.manager.message.ManagerMessage.internal_static_fedraft_AppendEntriesRequest_fieldAccessorTable
              .ensureFieldAccessorsInitialized(
                      org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest.class, org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest.Builder.class);
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      term_ = 0;

      leaderId_ = 0L;

      entryIndex_ = 0L;

      nodeIds_ = emptyLongList();
      bitField0_ = (bitField0_ & ~0x00000001);
      delay_ = emptyIntList();
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
    getDescriptorForType() {
      return org.bupt.fedraft.rpc.manager.message.ManagerMessage.internal_static_fedraft_AppendEntriesRequest_descriptor;
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest getDefaultInstanceForType() {
      return org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest.getDefaultInstance();
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest build() {
      org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest buildPartial() {
      org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest result = new org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest(this);
      int from_bitField0_ = bitField0_;
      result.term_ = term_;
      result.leaderId_ = leaderId_;
      result.entryIndex_ = entryIndex_;
      if (((bitField0_ & 0x00000001) != 0)) {
        nodeIds_.makeImmutable();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.nodeIds_ = nodeIds_;
      if (((bitField0_ & 0x00000002) != 0)) {
        delay_.makeImmutable();
        bitField0_ = (bitField0_ & ~0x00000002);
      }
      result.delay_ = delay_;
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
      if (other instanceof org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest) {
        return mergeFrom((org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest other) {
      if (other == org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest.getDefaultInstance()) return this;
      if (other.getTerm() != 0) {
        setTerm(other.getTerm());
      }
      if (other.getLeaderId() != 0L) {
        setLeaderId(other.getLeaderId());
      }
      if (other.getEntryIndex() != 0L) {
        setEntryIndex(other.getEntryIndex());
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
      if (!other.delay_.isEmpty()) {
        if (delay_.isEmpty()) {
          delay_ = other.delay_;
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          ensureDelayIsMutable();
          delay_.addAll(other.delay_);
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
              term_ = input.readInt32();

              break;
            } // case 8
            case 16: {
              leaderId_ = input.readInt64();

              break;
            } // case 16
            case 24: {
              entryIndex_ = input.readInt64();

              break;
            } // case 24
            case 32: {
              long v = input.readInt64();
              ensureNodeIdsIsMutable();
              nodeIds_.addLong(v);
              break;
            } // case 32
            case 34: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              ensureNodeIdsIsMutable();
              while (input.getBytesUntilLimit() > 0) {
                nodeIds_.addLong(input.readInt64());
              }
              input.popLimit(limit);
              break;
            } // case 34
            case 40: {
              int v = input.readInt32();
              ensureDelayIsMutable();
              delay_.addInt(v);
              break;
            } // case 40
            case 42: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              ensureDelayIsMutable();
              while (input.getBytesUntilLimit() > 0) {
                delay_.addInt(input.readInt32());
              }
              input.popLimit(limit);
              break;
            } // case 42
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

    /**
     * <code>int32 term = 1;</code>
     *
     * @return The term.
     */
    @java.lang.Override
    public int getTerm() {
      return term_;
    }

    /**
     * <code>int32 term = 1;</code>
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
     * <code>int32 term = 1;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearTerm() {

      term_ = 0;
      onChanged();
      return this;
    }

    /**
     * <code>int64 leaderId = 2;</code>
     *
     * @return The leaderId.
     */
    @java.lang.Override
    public long getLeaderId() {
      return leaderId_;
    }

    /**
     * <code>int64 leaderId = 2;</code>
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
     * <code>int64 leaderId = 2;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearLeaderId() {

      leaderId_ = 0L;
      onChanged();
      return this;
    }

    /**
     * <pre>
     * 拓扑索引
     * </pre>
     *
     * <code>int64 entryIndex = 3;</code>
     *
     * @return The entryIndex.
     */
    @java.lang.Override
    public long getEntryIndex() {
      return entryIndex_;
    }

    /**
     * <pre>
     * 拓扑索引
     * </pre>
     *
     * <code>int64 entryIndex = 3;</code>
     *
     * @param value The entryIndex to set.
     * @return This builder for chaining.
     */
    public Builder setEntryIndex(long value) {

      entryIndex_ = value;
      onChanged();
      return this;
    }

    /**
     * <pre>
     * 拓扑索引
     * </pre>
     *
     * <code>int64 entryIndex = 3;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearEntryIndex() {

      entryIndex_ = 0L;
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
     * 拓扑信息
     * </pre>
     *
     * <code>repeated int64 nodeIds = 4;</code>
     *
     * @return A list containing the nodeIds.
     */
    public java.util.List<java.lang.Long>
    getNodeIdsList() {
      return ((bitField0_ & 0x00000001) != 0) ?
              java.util.Collections.unmodifiableList(nodeIds_) : nodeIds_;
    }

    /**
     * <pre>
     * 拓扑信息
     * </pre>
     *
     * <code>repeated int64 nodeIds = 4;</code>
     *
     * @return The count of nodeIds.
     */
    public int getNodeIdsCount() {
      return nodeIds_.size();
    }

    /**
     * <pre>
     * 拓扑信息
     * </pre>
     *
     * <code>repeated int64 nodeIds = 4;</code>
     *
     * @param index The index of the element to return.
     * @return The nodeIds at the given index.
     */
    public long getNodeIds(int index) {
      return nodeIds_.getLong(index);
    }

    /**
     * <pre>
     * 拓扑信息
     * </pre>
     *
     * <code>repeated int64 nodeIds = 4;</code>
     *
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
     * 拓扑信息
     * </pre>
     *
     * <code>repeated int64 nodeIds = 4;</code>
     *
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
     * 拓扑信息
     * </pre>
     *
     * <code>repeated int64 nodeIds = 4;</code>
     *
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
     * 拓扑信息
     * </pre>
     *
     * <code>repeated int64 nodeIds = 4;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearNodeIds() {
      nodeIds_ = emptyLongList();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }

    private void ensureDelayIsMutable() {
      if ((bitField0_ & 0x00000002) == 0) {
        delay_ = mutableCopy(delay_);
        bitField0_ |= 0x00000002;
      }
    }

    /**
     * <code>repeated int32 delay = 5;</code>
     *
     * @return A list containing the delay.
     */
    public java.util.List<java.lang.Integer>
    getDelayList() {
      return ((bitField0_ & 0x00000002) != 0) ?
              java.util.Collections.unmodifiableList(delay_) : delay_;
    }

    /**
     * <code>repeated int32 delay = 5;</code>
     *
     * @return The count of delay.
     */
    public int getDelayCount() {
      return delay_.size();
    }

    /**
     * <code>repeated int32 delay = 5;</code>
     *
     * @param index The index of the element to return.
     * @return The delay at the given index.
     */
    public int getDelay(int index) {
      return delay_.getInt(index);
    }

    /**
     * <code>repeated int32 delay = 5;</code>
     *
     * @param index The index to set the value at.
     * @param value The delay to set.
     * @return This builder for chaining.
     */
    public Builder setDelay(
            int index, int value) {
      ensureDelayIsMutable();
      delay_.setInt(index, value);
      onChanged();
      return this;
    }

    /**
     * <code>repeated int32 delay = 5;</code>
     *
     * @param value The delay to add.
     * @return This builder for chaining.
     */
    public Builder addDelay(int value) {
      ensureDelayIsMutable();
      delay_.addInt(value);
      onChanged();
      return this;
    }

    /**
     * <code>repeated int32 delay = 5;</code>
     *
     * @param values The delay to add.
     * @return This builder for chaining.
     */
    public Builder addAllDelay(
            java.lang.Iterable<? extends java.lang.Integer> values) {
      ensureDelayIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, delay_);
      onChanged();
      return this;
    }

    /**
     * <code>repeated int32 delay = 5;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearDelay() {
      delay_ = emptyIntList();
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


    // @@protoc_insertion_point(builder_scope:fedraft.AppendEntriesRequest)
  }

}
