// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: trainer_message.proto

package org.bupt.fedraft.rpc.trainer.message;

/**
 * Protobuf type {@code fedraft.InitModelRequest}
 */
public final class InitModelRequest extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:fedraft.InitModelRequest)
        InitModelRequestOrBuilder {
  public static final int MODEL_CHUNK_FIELD_NUMBER = 1;
  private static final long serialVersionUID = 0L;
  // @@protoc_insertion_point(class_scope:fedraft.InitModelRequest)
  private static final org.bupt.fedraft.rpc.trainer.message.InitModelRequest DEFAULT_INSTANCE;
  private static final com.google.protobuf.Parser<InitModelRequest>
          PARSER = new com.google.protobuf.AbstractParser<InitModelRequest>() {
    @java.lang.Override
    public InitModelRequest parsePartialFrom(
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
    DEFAULT_INSTANCE = new org.bupt.fedraft.rpc.trainer.message.InitModelRequest();
  }

  private com.google.protobuf.ByteString modelChunk_;
  private byte memoizedIsInitialized = -1;

  // Use InitModelRequest.newBuilder() to construct.
  private InitModelRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private InitModelRequest() {
    modelChunk_ = com.google.protobuf.ByteString.EMPTY;
  }

  public static com.google.protobuf.Descriptors.Descriptor
  getDescriptor() {
    return org.bupt.fedraft.rpc.trainer.message.TrainerMessage.internal_static_fedraft_InitModelRequest_descriptor;
  }

  public static org.bupt.fedraft.rpc.trainer.message.InitModelRequest parseFrom(
          java.nio.ByteBuffer data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static org.bupt.fedraft.rpc.trainer.message.InitModelRequest parseFrom(
          java.nio.ByteBuffer data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.trainer.message.InitModelRequest parseFrom(
          com.google.protobuf.ByteString data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static org.bupt.fedraft.rpc.trainer.message.InitModelRequest parseFrom(
          com.google.protobuf.ByteString data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.trainer.message.InitModelRequest parseFrom(byte[] data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static org.bupt.fedraft.rpc.trainer.message.InitModelRequest parseFrom(
          byte[] data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.trainer.message.InitModelRequest parseFrom(java.io.InputStream input)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input);
  }

  public static org.bupt.fedraft.rpc.trainer.message.InitModelRequest parseFrom(
          java.io.InputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.trainer.message.InitModelRequest parseDelimitedFrom(java.io.InputStream input)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseDelimitedWithIOException(PARSER, input);
  }

  public static org.bupt.fedraft.rpc.trainer.message.InitModelRequest parseDelimitedFrom(
          java.io.InputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.trainer.message.InitModelRequest parseFrom(
          com.google.protobuf.CodedInputStream input)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input);
  }

  public static org.bupt.fedraft.rpc.trainer.message.InitModelRequest parseFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(org.bupt.fedraft.rpc.trainer.message.InitModelRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public static org.bupt.fedraft.rpc.trainer.message.InitModelRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  public static com.google.protobuf.Parser<InitModelRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
          UnusedPrivateParameter unused) {
    return new InitModelRequest();
  }

  @java.lang.Override
  public com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
  internalGetFieldAccessorTable() {
    return org.bupt.fedraft.rpc.trainer.message.TrainerMessage.internal_static_fedraft_InitModelRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                    org.bupt.fedraft.rpc.trainer.message.InitModelRequest.class, org.bupt.fedraft.rpc.trainer.message.InitModelRequest.Builder.class);
  }

  /**
   * <code>bytes model_chunk = 1;</code>
   *
   * @return The modelChunk.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getModelChunk() {
    return modelChunk_;
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
    if (!(obj instanceof org.bupt.fedraft.rpc.trainer.message.InitModelRequest)) {
      return super.equals(obj);
    }
    org.bupt.fedraft.rpc.trainer.message.InitModelRequest other = (org.bupt.fedraft.rpc.trainer.message.InitModelRequest) obj;

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
  public com.google.protobuf.Parser<InitModelRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.bupt.fedraft.rpc.trainer.message.InitModelRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

  /**
   * Protobuf type {@code fedraft.InitModelRequest}
   */
  public static final class Builder extends
          com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
          // @@protoc_insertion_point(builder_implements:fedraft.InitModelRequest)
          org.bupt.fedraft.rpc.trainer.message.InitModelRequestOrBuilder {
    private com.google.protobuf.ByteString modelChunk_ = com.google.protobuf.ByteString.EMPTY;

    // Construct using org.bupt.fedraft.rpc.trainer.message.InitModelRequest.newBuilder()
    private Builder() {

    }

    private Builder(
            com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }

    public static com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
      return org.bupt.fedraft.rpc.trainer.message.TrainerMessage.internal_static_fedraft_InitModelRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
      return org.bupt.fedraft.rpc.trainer.message.TrainerMessage.internal_static_fedraft_InitModelRequest_fieldAccessorTable
              .ensureFieldAccessorsInitialized(
                      org.bupt.fedraft.rpc.trainer.message.InitModelRequest.class, org.bupt.fedraft.rpc.trainer.message.InitModelRequest.Builder.class);
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
      return org.bupt.fedraft.rpc.trainer.message.TrainerMessage.internal_static_fedraft_InitModelRequest_descriptor;
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.trainer.message.InitModelRequest getDefaultInstanceForType() {
      return org.bupt.fedraft.rpc.trainer.message.InitModelRequest.getDefaultInstance();
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.trainer.message.InitModelRequest build() {
      org.bupt.fedraft.rpc.trainer.message.InitModelRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.trainer.message.InitModelRequest buildPartial() {
      org.bupt.fedraft.rpc.trainer.message.InitModelRequest result = new org.bupt.fedraft.rpc.trainer.message.InitModelRequest(this);
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
      if (other instanceof org.bupt.fedraft.rpc.trainer.message.InitModelRequest) {
        return mergeFrom((org.bupt.fedraft.rpc.trainer.message.InitModelRequest) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.bupt.fedraft.rpc.trainer.message.InitModelRequest other) {
      if (other == org.bupt.fedraft.rpc.trainer.message.InitModelRequest.getDefaultInstance()) return this;
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
     *
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


    // @@protoc_insertion_point(builder_scope:fedraft.InitModelRequest)
  }

}

