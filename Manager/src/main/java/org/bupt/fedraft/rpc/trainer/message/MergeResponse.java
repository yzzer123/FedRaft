// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: trainer_message.proto

package org.bupt.fedraft.rpc.trainer.message;

/**
 * <pre>
 * 合并完成的模型
 * </pre>
 *
 * Protobuf type {@code fedraft.MergeResponse}
 */
public final class MergeResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:fedraft.MergeResponse)
    MergeResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MergeResponse.newBuilder() to construct.
  private MergeResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MergeResponse() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new MergeResponse();
  }

  @java.lang.Override
  public com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.bupt.fedraft.rpc.trainer.message.TrainerMessage.internal_static_fedraft_MergeResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.bupt.fedraft.rpc.trainer.message.TrainerMessage.internal_static_fedraft_MergeResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.bupt.fedraft.rpc.trainer.message.MergeResponse.class, org.bupt.fedraft.rpc.trainer.message.MergeResponse.Builder.class);
  }

  private int modelCase_ = 0;
  private java.lang.Object model_;
  public enum ModelCase
      implements com.google.protobuf.Internal.EnumLite,
          com.google.protobuf.AbstractMessage.InternalOneOfEnum {
    SERVER_ID(1),
    MODEL_CHUNK(2),
    MODEL_EVAL_LOG(3),
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
        case 1: return SERVER_ID;
        case 2: return MODEL_CHUNK;
        case 3: return MODEL_EVAL_LOG;
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

  public static final int SERVER_ID_FIELD_NUMBER = 1;
  /**
   * <pre>
   * 回复第一个缺失的模型ID
   * </pre>
   *
   * <code>uint64 server_id = 1;</code>
   * @return Whether the serverId field is set.
   */
  @java.lang.Override
  public boolean hasServerId() {
    return modelCase_ == 1;
  }
  /**
   * <pre>
   * 回复第一个缺失的模型ID
   * </pre>
   *
   * <code>uint64 server_id = 1;</code>
   * @return The serverId.
   */
  @java.lang.Override
  public long getServerId() {
    if (modelCase_ == 1) {
      return (java.lang.Long) model_;
    }
    return 0L;
  }

  public static final int MODEL_CHUNK_FIELD_NUMBER = 2;
  /**
   * <pre>
   * 合并成功的模型
   * </pre>
   *
   * <code>bytes model_chunk = 2;</code>
   * @return Whether the modelChunk field is set.
   */
  @java.lang.Override
  public boolean hasModelChunk() {
    return modelCase_ == 2;
  }
  /**
   * <pre>
   * 合并成功的模型
   * </pre>
   *
   * <code>bytes model_chunk = 2;</code>
   * @return The modelChunk.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getModelChunk() {
    if (modelCase_ == 2) {
      return (com.google.protobuf.ByteString) model_;
    }
    return com.google.protobuf.ByteString.EMPTY;
  }

  public static final int MODEL_EVAL_LOG_FIELD_NUMBER = 3;
  /**
   * <pre>
   * 合并模型的测试结果
   * </pre>
   *
   * <code>string model_eval_log = 3;</code>
   * @return Whether the modelEvalLog field is set.
   */
  public boolean hasModelEvalLog() {
    return modelCase_ == 3;
  }
  /**
   * <pre>
   * 合并模型的测试结果
   * </pre>
   *
   * <code>string model_eval_log = 3;</code>
   * @return The modelEvalLog.
   */
  public java.lang.String getModelEvalLog() {
    java.lang.Object ref = "";
    if (modelCase_ == 3) {
      ref = model_;
    }
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (modelCase_ == 3) {
        model_ = s;
      }
      return s;
    }
  }
  /**
   * <pre>
   * 合并模型的测试结果
   * </pre>
   *
   * <code>string model_eval_log = 3;</code>
   * @return The bytes for modelEvalLog.
   */
  public com.google.protobuf.ByteString
      getModelEvalLogBytes() {
    java.lang.Object ref = "";
    if (modelCase_ == 3) {
      ref = model_;
    }
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      if (modelCase_ == 3) {
        model_ = b;
      }
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
      output.writeUInt64(
          1, (Long) model_);
    }
    if (modelCase_ == 2) {
      output.writeBytes(
          2, (com.google.protobuf.ByteString) model_);
    }
    if (modelCase_ == 3) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, model_);
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
        .computeUInt64Size(
            1, (Long) model_);
    }
    if (modelCase_ == 2) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(
            2, (com.google.protobuf.ByteString) model_);
    }
    if (modelCase_ == 3) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, model_);
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
    if (!(obj instanceof org.bupt.fedraft.rpc.trainer.message.MergeResponse)) {
      return super.equals(obj);
    }
    org.bupt.fedraft.rpc.trainer.message.MergeResponse other = (org.bupt.fedraft.rpc.trainer.message.MergeResponse) obj;

    if (!getModelCase().equals(other.getModelCase())) return false;
    switch (modelCase_) {
      case 1:
        if (getServerId()
            != other.getServerId()) return false;
        break;
      case 2:
        if (!getModelChunk()
            .equals(other.getModelChunk())) return false;
        break;
      case 3:
        if (!getModelEvalLog()
            .equals(other.getModelEvalLog())) return false;
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
        hash = (37 * hash) + SERVER_ID_FIELD_NUMBER;
        hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
            getServerId());
        break;
      case 2:
        hash = (37 * hash) + MODEL_CHUNK_FIELD_NUMBER;
        hash = (53 * hash) + getModelChunk().hashCode();
        break;
      case 3:
        hash = (37 * hash) + MODEL_EVAL_LOG_FIELD_NUMBER;
        hash = (53 * hash) + getModelEvalLog().hashCode();
        break;
      case 0:
      default:
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.bupt.fedraft.rpc.trainer.message.MergeResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.bupt.fedraft.rpc.trainer.message.MergeResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.bupt.fedraft.rpc.trainer.message.MergeResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.bupt.fedraft.rpc.trainer.message.MergeResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.bupt.fedraft.rpc.trainer.message.MergeResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.bupt.fedraft.rpc.trainer.message.MergeResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.bupt.fedraft.rpc.trainer.message.MergeResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.bupt.fedraft.rpc.trainer.message.MergeResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.bupt.fedraft.rpc.trainer.message.MergeResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.bupt.fedraft.rpc.trainer.message.MergeResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.bupt.fedraft.rpc.trainer.message.MergeResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.bupt.fedraft.rpc.trainer.message.MergeResponse parseFrom(
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
  public static Builder newBuilder(org.bupt.fedraft.rpc.trainer.message.MergeResponse prototype) {
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
   * 合并完成的模型
   * </pre>
   *
   * Protobuf type {@code fedraft.MergeResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:fedraft.MergeResponse)
      org.bupt.fedraft.rpc.trainer.message.MergeResponseOrBuilder {
    public static com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.bupt.fedraft.rpc.trainer.message.TrainerMessage.internal_static_fedraft_MergeResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.bupt.fedraft.rpc.trainer.message.TrainerMessage.internal_static_fedraft_MergeResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.bupt.fedraft.rpc.trainer.message.MergeResponse.class, org.bupt.fedraft.rpc.trainer.message.MergeResponse.Builder.class);
    }

    // Construct using org.bupt.fedraft.rpc.trainer.message.MergeResponse.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      modelCase_ = 0;
      model_ = null;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.bupt.fedraft.rpc.trainer.message.TrainerMessage.internal_static_fedraft_MergeResponse_descriptor;
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.trainer.message.MergeResponse getDefaultInstanceForType() {
      return org.bupt.fedraft.rpc.trainer.message.MergeResponse.getDefaultInstance();
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.trainer.message.MergeResponse build() {
      org.bupt.fedraft.rpc.trainer.message.MergeResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.trainer.message.MergeResponse buildPartial() {
      org.bupt.fedraft.rpc.trainer.message.MergeResponse result = new org.bupt.fedraft.rpc.trainer.message.MergeResponse(this);
      if (modelCase_ == 1) {
        result.model_ = model_;
      }
      if (modelCase_ == 2) {
        result.model_ = model_;
      }
      if (modelCase_ == 3) {
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
      if (other instanceof org.bupt.fedraft.rpc.trainer.message.MergeResponse) {
        return mergeFrom((org.bupt.fedraft.rpc.trainer.message.MergeResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.bupt.fedraft.rpc.trainer.message.MergeResponse other) {
      if (other == org.bupt.fedraft.rpc.trainer.message.MergeResponse.getDefaultInstance()) return this;
      switch (other.getModelCase()) {
        case SERVER_ID: {
          setServerId(other.getServerId());
          break;
        }
        case MODEL_CHUNK: {
          setModelChunk(other.getModelChunk());
          break;
        }
        case MODEL_EVAL_LOG: {
          modelCase_ = 3;
          model_ = other.model_;
          onChanged();
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
            case 8: {
              model_ = input.readUInt64();
              modelCase_ = 1;
              break;
            } // case 8
            case 18: {
              model_ = input.readBytes();
              modelCase_ = 2;
              break;
            } // case 18
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();
              modelCase_ = 3;
              model_ = s;
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


    /**
     * <pre>
     * 回复第一个缺失的模型ID
     * </pre>
     *
     * <code>uint64 server_id = 1;</code>
     * @return Whether the serverId field is set.
     */
    public boolean hasServerId() {
      return modelCase_ == 1;
    }
    /**
     * <pre>
     * 回复第一个缺失的模型ID
     * </pre>
     *
     * <code>uint64 server_id = 1;</code>
     * @return The serverId.
     */
    public long getServerId() {
      if (modelCase_ == 1) {
        return (java.lang.Long) model_;
      }
      return 0L;
    }
    /**
     * <pre>
     * 回复第一个缺失的模型ID
     * </pre>
     *
     * <code>uint64 server_id = 1;</code>
     * @param value The serverId to set.
     * @return This builder for chaining.
     */
    public Builder setServerId(long value) {
      modelCase_ = 1;
      model_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 回复第一个缺失的模型ID
     * </pre>
     *
     * <code>uint64 server_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearServerId() {
      if (modelCase_ == 1) {
        modelCase_ = 0;
        model_ = null;
        onChanged();
      }
      return this;
    }

    /**
     * <pre>
     * 合并成功的模型
     * </pre>
     *
     * <code>bytes model_chunk = 2;</code>
     * @return Whether the modelChunk field is set.
     */
    public boolean hasModelChunk() {
      return modelCase_ == 2;
    }
    /**
     * <pre>
     * 合并成功的模型
     * </pre>
     *
     * <code>bytes model_chunk = 2;</code>
     * @return The modelChunk.
     */
    public com.google.protobuf.ByteString getModelChunk() {
      if (modelCase_ == 2) {
        return (com.google.protobuf.ByteString) model_;
      }
      return com.google.protobuf.ByteString.EMPTY;
    }
    /**
     * <pre>
     * 合并成功的模型
     * </pre>
     *
     * <code>bytes model_chunk = 2;</code>
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
     * <pre>
     * 合并成功的模型
     * </pre>
     *
     * <code>bytes model_chunk = 2;</code>
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

    /**
     * <pre>
     * 合并模型的测试结果
     * </pre>
     *
     * <code>string model_eval_log = 3;</code>
     * @return Whether the modelEvalLog field is set.
     */
    @java.lang.Override
    public boolean hasModelEvalLog() {
      return modelCase_ == 3;
    }
    /**
     * <pre>
     * 合并模型的测试结果
     * </pre>
     *
     * <code>string model_eval_log = 3;</code>
     * @return The modelEvalLog.
     */
    @java.lang.Override
    public java.lang.String getModelEvalLog() {
      java.lang.Object ref = "";
      if (modelCase_ == 3) {
        ref = model_;
      }
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (modelCase_ == 3) {
          model_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * 合并模型的测试结果
     * </pre>
     *
     * <code>string model_eval_log = 3;</code>
     * @return The bytes for modelEvalLog.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getModelEvalLogBytes() {
      java.lang.Object ref = "";
      if (modelCase_ == 3) {
        ref = model_;
      }
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        if (modelCase_ == 3) {
          model_ = b;
        }
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * 合并模型的测试结果
     * </pre>
     *
     * <code>string model_eval_log = 3;</code>
     * @param value The modelEvalLog to set.
     * @return This builder for chaining.
     */
    public Builder setModelEvalLog(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  modelCase_ = 3;
      model_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 合并模型的测试结果
     * </pre>
     *
     * <code>string model_eval_log = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearModelEvalLog() {
      if (modelCase_ == 3) {
        modelCase_ = 0;
        model_ = null;
        onChanged();
      }
      return this;
    }
    /**
     * <pre>
     * 合并模型的测试结果
     * </pre>
     *
     * <code>string model_eval_log = 3;</code>
     * @param value The bytes for modelEvalLog to set.
     * @return This builder for chaining.
     */
    public Builder setModelEvalLogBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      modelCase_ = 3;
      model_ = value;
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


    // @@protoc_insertion_point(builder_scope:fedraft.MergeResponse)
  }

  // @@protoc_insertion_point(class_scope:fedraft.MergeResponse)
  private static final org.bupt.fedraft.rpc.trainer.message.MergeResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.bupt.fedraft.rpc.trainer.message.MergeResponse();
  }

  public static org.bupt.fedraft.rpc.trainer.message.MergeResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MergeResponse>
      PARSER = new com.google.protobuf.AbstractParser<MergeResponse>() {
    @java.lang.Override
    public MergeResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<MergeResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MergeResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.bupt.fedraft.rpc.trainer.message.MergeResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

