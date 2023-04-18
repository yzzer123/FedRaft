// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: jobmanager_message.proto

package org.bupt.fedraft.rpc.jobmanager.message;

/**
 * Protobuf type {@code fedraft.JobPushModelRequest}
 */
public final class JobPushModelRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:fedraft.JobPushModelRequest)
    JobPushModelRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use JobPushModelRequest.newBuilder() to construct.
  private JobPushModelRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private JobPushModelRequest() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new JobPushModelRequest();
  }

  @java.lang.Override
  public com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_JobPushModelRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_JobPushModelRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest.class, org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest.Builder.class);
  }

  private int modelCase_ = 0;
  private java.lang.Object model_;
  public enum ModelCase
      implements com.google.protobuf.Internal.EnumLite,
          com.google.protobuf.AbstractMessage.InternalOneOfEnum {
    MODELINFO(1),
    MODELCHUNK(2),
    MODEL_NOT_SET(0);
    private final int value;
    ModelCase(int value) {
      this.value = value;
    }
    /**
     * @param value The number of the enum to look for.
     * @return The enum associated with the given number.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static ModelCase valueOf(int value) {
      return forNumber(value);
    }

    public static ModelCase forNumber(int value) {
      switch (value) {
        case 1: return MODELINFO;
        case 2: return MODELCHUNK;
        case 0: return MODEL_NOT_SET;
        default: return null;
      }
    }
    public int getNumber() {
      return this.value;
    }
  }

  public ModelCase
  getModelCase() {
    return ModelCase.forNumber(
        modelCase_);
  }

  public static final int MODELINFO_FIELD_NUMBER = 1;
  /**
   * <code>.fedraft.JobPullModelRequest modelInfo = 1;</code>
   * @return Whether the modelInfo field is set.
   */
  @java.lang.Override
  public boolean hasModelInfo() {
    return modelCase_ == 1;
  }
  /**
   * <code>.fedraft.JobPullModelRequest modelInfo = 1;</code>
   * @return The modelInfo.
   */
  @java.lang.Override
  public org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest getModelInfo() {
    if (modelCase_ == 1) {
       return (org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest) model_;
    }
    return org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest.getDefaultInstance();
  }
  /**
   * <code>.fedraft.JobPullModelRequest modelInfo = 1;</code>
   */
  @java.lang.Override
  public org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequestOrBuilder getModelInfoOrBuilder() {
    if (modelCase_ == 1) {
       return (org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest) model_;
    }
    return org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest.getDefaultInstance();
  }

  public static final int MODELCHUNK_FIELD_NUMBER = 2;
  /**
   * <code>bytes modelChunk = 2;</code>
   * @return Whether the modelChunk field is set.
   */
  @java.lang.Override
  public boolean hasModelChunk() {
    return modelCase_ == 2;
  }
  /**
   * <code>bytes modelChunk = 2;</code>
   * @return The modelChunk.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getModelChunk() {
    if (modelCase_ == 2) {
      return (com.google.protobuf.ByteString) model_;
    }
    return com.google.protobuf.ByteString.EMPTY;
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
    if (modelCase_ == 1) {
      output.writeMessage(1, (org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest) model_);
    }
    if (modelCase_ == 2) {
      output.writeBytes(
          2, (com.google.protobuf.ByteString) model_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (modelCase_ == 1) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, (org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest) model_);
    }
    if (modelCase_ == 2) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(
            2, (com.google.protobuf.ByteString) model_);
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
    if (!(obj instanceof org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest)) {
      return super.equals(obj);
    }
    org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest other = (org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest) obj;

    if (!getModelCase().equals(other.getModelCase())) return false;
    switch (modelCase_) {
      case 1:
        if (!getModelInfo()
            .equals(other.getModelInfo())) return false;
        break;
      case 2:
        if (!getModelChunk()
            .equals(other.getModelChunk())) return false;
        break;
      case 0:
      default:
    }
    return getUnknownFields().equals(other.getUnknownFields());
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    switch (modelCase_) {
      case 1:
        hash = (37 * hash) + MODELINFO_FIELD_NUMBER;
        hash = (53 * hash) + getModelInfo().hashCode();
        break;
      case 2:
        hash = (37 * hash) + MODELCHUNK_FIELD_NUMBER;
        hash = (53 * hash) + getModelChunk().hashCode();
        break;
      case 0:
      default:
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest parseFrom(
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
  public static Builder newBuilder(org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest prototype) {
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
   * Protobuf type {@code fedraft.JobPushModelRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:fedraft.JobPushModelRequest)
      org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequestOrBuilder {
    public static com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_JobPushModelRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_JobPushModelRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest.class, org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest.Builder.class);
    }

    // Construct using org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (modelInfoBuilder_ != null) {
        modelInfoBuilder_.clear();
      }
      modelCase_ = 0;
      model_ = null;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_JobPushModelRequest_descriptor;
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest getDefaultInstanceForType() {
      return org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest.getDefaultInstance();
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest build() {
      org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest buildPartial() {
      org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest result = new org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest(this);
      if (modelCase_ == 1) {
        if (modelInfoBuilder_ == null) {
          result.model_ = model_;
        } else {
          result.model_ = modelInfoBuilder_.build();
        }
      }
      if (modelCase_ == 2) {
        result.model_ = model_;
      }
      result.modelCase_ = modelCase_;
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
      if (other instanceof org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest) {
        return mergeFrom((org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest other) {
      if (other == org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest.getDefaultInstance()) return this;
      switch (other.getModelCase()) {
        case MODELINFO: {
          mergeModelInfo(other.getModelInfo());
          break;
        }
        case MODELCHUNK: {
          setModelChunk(other.getModelChunk());
          break;
        }
        case MODEL_NOT_SET: {
          break;
        }
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
            case 10: {
              input.readMessage(
                  getModelInfoFieldBuilder().getBuilder(),
                  extensionRegistry);
              modelCase_ = 1;
              break;
            } // case 10
            case 18: {
              model_ = input.readBytes();
              modelCase_ = 2;
              break;
            } // case 18
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
    private int modelCase_ = 0;
    private java.lang.Object model_;
    public ModelCase
        getModelCase() {
      return ModelCase.forNumber(
          modelCase_);
    }

    public Builder clearModel() {
      modelCase_ = 0;
      model_ = null;
      onChanged();
      return this;
    }


    private com.google.protobuf.SingleFieldBuilderV3<
        org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest, org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest.Builder, org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequestOrBuilder> modelInfoBuilder_;
    /**
     * <code>.fedraft.JobPullModelRequest modelInfo = 1;</code>
     * @return Whether the modelInfo field is set.
     */
    @java.lang.Override
    public boolean hasModelInfo() {
      return modelCase_ == 1;
    }
    /**
     * <code>.fedraft.JobPullModelRequest modelInfo = 1;</code>
     * @return The modelInfo.
     */
    @java.lang.Override
    public org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest getModelInfo() {
      if (modelInfoBuilder_ == null) {
        if (modelCase_ == 1) {
          return (org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest) model_;
        }
        return org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest.getDefaultInstance();
      } else {
        if (modelCase_ == 1) {
          return modelInfoBuilder_.getMessage();
        }
        return org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest.getDefaultInstance();
      }
    }
    /**
     * <code>.fedraft.JobPullModelRequest modelInfo = 1;</code>
     */
    public Builder setModelInfo(org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest value) {
      if (modelInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        model_ = value;
        onChanged();
      } else {
        modelInfoBuilder_.setMessage(value);
      }
      modelCase_ = 1;
      return this;
    }
    /**
     * <code>.fedraft.JobPullModelRequest modelInfo = 1;</code>
     */
    public Builder setModelInfo(
        org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest.Builder builderForValue) {
      if (modelInfoBuilder_ == null) {
        model_ = builderForValue.build();
        onChanged();
      } else {
        modelInfoBuilder_.setMessage(builderForValue.build());
      }
      modelCase_ = 1;
      return this;
    }
    /**
     * <code>.fedraft.JobPullModelRequest modelInfo = 1;</code>
     */
    public Builder mergeModelInfo(org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest value) {
      if (modelInfoBuilder_ == null) {
        if (modelCase_ == 1 &&
            model_ != org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest.getDefaultInstance()) {
          model_ = org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest.newBuilder((org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest) model_)
              .mergeFrom(value).buildPartial();
        } else {
          model_ = value;
        }
        onChanged();
      } else {
        if (modelCase_ == 1) {
          modelInfoBuilder_.mergeFrom(value);
        } else {
          modelInfoBuilder_.setMessage(value);
        }
      }
      modelCase_ = 1;
      return this;
    }
    /**
     * <code>.fedraft.JobPullModelRequest modelInfo = 1;</code>
     */
    public Builder clearModelInfo() {
      if (modelInfoBuilder_ == null) {
        if (modelCase_ == 1) {
          modelCase_ = 0;
          model_ = null;
          onChanged();
        }
      } else {
        if (modelCase_ == 1) {
          modelCase_ = 0;
          model_ = null;
        }
        modelInfoBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.fedraft.JobPullModelRequest modelInfo = 1;</code>
     */
    public org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest.Builder getModelInfoBuilder() {
      return getModelInfoFieldBuilder().getBuilder();
    }
    /**
     * <code>.fedraft.JobPullModelRequest modelInfo = 1;</code>
     */
    @java.lang.Override
    public org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequestOrBuilder getModelInfoOrBuilder() {
      if ((modelCase_ == 1) && (modelInfoBuilder_ != null)) {
        return modelInfoBuilder_.getMessageOrBuilder();
      } else {
        if (modelCase_ == 1) {
          return (org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest) model_;
        }
        return org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest.getDefaultInstance();
      }
    }
    /**
     * <code>.fedraft.JobPullModelRequest modelInfo = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest, org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest.Builder, org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequestOrBuilder> 
        getModelInfoFieldBuilder() {
      if (modelInfoBuilder_ == null) {
        if (!(modelCase_ == 1)) {
          model_ = org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest.getDefaultInstance();
        }
        modelInfoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest, org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest.Builder, org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequestOrBuilder>(
                (org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest) model_,
                getParentForChildren(),
                isClean());
        model_ = null;
      }
      modelCase_ = 1;
      onChanged();
      return modelInfoBuilder_;
    }

    /**
     * <code>bytes modelChunk = 2;</code>
     * @return Whether the modelChunk field is set.
     */
    public boolean hasModelChunk() {
      return modelCase_ == 2;
    }
    /**
     * <code>bytes modelChunk = 2;</code>
     * @return The modelChunk.
     */
    public com.google.protobuf.ByteString getModelChunk() {
      if (modelCase_ == 2) {
        return (com.google.protobuf.ByteString) model_;
      }
      return com.google.protobuf.ByteString.EMPTY;
    }
    /**
     * <code>bytes modelChunk = 2;</code>
     * @param value The modelChunk to set.
     * @return This builder for chaining.
     */
    public Builder setModelChunk(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  modelCase_ = 2;
      model_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bytes modelChunk = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearModelChunk() {
      if (modelCase_ == 2) {
        modelCase_ = 0;
        model_ = null;
        onChanged();
      }
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


    // @@protoc_insertion_point(builder_scope:fedraft.JobPushModelRequest)
  }

  // @@protoc_insertion_point(class_scope:fedraft.JobPushModelRequest)
  private static final org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest();
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<JobPushModelRequest>
      PARSER = new com.google.protobuf.AbstractParser<JobPushModelRequest>() {
    @java.lang.Override
    public JobPushModelRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<JobPushModelRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<JobPushModelRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
