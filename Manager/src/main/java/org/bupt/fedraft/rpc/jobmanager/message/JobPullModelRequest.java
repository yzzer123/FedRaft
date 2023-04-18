// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: jobmanager_message.proto

package org.bupt.fedraft.rpc.jobmanager.message;

/**
 * Protobuf type {@code fedraft.JobPullModelRequest}
 */
public final class JobPullModelRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:fedraft.JobPullModelRequest)
    JobPullModelRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use JobPullModelRequest.newBuilder() to construct.
  private JobPullModelRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private JobPullModelRequest() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new JobPullModelRequest();
  }

  @java.lang.Override
  public com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_JobPullModelRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_JobPullModelRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest.class, org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest.Builder.class);
  }

  public static final int TERM_FIELD_NUMBER = 1;
  private int term_;
  /**
   * <code>int32 term = 1;</code>
   * @return The term.
   */
  @java.lang.Override
  public int getTerm() {
    return term_;
  }

  public static final int MODELINDEX_FIELD_NUMBER = 2;
  private long modelIndex_;
  /**
   * <code>int64 modelIndex = 2;</code>
   * @return The modelIndex.
   */
  @java.lang.Override
  public long getModelIndex() {
    return modelIndex_;
  }

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
    if (term_ != 0) {
      output.writeInt32(1, term_);
    }
    if (modelIndex_ != 0L) {
      output.writeInt64(2, modelIndex_);
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
    if (modelIndex_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, modelIndex_);
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
    if (!(obj instanceof org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest)) {
      return super.equals(obj);
    }
    org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest other = (org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest) obj;

    if (getTerm()
        != other.getTerm()) return false;
    if (getModelIndex()
        != other.getModelIndex()) return false;
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
    hash = (37 * hash) + MODELINDEX_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getModelIndex());
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest parseFrom(
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
  public static Builder newBuilder(org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest prototype) {
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
   * Protobuf type {@code fedraft.JobPullModelRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:fedraft.JobPullModelRequest)
      org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequestOrBuilder {
    public static com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_JobPullModelRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_JobPullModelRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest.class, org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest.Builder.class);
    }

    // Construct using org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      term_ = 0;

      modelIndex_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_JobPullModelRequest_descriptor;
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest getDefaultInstanceForType() {
      return org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest.getDefaultInstance();
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest build() {
      org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest buildPartial() {
      org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest result = new org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest(this);
      result.term_ = term_;
      result.modelIndex_ = modelIndex_;
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
      if (other instanceof org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest) {
        return mergeFrom((org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest other) {
      if (other == org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest.getDefaultInstance()) return this;
      if (other.getTerm() != 0) {
        setTerm(other.getTerm());
      }
      if (other.getModelIndex() != 0L) {
        setModelIndex(other.getModelIndex());
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
              modelIndex_ = input.readInt64();

              break;
            } // case 16
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

    private int term_ ;
    /**
     * <code>int32 term = 1;</code>
     * @return The term.
     */
    @java.lang.Override
    public int getTerm() {
      return term_;
    }
    /**
     * <code>int32 term = 1;</code>
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
     * @return This builder for chaining.
     */
    public Builder clearTerm() {
      
      term_ = 0;
      onChanged();
      return this;
    }

    private long modelIndex_ ;
    /**
     * <code>int64 modelIndex = 2;</code>
     * @return The modelIndex.
     */
    @java.lang.Override
    public long getModelIndex() {
      return modelIndex_;
    }
    /**
     * <code>int64 modelIndex = 2;</code>
     * @param value The modelIndex to set.
     * @return This builder for chaining.
     */
    public Builder setModelIndex(long value) {
      
      modelIndex_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 modelIndex = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearModelIndex() {
      
      modelIndex_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:fedraft.JobPullModelRequest)
  }

  // @@protoc_insertion_point(class_scope:fedraft.JobPullModelRequest)
  private static final org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest();
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<JobPullModelRequest>
      PARSER = new com.google.protobuf.AbstractParser<JobPullModelRequest>() {
    @java.lang.Override
    public JobPullModelRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<JobPullModelRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<JobPullModelRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

