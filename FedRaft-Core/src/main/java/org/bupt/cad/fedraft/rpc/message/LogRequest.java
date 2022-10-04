// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: log_message.proto

package org.bupt.cad.fedraft.rpc.message;

/**
 * Protobuf type {@code fedraft.LogRequest}
 */
public final class LogRequest extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:fedraft.LogRequest)
        LogRequestOrBuilder {
  private static final long serialVersionUID = 0L;

  // Use LogRequest.newBuilder() to construct.
  private LogRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private LogRequest() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
          UnusedPrivateParameter unused) {
    return new LogRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }

  private LogRequest(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
            com.google.protobuf.UnknownFieldSet.newBuilder();
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
          }
          case 16: {

            leaderId_ = input.readUInt32();
            break;
          }
          case 24: {

            preModelIndex_ = input.readUInt32();
            break;
          }
          case 32: {

            preModelTerm_ = input.readUInt32();
            break;
          }
          case 42: {
            data_ = input.readBytes();
            dataCase_ = 5;
            break;
          }
          case 50: {
            data_ = input.readBytes();
            dataCase_ = 6;
            break;
          }
          default: {
            if (!parseUnknownField(
                    input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (com.google.protobuf.UninitializedMessageException e) {
      throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
              e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor
  getDescriptor() {
    return org.bupt.cad.fedraft.rpc.message.LogMessage.internal_static_fedraft_LogRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
  internalGetFieldAccessorTable() {
    return org.bupt.cad.fedraft.rpc.message.LogMessage.internal_static_fedraft_LogRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                    org.bupt.cad.fedraft.rpc.message.LogRequest.class, org.bupt.cad.fedraft.rpc.message.LogRequest.Builder.class);
  }

  private int dataCase_ = 0;
  private java.lang.Object data_;
  public enum DataCase
          implements com.google.protobuf.Internal.EnumLite,
          com.google.protobuf.AbstractMessage.InternalOneOfEnum {
    MODEL_CHUNK(5),
    NETWORK_DELAYS(6),
    DATA_NOT_SET(0);
    private final int value;
    private DataCase(int value) {
      this.value = value;
    }
    /**
     * @param value The number of the enum to look for.
     * @return The enum associated with the given number.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static DataCase valueOf(int value) {
      return forNumber(value);
    }

    public static DataCase forNumber(int value) {
      switch (value) {
        case 5:
          return MODEL_CHUNK;
        case 6:
          return NETWORK_DELAYS;
        case 0:
          return DATA_NOT_SET;
        default:
          return null;
      }
    }

    public int getNumber() {
      return this.value;
    }
  }

  ;

  public DataCase
  getDataCase() {
    return DataCase.forNumber(
            dataCase_);
  }

  public static final int TERM_FIELD_NUMBER = 1;
  private int term_;

  /**
   * <code>uint32 term = 1;</code>
   * @return The term.
   */
  @java.lang.Override
  public int getTerm() {
    return term_;
  }

  public static final int LEADER_ID_FIELD_NUMBER = 2;
  private int leaderId_;
  /**
   * <code>uint32 leader_id = 2;</code>
   * @return The leaderId.
   */
  @java.lang.Override
  public int getLeaderId() {
    return leaderId_;
  }

  public static final int PRE_MODEL_INDEX_FIELD_NUMBER = 3;
  private int preModelIndex_;
  /**
   * <pre>
   * 之前发送模型的索引
   * </pre>
   *
   * <code>uint32 pre_model_index = 3;</code>
   * @return The preModelIndex.
   */
  @java.lang.Override
  public int getPreModelIndex() {
    return preModelIndex_;
  }

  public static final int PRE_MODEL_TERM_FIELD_NUMBER = 4;
  private int preModelTerm_;
  /**
   * <pre>
   * 之前发送模型的任期
   * </pre>
   *
   * <code>uint32 pre_model_term = 4;</code>
   * @return The preModelTerm.
   */
  @java.lang.Override
  public int getPreModelTerm() {
    return preModelTerm_;
  }

  public static final int MODEL_CHUNK_FIELD_NUMBER = 5;
  /**
   * <pre>
   * 模型的序列化块
   * </pre>
   *
   * <code>bytes model_chunk = 5;</code>
   * @return Whether the modelChunk field is set.
   */
  @java.lang.Override
  public boolean hasModelChunk() {
    return dataCase_ == 5;
  }
  /**
   * <pre>
   * 模型的序列化块
   * </pre>
   *
   * <code>bytes model_chunk = 5;</code>
   * @return The modelChunk.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getModelChunk() {
    if (dataCase_ == 5) {
      return (com.google.protobuf.ByteString) data_;
    }
    return com.google.protobuf.ByteString.EMPTY;
  }

  public static final int NETWORK_DELAYS_FIELD_NUMBER = 6;
  /**
   * <pre>
   * 网络时延拓扑
   * </pre>
   *
   * <code>bytes network_delays = 6;</code>
   * @return Whether the networkDelays field is set.
   */
  @java.lang.Override
  public boolean hasNetworkDelays() {
    return dataCase_ == 6;
  }
  /**
   * <pre>
   * 网络时延拓扑
   * </pre>
   *
   * <code>bytes network_delays = 6;</code>
   * @return The networkDelays.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getNetworkDelays() {
    if (dataCase_ == 6) {
      return (com.google.protobuf.ByteString) data_;
    }
    return com.google.protobuf.ByteString.EMPTY;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
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
      output.writeUInt32(1, term_);
    }
    if (leaderId_ != 0) {
      output.writeUInt32(2, leaderId_);
    }
    if (preModelIndex_ != 0) {
      output.writeUInt32(3, preModelIndex_);
    }
    if (preModelTerm_ != 0) {
      output.writeUInt32(4, preModelTerm_);
    }
    if (dataCase_ == 5) {
      output.writeBytes(
              5, (com.google.protobuf.ByteString) data_);
    }
    if (dataCase_ == 6) {
      output.writeBytes(
              6, (com.google.protobuf.ByteString) data_);
    }
    unknownFields.writeTo(output);
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
    if (leaderId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
              .computeUInt32Size(2, leaderId_);
    }
    if (preModelIndex_ != 0) {
      size += com.google.protobuf.CodedOutputStream
              .computeUInt32Size(3, preModelIndex_);
    }
    if (preModelTerm_ != 0) {
      size += com.google.protobuf.CodedOutputStream
              .computeUInt32Size(4, preModelTerm_);
    }
    if (dataCase_ == 5) {
      size += com.google.protobuf.CodedOutputStream
              .computeBytesSize(
                      5, (com.google.protobuf.ByteString) data_);
    }
    if (dataCase_ == 6) {
      size += com.google.protobuf.CodedOutputStream
              .computeBytesSize(
                      6, (com.google.protobuf.ByteString) data_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof org.bupt.cad.fedraft.rpc.message.LogRequest)) {
      return super.equals(obj);
    }
    org.bupt.cad.fedraft.rpc.message.LogRequest other = (org.bupt.cad.fedraft.rpc.message.LogRequest) obj;

    if (getTerm()
            != other.getTerm()) return false;
    if (getLeaderId()
            != other.getLeaderId()) return false;
    if (getPreModelIndex()
            != other.getPreModelIndex()) return false;
    if (getPreModelTerm()
            != other.getPreModelTerm()) return false;
    if (!getDataCase().equals(other.getDataCase())) return false;
    switch (dataCase_) {
      case 5:
        if (!getModelChunk()
                .equals(other.getModelChunk())) return false;
        break;
      case 6:
        if (!getNetworkDelays()
                .equals(other.getNetworkDelays())) return false;
        break;
      case 0:
      default:
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
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
    hash = (53 * hash) + getLeaderId();
    hash = (37 * hash) + PRE_MODEL_INDEX_FIELD_NUMBER;
    hash = (53 * hash) + getPreModelIndex();
    hash = (37 * hash) + PRE_MODEL_TERM_FIELD_NUMBER;
    hash = (53 * hash) + getPreModelTerm();
    switch (dataCase_) {
      case 5:
        hash = (37 * hash) + MODEL_CHUNK_FIELD_NUMBER;
        hash = (53 * hash) + getModelChunk().hashCode();
        break;
      case 6:
        hash = (37 * hash) + NETWORK_DELAYS_FIELD_NUMBER;
        hash = (53 * hash) + getNetworkDelays().hashCode();
        break;
      case 0:
      default:
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.bupt.cad.fedraft.rpc.message.LogRequest parseFrom(
          java.nio.ByteBuffer data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static org.bupt.cad.fedraft.rpc.message.LogRequest parseFrom(
          java.nio.ByteBuffer data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static org.bupt.cad.fedraft.rpc.message.LogRequest parseFrom(
          com.google.protobuf.ByteString data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static org.bupt.cad.fedraft.rpc.message.LogRequest parseFrom(
          com.google.protobuf.ByteString data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static org.bupt.cad.fedraft.rpc.message.LogRequest parseFrom(byte[] data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static org.bupt.cad.fedraft.rpc.message.LogRequest parseFrom(
          byte[] data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static org.bupt.cad.fedraft.rpc.message.LogRequest parseFrom(java.io.InputStream input)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input);
  }

  public static org.bupt.cad.fedraft.rpc.message.LogRequest parseFrom(
          java.io.InputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static org.bupt.cad.fedraft.rpc.message.LogRequest parseDelimitedFrom(java.io.InputStream input)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseDelimitedWithIOException(PARSER, input);
  }

  public static org.bupt.cad.fedraft.rpc.message.LogRequest parseDelimitedFrom(
          java.io.InputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }

  public static org.bupt.cad.fedraft.rpc.message.LogRequest parseFrom(
          com.google.protobuf.CodedInputStream input)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input);
  }

  public static org.bupt.cad.fedraft.rpc.message.LogRequest parseFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() {
    return newBuilder();
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.bupt.cad.fedraft.rpc.message.LogRequest prototype) {
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
   * Protobuf type {@code fedraft.LogRequest}
   */
  public static final class Builder extends
          com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
          // @@protoc_insertion_point(builder_implements:fedraft.LogRequest)
          org.bupt.cad.fedraft.rpc.message.LogRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
      return org.bupt.cad.fedraft.rpc.message.LogMessage.internal_static_fedraft_LogRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
      return org.bupt.cad.fedraft.rpc.message.LogMessage.internal_static_fedraft_LogRequest_fieldAccessorTable
              .ensureFieldAccessorsInitialized(
                      org.bupt.cad.fedraft.rpc.message.LogRequest.class, org.bupt.cad.fedraft.rpc.message.LogRequest.Builder.class);
    }

    // Construct using org.bupt.cad.fedraft.rpc.message.LogRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
            com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      term_ = 0;

      leaderId_ = 0;

      preModelIndex_ = 0;

      preModelTerm_ = 0;

      dataCase_ = 0;
      data_ = null;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
    getDescriptorForType() {
      return org.bupt.cad.fedraft.rpc.message.LogMessage.internal_static_fedraft_LogRequest_descriptor;
    }

    @java.lang.Override
    public org.bupt.cad.fedraft.rpc.message.LogRequest getDefaultInstanceForType() {
      return org.bupt.cad.fedraft.rpc.message.LogRequest.getDefaultInstance();
    }

    @java.lang.Override
    public org.bupt.cad.fedraft.rpc.message.LogRequest build() {
      org.bupt.cad.fedraft.rpc.message.LogRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.bupt.cad.fedraft.rpc.message.LogRequest buildPartial() {
      org.bupt.cad.fedraft.rpc.message.LogRequest result = new org.bupt.cad.fedraft.rpc.message.LogRequest(this);
      result.term_ = term_;
      result.leaderId_ = leaderId_;
      result.preModelIndex_ = preModelIndex_;
      result.preModelTerm_ = preModelTerm_;
      if (dataCase_ == 5) {
        result.data_ = data_;
      }
      if (dataCase_ == 6) {
        result.data_ = data_;
      }
      result.dataCase_ = dataCase_;
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
      if (other instanceof org.bupt.cad.fedraft.rpc.message.LogRequest) {
        return mergeFrom((org.bupt.cad.fedraft.rpc.message.LogRequest) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.bupt.cad.fedraft.rpc.message.LogRequest other) {
      if (other == org.bupt.cad.fedraft.rpc.message.LogRequest.getDefaultInstance()) return this;
      if (other.getTerm() != 0) {
        setTerm(other.getTerm());
      }
      if (other.getLeaderId() != 0) {
        setLeaderId(other.getLeaderId());
      }
      if (other.getPreModelIndex() != 0) {
        setPreModelIndex(other.getPreModelIndex());
      }
      if (other.getPreModelTerm() != 0) {
        setPreModelTerm(other.getPreModelTerm());
      }
      switch (other.getDataCase()) {
        case MODEL_CHUNK: {
          setModelChunk(other.getModelChunk());
          break;
        }
        case NETWORK_DELAYS: {
          setNetworkDelays(other.getNetworkDelays());
          break;
        }
        case DATA_NOT_SET: {
          break;
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      org.bupt.cad.fedraft.rpc.message.LogRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.bupt.cad.fedraft.rpc.message.LogRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int dataCase_ = 0;
    private java.lang.Object data_;

    public DataCase
    getDataCase() {
      return DataCase.forNumber(
              dataCase_);
    }

    public Builder clearData() {
      dataCase_ = 0;
      data_ = null;
      onChanged();
      return this;
    }


    private int term_;
    /**
     * <code>uint32 term = 1;</code>
     * @return The term.
     */
    @java.lang.Override
    public int getTerm() {
      return term_;
    }
    /**
     * <code>uint32 term = 1;</code>
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
     * @return This builder for chaining.
     */
    public Builder clearTerm() {

      term_ = 0;
      onChanged();
      return this;
    }

    private int leaderId_;
    /**
     * <code>uint32 leader_id = 2;</code>
     * @return The leaderId.
     */
    @java.lang.Override
    public int getLeaderId() {
      return leaderId_;
    }
    /**
     * <code>uint32 leader_id = 2;</code>
     * @param value The leaderId to set.
     * @return This builder for chaining.
     */
    public Builder setLeaderId(int value) {

      leaderId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 leader_id = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearLeaderId() {

      leaderId_ = 0;
      onChanged();
      return this;
    }

    private int preModelIndex_;
    /**
     * <pre>
     * 之前发送模型的索引
     * </pre>
     *
     * <code>uint32 pre_model_index = 3;</code>
     * @return The preModelIndex.
     */
    @java.lang.Override
    public int getPreModelIndex() {
      return preModelIndex_;
    }
    /**
     * <pre>
     * 之前发送模型的索引
     * </pre>
     *
     * <code>uint32 pre_model_index = 3;</code>
     * @param value The preModelIndex to set.
     * @return This builder for chaining.
     */
    public Builder setPreModelIndex(int value) {

      preModelIndex_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 之前发送模型的索引
     * </pre>
     *
     * <code>uint32 pre_model_index = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearPreModelIndex() {

      preModelIndex_ = 0;
      onChanged();
      return this;
    }

    private int preModelTerm_;
    /**
     * <pre>
     * 之前发送模型的任期
     * </pre>
     *
     * <code>uint32 pre_model_term = 4;</code>
     * @return The preModelTerm.
     */
    @java.lang.Override
    public int getPreModelTerm() {
      return preModelTerm_;
    }
    /**
     * <pre>
     * 之前发送模型的任期
     * </pre>
     *
     * <code>uint32 pre_model_term = 4;</code>
     * @param value The preModelTerm to set.
     * @return This builder for chaining.
     */
    public Builder setPreModelTerm(int value) {

      preModelTerm_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 之前发送模型的任期
     * </pre>
     *
     * <code>uint32 pre_model_term = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearPreModelTerm() {

      preModelTerm_ = 0;
      onChanged();
      return this;
    }

    /**
     * <pre>
     * 模型的序列化块
     * </pre>
     *
     * <code>bytes model_chunk = 5;</code>
     * @return Whether the modelChunk field is set.
     */
    public boolean hasModelChunk() {
      return dataCase_ == 5;
    }
    /**
     * <pre>
     * 模型的序列化块
     * </pre>
     *
     * <code>bytes model_chunk = 5;</code>
     * @return The modelChunk.
     */
    public com.google.protobuf.ByteString getModelChunk() {
      if (dataCase_ == 5) {
        return (com.google.protobuf.ByteString) data_;
      }
      return com.google.protobuf.ByteString.EMPTY;
    }
    /**
     * <pre>
     * 模型的序列化块
     * </pre>
     *
     * <code>bytes model_chunk = 5;</code>
     * @param value The modelChunk to set.
     * @return This builder for chaining.
     */
    public Builder setModelChunk(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      dataCase_ = 5;
      data_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 模型的序列化块
     * </pre>
     *
     * <code>bytes model_chunk = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearModelChunk() {
      if (dataCase_ == 5) {
        dataCase_ = 0;
        data_ = null;
        onChanged();
      }
      return this;
    }

    /**
     * <pre>
     * 网络时延拓扑
     * </pre>
     *
     * <code>bytes network_delays = 6;</code>
     * @return Whether the networkDelays field is set.
     */
    public boolean hasNetworkDelays() {
      return dataCase_ == 6;
    }
    /**
     * <pre>
     * 网络时延拓扑
     * </pre>
     *
     * <code>bytes network_delays = 6;</code>
     * @return The networkDelays.
     */
    public com.google.protobuf.ByteString getNetworkDelays() {
      if (dataCase_ == 6) {
        return (com.google.protobuf.ByteString) data_;
      }
      return com.google.protobuf.ByteString.EMPTY;
    }
    /**
     * <pre>
     * 网络时延拓扑
     * </pre>
     *
     * <code>bytes network_delays = 6;</code>
     * @param value The networkDelays to set.
     * @return This builder for chaining.
     */
    public Builder setNetworkDelays(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      dataCase_ = 6;
      data_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 网络时延拓扑
     * </pre>
     *
     * <code>bytes network_delays = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearNetworkDelays() {
      if (dataCase_ == 6) {
        dataCase_ = 0;
        data_ = null;
        onChanged();
      }
      return this;
    }

    @java.lang.Override
    public final Builder setUnknownFields(
            final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
            final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:fedraft.LogRequest)
  }

  // @@protoc_insertion_point(class_scope:fedraft.LogRequest)
  private static final org.bupt.cad.fedraft.rpc.message.LogRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.bupt.cad.fedraft.rpc.message.LogRequest();
  }

  public static org.bupt.cad.fedraft.rpc.message.LogRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LogRequest>
          PARSER = new com.google.protobuf.AbstractParser<LogRequest>() {
    @java.lang.Override
    public LogRequest parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return new LogRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<LogRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LogRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.bupt.cad.fedraft.rpc.message.LogRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

