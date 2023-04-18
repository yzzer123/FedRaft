// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: trainer_message.proto

package org.bupt.fedraft.rpc.trainer.message;

/**
 * <pre>
 * 请求Leader合并模型
 * </pre>
 *
 * Protobuf type {@code fedraft.MergeRequest}
 */
public final class MergeRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:fedraft.MergeRequest)
    MergeRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MergeRequest.newBuilder() to construct.
  private MergeRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MergeRequest() {
    serverIds_ = emptyLongList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new MergeRequest();
  }

  @java.lang.Override
  public com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.bupt.fedraft.rpc.trainer.message.TrainerMessage.internal_static_fedraft_MergeRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.bupt.fedraft.rpc.trainer.message.TrainerMessage.internal_static_fedraft_MergeRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.bupt.fedraft.rpc.trainer.message.MergeRequest.class, org.bupt.fedraft.rpc.trainer.message.MergeRequest.Builder.class);
  }

  public static final int SERVER_IDS_FIELD_NUMBER = 1;
  private com.google.protobuf.Internal.LongList serverIds_;
  /**
   * <pre>
   * 接受到的模型来源， 确认Trainer是否存在
   * </pre>
   *
   * <code>repeated uint64 server_ids = 1;</code>
   * @return A list containing the serverIds.
   */
  @java.lang.Override
  public java.util.List<java.lang.Long>
      getServerIdsList() {
    return serverIds_;
  }
  /**
   * <pre>
   * 接受到的模型来源， 确认Trainer是否存在
   * </pre>
   *
   * <code>repeated uint64 server_ids = 1;</code>
   * @return The count of serverIds.
   */
  public int getServerIdsCount() {
    return serverIds_.size();
  }
  /**
   * <pre>
   * 接受到的模型来源， 确认Trainer是否存在
   * </pre>
   *
   * <code>repeated uint64 server_ids = 1;</code>
   * @param index The index of the element to return.
   * @return The serverIds at the given index.
   */
  public long getServerIds(int index) {
    return serverIds_.getLong(index);
  }
  private int serverIdsMemoizedSerializedSize = -1;

  private byte memoizedIsInitialized = -1;
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
    if (getServerIdsList().size() > 0) {
      output.writeUInt32NoTag(10);
      output.writeUInt32NoTag(serverIdsMemoizedSerializedSize);
    }
    for (int i = 0; i < serverIds_.size(); i++) {
      output.writeUInt64NoTag(serverIds_.getLong(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < serverIds_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeUInt64SizeNoTag(serverIds_.getLong(i));
      }
      size += dataSize;
      if (!getServerIdsList().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(dataSize);
      }
      serverIdsMemoizedSerializedSize = dataSize;
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
    if (!(obj instanceof org.bupt.fedraft.rpc.trainer.message.MergeRequest)) {
      return super.equals(obj);
    }
    org.bupt.fedraft.rpc.trainer.message.MergeRequest other = (org.bupt.fedraft.rpc.trainer.message.MergeRequest) obj;

    if (!getServerIdsList()
        .equals(other.getServerIdsList())) return false;
    return getUnknownFields().equals(other.getUnknownFields());
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getServerIdsCount() > 0) {
      hash = (37 * hash) + SERVER_IDS_FIELD_NUMBER;
      hash = (53 * hash) + getServerIdsList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.bupt.fedraft.rpc.trainer.message.MergeRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.bupt.fedraft.rpc.trainer.message.MergeRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.bupt.fedraft.rpc.trainer.message.MergeRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.bupt.fedraft.rpc.trainer.message.MergeRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.bupt.fedraft.rpc.trainer.message.MergeRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.bupt.fedraft.rpc.trainer.message.MergeRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.bupt.fedraft.rpc.trainer.message.MergeRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.bupt.fedraft.rpc.trainer.message.MergeRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.bupt.fedraft.rpc.trainer.message.MergeRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.bupt.fedraft.rpc.trainer.message.MergeRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.bupt.fedraft.rpc.trainer.message.MergeRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.bupt.fedraft.rpc.trainer.message.MergeRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.bupt.fedraft.rpc.trainer.message.MergeRequest prototype) {
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
  /**
   * <pre>
   * 请求Leader合并模型
   * </pre>
   *
   * Protobuf type {@code fedraft.MergeRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:fedraft.MergeRequest)
      org.bupt.fedraft.rpc.trainer.message.MergeRequestOrBuilder {
    public static com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.bupt.fedraft.rpc.trainer.message.TrainerMessage.internal_static_fedraft_MergeRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.bupt.fedraft.rpc.trainer.message.TrainerMessage.internal_static_fedraft_MergeRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.bupt.fedraft.rpc.trainer.message.MergeRequest.class, org.bupt.fedraft.rpc.trainer.message.MergeRequest.Builder.class);
    }

    // Construct using org.bupt.fedraft.rpc.trainer.message.MergeRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      serverIds_ = emptyLongList();
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.bupt.fedraft.rpc.trainer.message.TrainerMessage.internal_static_fedraft_MergeRequest_descriptor;
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.trainer.message.MergeRequest getDefaultInstanceForType() {
      return org.bupt.fedraft.rpc.trainer.message.MergeRequest.getDefaultInstance();
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.trainer.message.MergeRequest build() {
      org.bupt.fedraft.rpc.trainer.message.MergeRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.trainer.message.MergeRequest buildPartial() {
      org.bupt.fedraft.rpc.trainer.message.MergeRequest result = new org.bupt.fedraft.rpc.trainer.message.MergeRequest(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) != 0)) {
        serverIds_.makeImmutable();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.serverIds_ = serverIds_;
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
      if (other instanceof org.bupt.fedraft.rpc.trainer.message.MergeRequest) {
        return mergeFrom((org.bupt.fedraft.rpc.trainer.message.MergeRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.bupt.fedraft.rpc.trainer.message.MergeRequest other) {
      if (other == org.bupt.fedraft.rpc.trainer.message.MergeRequest.getDefaultInstance()) return this;
      if (!other.serverIds_.isEmpty()) {
        if (serverIds_.isEmpty()) {
          serverIds_ = other.serverIds_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureServerIdsIsMutable();
          serverIds_.addAll(other.serverIds_);
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
              long v = input.readUInt64();
              ensureServerIdsIsMutable();
              serverIds_.addLong(v);
              break;
            } // case 8
            case 10: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              ensureServerIdsIsMutable();
              while (input.getBytesUntilLimit() > 0) {
                serverIds_.addLong(input.readUInt64());
              }
              input.popLimit(limit);
              break;
            } // case 10
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
    private int bitField0_;

    private com.google.protobuf.Internal.LongList serverIds_ = emptyLongList();
    private void ensureServerIdsIsMutable() {
      if ((bitField0_ & 0x00000001) == 0) {
        serverIds_ = mutableCopy(serverIds_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <pre>
     * 接受到的模型来源， 确认Trainer是否存在
     * </pre>
     *
     * <code>repeated uint64 server_ids = 1;</code>
     * @return A list containing the serverIds.
     */
    public java.util.List<java.lang.Long>
        getServerIdsList() {
      return ((bitField0_ & 0x00000001) != 0) ?
               java.util.Collections.unmodifiableList(serverIds_) : serverIds_;
    }
    /**
     * <pre>
     * 接受到的模型来源， 确认Trainer是否存在
     * </pre>
     *
     * <code>repeated uint64 server_ids = 1;</code>
     * @return The count of serverIds.
     */
    public int getServerIdsCount() {
      return serverIds_.size();
    }
    /**
     * <pre>
     * 接受到的模型来源， 确认Trainer是否存在
     * </pre>
     *
     * <code>repeated uint64 server_ids = 1;</code>
     * @param index The index of the element to return.
     * @return The serverIds at the given index.
     */
    public long getServerIds(int index) {
      return serverIds_.getLong(index);
    }
    /**
     * <pre>
     * 接受到的模型来源， 确认Trainer是否存在
     * </pre>
     *
     * <code>repeated uint64 server_ids = 1;</code>
     * @param index The index to set the value at.
     * @param value The serverIds to set.
     * @return This builder for chaining.
     */
    public Builder setServerIds(
        int index, long value) {
      ensureServerIdsIsMutable();
      serverIds_.setLong(index, value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 接受到的模型来源， 确认Trainer是否存在
     * </pre>
     *
     * <code>repeated uint64 server_ids = 1;</code>
     * @param value The serverIds to add.
     * @return This builder for chaining.
     */
    public Builder addServerIds(long value) {
      ensureServerIdsIsMutable();
      serverIds_.addLong(value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 接受到的模型来源， 确认Trainer是否存在
     * </pre>
     *
     * <code>repeated uint64 server_ids = 1;</code>
     * @param values The serverIds to add.
     * @return This builder for chaining.
     */
    public Builder addAllServerIds(
        java.lang.Iterable<? extends java.lang.Long> values) {
      ensureServerIdsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, serverIds_);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 接受到的模型来源， 确认Trainer是否存在
     * </pre>
     *
     * <code>repeated uint64 server_ids = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearServerIds() {
      serverIds_ = emptyLongList();
      bitField0_ = (bitField0_ & ~0x00000001);
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


    // @@protoc_insertion_point(builder_scope:fedraft.MergeRequest)
  }

  // @@protoc_insertion_point(class_scope:fedraft.MergeRequest)
  private static final org.bupt.fedraft.rpc.trainer.message.MergeRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.bupt.fedraft.rpc.trainer.message.MergeRequest();
  }

  public static org.bupt.fedraft.rpc.trainer.message.MergeRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MergeRequest>
      PARSER = new com.google.protobuf.AbstractParser<MergeRequest>() {
    @java.lang.Override
    public MergeRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<MergeRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MergeRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.bupt.fedraft.rpc.trainer.message.MergeRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

