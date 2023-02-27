// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: jobmanager_message.proto

package org.bupt.fedraft.rpc.jobmanager.message;

/**
 * Protobuf type {@code fedraft.AppendJobLogRequest}
 */
public final class AppendJobLogRequest extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:fedraft.AppendJobLogRequest)
        AppendJobLogRequestOrBuilder {
  public static final int SOURCEID_FIELD_NUMBER = 1;
  public static final int UUID_FIELD_NUMBER = 2;
  public static final int LOGS_FIELD_NUMBER = 3;
  private static final long serialVersionUID = 0L;
  // @@protoc_insertion_point(class_scope:fedraft.AppendJobLogRequest)
  private static final org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest DEFAULT_INSTANCE;
  private static final com.google.protobuf.Parser<AppendJobLogRequest>
          PARSER = new com.google.protobuf.AbstractParser<AppendJobLogRequest>() {
    @java.lang.Override
    public AppendJobLogRequest parsePartialFrom(
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
    DEFAULT_INSTANCE = new org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest();
  }

  private long sourceId_;
  private int uuid_;
  private com.google.protobuf.LazyStringList logs_;
  private byte memoizedIsInitialized = -1;

  // Use AppendJobLogRequest.newBuilder() to construct.
  private AppendJobLogRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private AppendJobLogRequest() {
    logs_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  public static com.google.protobuf.Descriptors.Descriptor
  getDescriptor() {
    return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_AppendJobLogRequest_descriptor;
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest parseFrom(
          java.nio.ByteBuffer data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest parseFrom(
          java.nio.ByteBuffer data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest parseFrom(
          com.google.protobuf.ByteString data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest parseFrom(
          com.google.protobuf.ByteString data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest parseFrom(byte[] data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest parseFrom(
          byte[] data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest parseFrom(java.io.InputStream input)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input);
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest parseFrom(
          java.io.InputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest parseDelimitedFrom(java.io.InputStream input)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseDelimitedWithIOException(PARSER, input);
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest parseDelimitedFrom(
          java.io.InputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest parseFrom(
          com.google.protobuf.CodedInputStream input)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input);
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest parseFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  public static com.google.protobuf.Parser<AppendJobLogRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
          UnusedPrivateParameter unused) {
    return new AppendJobLogRequest();
  }

  @java.lang.Override
  public com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
  internalGetFieldAccessorTable() {
    return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_AppendJobLogRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                    org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest.class, org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest.Builder.class);
  }

  /**
   * <code>int64 sourceId = 1;</code>
   *
   * @return The sourceId.
   */
  @java.lang.Override
  public long getSourceId() {
    return sourceId_;
  }

  /**
   * <code>int32 uuid = 2;</code>
   *
   * @return The uuid.
   */
  @java.lang.Override
  public int getUuid() {
    return uuid_;
  }

  /**
   * <code>repeated string logs = 3;</code>
   *
   * @return A list containing the logs.
   */
  public com.google.protobuf.ProtocolStringList
  getLogsList() {
    return logs_;
  }

  /**
   * <code>repeated string logs = 3;</code>
   *
   * @return The count of logs.
   */
  public int getLogsCount() {
    return logs_.size();
  }

  /**
   * <code>repeated string logs = 3;</code>
   *
   * @param index The index of the element to return.
   * @return The logs at the given index.
   */
  public java.lang.String getLogs(int index) {
    return logs_.get(index);
  }

  /**
   * <code>repeated string logs = 3;</code>
   *
   * @param index The index of the value to return.
   * @return The bytes of the logs at the given index.
   */
  public com.google.protobuf.ByteString
  getLogsBytes(int index) {
    return logs_.getByteString(index);
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
    if (sourceId_ != 0L) {
      output.writeInt64(1, sourceId_);
    }
    if (uuid_ != 0) {
      output.writeInt32(2, uuid_);
    }
    for (int i = 0; i < logs_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, logs_.getRaw(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (sourceId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
              .computeInt64Size(1, sourceId_);
    }
    if (uuid_ != 0) {
      size += com.google.protobuf.CodedOutputStream
              .computeInt32Size(2, uuid_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < logs_.size(); i++) {
        dataSize += computeStringSizeNoTag(logs_.getRaw(i));
      }
      size += dataSize;
      size += getLogsList().size();
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
    if (!(obj instanceof org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest)) {
      return super.equals(obj);
    }
    org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest other = (org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest) obj;

    if (getSourceId()
            != other.getSourceId()) return false;
    if (getUuid()
            != other.getUuid()) return false;
    if (!getLogsList()
            .equals(other.getLogsList())) return false;
    return getUnknownFields().equals(other.getUnknownFields());
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + SOURCEID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
            getSourceId());
    hash = (37 * hash) + UUID_FIELD_NUMBER;
    hash = (53 * hash) + getUuid();
    if (getLogsCount() > 0) {
      hash = (37 * hash) + LOGS_FIELD_NUMBER;
      hash = (53 * hash) + getLogsList().hashCode();
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
  public com.google.protobuf.Parser<AppendJobLogRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

  /**
   * Protobuf type {@code fedraft.AppendJobLogRequest}
   */
  public static final class Builder extends
          com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
          // @@protoc_insertion_point(builder_implements:fedraft.AppendJobLogRequest)
          org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequestOrBuilder {
    private int bitField0_;
    private long sourceId_;
    private int uuid_;
    private com.google.protobuf.LazyStringList logs_ = com.google.protobuf.LazyStringArrayList.EMPTY;

    // Construct using org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest.newBuilder()
    private Builder() {

    }

    private Builder(
            com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }

    public static com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
      return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_AppendJobLogRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
      return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_AppendJobLogRequest_fieldAccessorTable
              .ensureFieldAccessorsInitialized(
                      org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest.class, org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest.Builder.class);
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      sourceId_ = 0L;

      uuid_ = 0;

      logs_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
    getDescriptorForType() {
      return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_AppendJobLogRequest_descriptor;
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest getDefaultInstanceForType() {
      return org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest.getDefaultInstance();
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest build() {
      org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest buildPartial() {
      org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest result = new org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest(this);
      int from_bitField0_ = bitField0_;
      result.sourceId_ = sourceId_;
      result.uuid_ = uuid_;
      if (((bitField0_ & 0x00000001) != 0)) {
        logs_ = logs_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.logs_ = logs_;
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
      if (other instanceof org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest) {
        return mergeFrom((org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest other) {
      if (other == org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest.getDefaultInstance()) return this;
      if (other.getSourceId() != 0L) {
        setSourceId(other.getSourceId());
      }
      if (other.getUuid() != 0) {
        setUuid(other.getUuid());
      }
      if (!other.logs_.isEmpty()) {
        if (logs_.isEmpty()) {
          logs_ = other.logs_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureLogsIsMutable();
          logs_.addAll(other.logs_);
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
              sourceId_ = input.readInt64();

              break;
            } // case 8
            case 16: {
              uuid_ = input.readInt32();

              break;
            } // case 16
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();
              ensureLogsIsMutable();
              logs_.add(s);
              break;
            } // case 26
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
     * <code>int64 sourceId = 1;</code>
     *
     * @return The sourceId.
     */
    @java.lang.Override
    public long getSourceId() {
      return sourceId_;
    }

    /**
     * <code>int64 sourceId = 1;</code>
     *
     * @param value The sourceId to set.
     * @return This builder for chaining.
     */
    public Builder setSourceId(long value) {

      sourceId_ = value;
      onChanged();
      return this;
    }

    /**
     * <code>int64 sourceId = 1;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearSourceId() {

      sourceId_ = 0L;
      onChanged();
      return this;
    }

    /**
     * <code>int32 uuid = 2;</code>
     *
     * @return The uuid.
     */
    @java.lang.Override
    public int getUuid() {
      return uuid_;
    }

    /**
     * <code>int32 uuid = 2;</code>
     *
     * @param value The uuid to set.
     * @return This builder for chaining.
     */
    public Builder setUuid(int value) {

      uuid_ = value;
      onChanged();
      return this;
    }

    /**
     * <code>int32 uuid = 2;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearUuid() {

      uuid_ = 0;
      onChanged();
      return this;
    }

    private void ensureLogsIsMutable() {
      if ((bitField0_ & 0x00000001) == 0) {
        logs_ = new com.google.protobuf.LazyStringArrayList(logs_);
        bitField0_ |= 0x00000001;
      }
    }

    /**
     * <code>repeated string logs = 3;</code>
     *
     * @return A list containing the logs.
     */
    public com.google.protobuf.ProtocolStringList
    getLogsList() {
      return logs_.getUnmodifiableView();
    }

    /**
     * <code>repeated string logs = 3;</code>
     *
     * @return The count of logs.
     */
    public int getLogsCount() {
      return logs_.size();
    }

    /**
     * <code>repeated string logs = 3;</code>
     *
     * @param index The index of the element to return.
     * @return The logs at the given index.
     */
    public java.lang.String getLogs(int index) {
      return logs_.get(index);
    }

    /**
     * <code>repeated string logs = 3;</code>
     *
     * @param index The index of the value to return.
     * @return The bytes of the logs at the given index.
     */
    public com.google.protobuf.ByteString
    getLogsBytes(int index) {
      return logs_.getByteString(index);
    }

    /**
     * <code>repeated string logs = 3;</code>
     *
     * @param index The index to set the value at.
     * @param value The logs to set.
     * @return This builder for chaining.
     */
    public Builder setLogs(
            int index, java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureLogsIsMutable();
      logs_.set(index, value);
      onChanged();
      return this;
    }

    /**
     * <code>repeated string logs = 3;</code>
     *
     * @param value The logs to add.
     * @return This builder for chaining.
     */
    public Builder addLogs(
            java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureLogsIsMutable();
      logs_.add(value);
      onChanged();
      return this;
    }

    /**
     * <code>repeated string logs = 3;</code>
     *
     * @param values The logs to add.
     * @return This builder for chaining.
     */
    public Builder addAllLogs(
            java.lang.Iterable<java.lang.String> values) {
      ensureLogsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, logs_);
      onChanged();
      return this;
    }

    /**
     * <code>repeated string logs = 3;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearLogs() {
      logs_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }

    /**
     * <code>repeated string logs = 3;</code>
     *
     * @param value The bytes of the logs to add.
     * @return This builder for chaining.
     */
    public Builder addLogsBytes(
            com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);
      ensureLogsIsMutable();
      logs_.add(value);
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


    // @@protoc_insertion_point(builder_scope:fedraft.AppendJobLogRequest)
  }

}

