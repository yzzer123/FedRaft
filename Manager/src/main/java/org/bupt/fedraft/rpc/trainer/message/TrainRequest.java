// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: trainer_message.proto

package org.bupt.fedraft.rpc.trainer.message;

/**
 * <pre>
 * 请求Trainer训练的模型
 * </pre>
 *
 * Protobuf type {@code fedraft.TrainRequest}
 */
public final class TrainRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:fedraft.TrainRequest)
    TrainRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TrainRequest.newBuilder() to construct.
  private TrainRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TrainRequest() {
    modelChunk_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new TrainRequest();
  }

  @java.lang.Override
  public com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.bupt.fedraft.rpc.trainer.message.TrainerMessage.internal_static_fedraft_TrainRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.bupt.fedraft.rpc.trainer.message.TrainerMessage.internal_static_fedraft_TrainRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.bupt.fedraft.rpc.trainer.message.TrainRequest.class, org.bupt.fedraft.rpc.trainer.message.TrainRequest.Builder.class);
  }

  public static final int MODEL_CHUNK_FIELD_NUMBER = 1;
  private com.google.protobuf.ByteString modelChunk_;
  /**
   * <code>bytes model_chunk = 1;</code>
   * @return The modelChunk.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getModelChunk() {
    return modelChunk_;
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
    if (!modelChunk_.isEmpty()) {
      output.writeBytes(1, modelChunk_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!modelChunk_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(1, modelChunk_);
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
    if (!(obj instanceof org.bupt.fedraft.rpc.trainer.message.TrainRequest)) {
      return super.equals(obj);
    }
    org.bupt.fedraft.rpc.trainer.message.TrainRequest other = (org.bupt.fedraft.rpc.trainer.message.TrainRequest) obj;

    if (!getModelChunk()
        .equals(other.getModelChunk())) return false;
    return getUnknownFields().equals(other.getUnknownFields());
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + MODEL_CHUNK_FIELD_NUMBER;
    hash = (53 * hash) + getModelChunk().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.bupt.fedraft.rpc.trainer.message.TrainRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.bupt.fedraft.rpc.trainer.message.TrainRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.bupt.fedraft.rpc.trainer.message.TrainRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.bupt.fedraft.rpc.trainer.message.TrainRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.bupt.fedraft.rpc.trainer.message.TrainRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.bupt.fedraft.rpc.trainer.message.TrainRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.bupt.fedraft.rpc.trainer.message.TrainRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.bupt.fedraft.rpc.trainer.message.TrainRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.bupt.fedraft.rpc.trainer.message.TrainRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.bupt.fedraft.rpc.trainer.message.TrainRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.bupt.fedraft.rpc.trainer.message.TrainRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.bupt.fedraft.rpc.trainer.message.TrainRequest parseFrom(
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
  public static Builder newBuilder(org.bupt.fedraft.rpc.trainer.message.TrainRequest prototype) {
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
   * 请求Trainer训练的模型
   * </pre>
   *
   * Protobuf type {@code fedraft.TrainRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:fedraft.TrainRequest)
      org.bupt.fedraft.rpc.trainer.message.TrainRequestOrBuilder {
    public static com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.bupt.fedraft.rpc.trainer.message.TrainerMessage.internal_static_fedraft_TrainRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.bupt.fedraft.rpc.trainer.message.TrainerMessage.internal_static_fedraft_TrainRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.bupt.fedraft.rpc.trainer.message.TrainRequest.class, org.bupt.fedraft.rpc.trainer.message.TrainRequest.Builder.class);
    }

    // Construct using org.bupt.fedraft.rpc.trainer.message.TrainRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      modelChunk_ = com.google.protobuf.ByteString.EMPTY;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.bupt.fedraft.rpc.trainer.message.TrainerMessage.internal_static_fedraft_TrainRequest_descriptor;
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.trainer.message.TrainRequest getDefaultInstanceForType() {
      return org.bupt.fedraft.rpc.trainer.message.TrainRequest.getDefaultInstance();
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.trainer.message.TrainRequest build() {
      org.bupt.fedraft.rpc.trainer.message.TrainRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.trainer.message.TrainRequest buildPartial() {
      org.bupt.fedraft.rpc.trainer.message.TrainRequest result = new org.bupt.fedraft.rpc.trainer.message.TrainRequest(this);
      result.modelChunk_ = modelChunk_;
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
      if (other instanceof org.bupt.fedraft.rpc.trainer.message.TrainRequest) {
        return mergeFrom((org.bupt.fedraft.rpc.trainer.message.TrainRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.bupt.fedraft.rpc.trainer.message.TrainRequest other) {
      if (other == org.bupt.fedraft.rpc.trainer.message.TrainRequest.getDefaultInstance()) return this;
      if (other.getModelChunk() != com.google.protobuf.ByteString.EMPTY) {
        setModelChunk(other.getModelChunk());
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
              modelChunk_ = input.readBytes();

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

    private com.google.protobuf.ByteString modelChunk_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes model_chunk = 1;</code>
     * @return The modelChunk.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getModelChunk() {
      return modelChunk_;
    }
    /**
     * <code>bytes model_chunk = 1;</code>
     * @param value The modelChunk to set.
     * @return This builder for chaining.
     */
    public Builder setModelChunk(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      modelChunk_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bytes model_chunk = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearModelChunk() {
      
      modelChunk_ = getDefaultInstance().getModelChunk();
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


    // @@protoc_insertion_point(builder_scope:fedraft.TrainRequest)
  }

  // @@protoc_insertion_point(class_scope:fedraft.TrainRequest)
  private static final org.bupt.fedraft.rpc.trainer.message.TrainRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.bupt.fedraft.rpc.trainer.message.TrainRequest();
  }

  public static org.bupt.fedraft.rpc.trainer.message.TrainRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TrainRequest>
      PARSER = new com.google.protobuf.AbstractParser<TrainRequest>() {
    @java.lang.Override
    public TrainRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<TrainRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TrainRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.bupt.fedraft.rpc.trainer.message.TrainRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

