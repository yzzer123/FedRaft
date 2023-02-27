// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vote_massage.proto

package org.bupt.cad.fedraft.rpc.message;

/**
 * Protobuf type {@code fedraft.VoteResponse}
 */
public final class VoteResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:fedraft.VoteResponse)
    VoteResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use VoteResponse.newBuilder() to construct.
  private VoteResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private VoteResponse() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new VoteResponse();
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
    return org.bupt.cad.fedraft.rpc.message.VoteMassage.internal_static_fedraft_VoteResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.bupt.cad.fedraft.rpc.message.VoteResponse.class, org.bupt.cad.fedraft.rpc.message.VoteResponse.Builder.class);
  }
  public static final int DELAY_FIELD_NUMBER = 2;
  public static final int VOTEGRANTED_FIELD_NUMBER = 3;
  /**
   * <code>uint32 term = 1;</code>
   * @return The term.
   */
  @java.lang.Override
  public int getTerm() {
    return term_;
  }
  // @@protoc_insertion_point(class_scope:fedraft.VoteResponse)
  private static final org.bupt.cad.fedraft.rpc.message.VoteResponse DEFAULT_INSTANCE;
  private int delay_;
  private static final com.google.protobuf.Parser<VoteResponse>
      PARSER = new com.google.protobuf.AbstractParser<VoteResponse>() {
    @java.lang.Override
    public VoteResponse parsePartialFrom(
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
    DEFAULT_INSTANCE = new org.bupt.cad.fedraft.rpc.message.VoteResponse();
  }
  private boolean voteGranted_;

  private int term_;

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public static com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.bupt.cad.fedraft.rpc.message.VoteMassage.internal_static_fedraft_VoteResponse_descriptor;
  }

  public static org.bupt.cad.fedraft.rpc.message.VoteResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  public static com.google.protobuf.Parser<VoteResponse> parser() {
    return PARSER;
  }

  /**
   * <pre>
   * 回复自己的时延
   * </pre>
   *
   * <code>int32 delay = 2;</code>
   * @return The delay.
   */
  @java.lang.Override
  public int getDelay() {
    return delay_;
  }

  public static org.bupt.cad.fedraft.rpc.message.VoteResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.bupt.cad.fedraft.rpc.message.VoteResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.bupt.cad.fedraft.rpc.message.VoteResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.bupt.cad.fedraft.rpc.message.VoteResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.bupt.cad.fedraft.rpc.message.VoteResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.bupt.cad.fedraft.rpc.message.VoteResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.bupt.cad.fedraft.rpc.message.VoteResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.bupt.cad.fedraft.rpc.message.VoteResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.bupt.cad.fedraft.rpc.message.VoteResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.bupt.cad.fedraft.rpc.message.VoteResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.bupt.cad.fedraft.rpc.message.VoteResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.bupt.cad.fedraft.rpc.message.VoteResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  /**
   * <code>bool voteGranted = 3;</code>
   * @return The voteGranted.
   */
  @java.lang.Override
  public boolean getVoteGranted() {
    return voteGranted_;
  }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.bupt.cad.fedraft.rpc.message.VoteResponse prototype) {
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

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (term_ != 0) {
      output.writeUInt32(1, term_);
    }
    if (delay_ != 0) {
      output.writeInt32(2, delay_);
    }
    if (voteGranted_) {
      output.writeBool(3, voteGranted_);
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
    if (delay_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, delay_);
    }
    if (voteGranted_) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(3, voteGranted_);
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
    if (!(obj instanceof org.bupt.cad.fedraft.rpc.message.VoteResponse)) {
      return super.equals(obj);
    }
    org.bupt.cad.fedraft.rpc.message.VoteResponse other = (org.bupt.cad.fedraft.rpc.message.VoteResponse) obj;

    if (getTerm()
        != other.getTerm()) return false;
    if (getDelay()
        != other.getDelay()) return false;
    if (getVoteGranted()
        != other.getVoteGranted()) return false;
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
    hash = (37 * hash) + DELAY_FIELD_NUMBER;
    hash = (53 * hash) + getDelay();
    hash = (37 * hash) + VOTEGRANTED_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getVoteGranted());
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }

  @java.lang.Override
  public com.google.protobuf.Parser<VoteResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.bupt.cad.fedraft.rpc.message.VoteResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

  /**
   * Protobuf type {@code fedraft.VoteResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:fedraft.VoteResponse)
      org.bupt.cad.fedraft.rpc.message.VoteResponseOrBuilder {
    public static com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.bupt.cad.fedraft.rpc.message.VoteMassage.internal_static_fedraft_VoteResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.bupt.cad.fedraft.rpc.message.VoteMassage.internal_static_fedraft_VoteResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.bupt.cad.fedraft.rpc.message.VoteResponse.class, org.bupt.cad.fedraft.rpc.message.VoteResponse.Builder.class);
    }

    private int term_ ;
    private int delay_ ;
    private boolean voteGranted_ ;

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.bupt.cad.fedraft.rpc.message.VoteMassage.internal_static_fedraft_VoteResponse_descriptor;
    }

    @java.lang.Override
    public org.bupt.cad.fedraft.rpc.message.VoteResponse getDefaultInstanceForType() {
      return org.bupt.cad.fedraft.rpc.message.VoteResponse.getDefaultInstance();
    }

    @java.lang.Override
    public org.bupt.cad.fedraft.rpc.message.VoteResponse build() {
      org.bupt.cad.fedraft.rpc.message.VoteResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    // Construct using org.bupt.cad.fedraft.rpc.message.VoteResponse.newBuilder()
    private Builder() {

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
      if (other instanceof org.bupt.cad.fedraft.rpc.message.VoteResponse) {
        return mergeFrom((org.bupt.cad.fedraft.rpc.message.VoteResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.bupt.cad.fedraft.rpc.message.VoteResponse other) {
      if (other == org.bupt.cad.fedraft.rpc.message.VoteResponse.getDefaultInstance()) return this;
      if (other.getTerm() != 0) {
        setTerm(other.getTerm());
      }
      if (other.getDelay() != 0) {
        setDelay(other.getDelay());
      }
      if (other.getVoteGranted()) {
        setVoteGranted(other.getVoteGranted());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

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
              delay_ = input.readInt32();

              break;
            } // case 16
            case 24: {
              voteGranted_ = input.readBool();

              break;
            } // case 24
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

    @java.lang.Override
    public Builder clear() {
      super.clear();
      term_ = 0;

      delay_ = 0;

      voteGranted_ = false;

      return this;
    }
    /**
     * <code>uint32 term = 1;</code>
     * @return The term.
     */
    @java.lang.Override
    public int getTerm() {
      return term_;
    }

    @java.lang.Override
    public org.bupt.cad.fedraft.rpc.message.VoteResponse buildPartial() {
      org.bupt.cad.fedraft.rpc.message.VoteResponse result = new org.bupt.cad.fedraft.rpc.message.VoteResponse(this);
      result.term_ = term_;
      result.delay_ = delay_;
      result.voteGranted_ = voteGranted_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public boolean isInitialized() {
      return true;
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
       *
       * @return This builder for chaining.
       */
      public Builder clearTerm() {

          term_ = 0;
          onChanged();
          return this;
      }

      /**
       * <pre>
       * 回复自己的时延
       * </pre>
       *
       * <code>int32 delay = 2;</code>
       *
       * @return The delay.
       */
      @java.lang.Override
      public int getDelay() {
          return delay_;
      }

      /**
       * <pre>
       * 回复自己的时延
       * </pre>
       *
       * <code>int32 delay = 2;</code>
     * @param value The delay to set.
     * @return This builder for chaining.
     */
    public Builder setDelay(int value) {

      delay_ = value;
      onChanged();
      return this;
    }

    /**
     * <pre>
     * 回复自己的时延
     * </pre>
     *
     * <code>int32 delay = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearDelay() {

      delay_ = 0;
      onChanged();
      return this;
    }
    /**
     * <code>bool voteGranted = 3;</code>
     * @return The voteGranted.
     */
    @java.lang.Override
    public boolean getVoteGranted() {
      return voteGranted_;
    }

    /**
     * <code>bool voteGranted = 3;</code>
     * @param value The voteGranted to set.
     * @return This builder for chaining.
     */
    public Builder setVoteGranted(boolean value) {

      voteGranted_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool voteGranted = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearVoteGranted() {

      voteGranted_ = false;
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


    // @@protoc_insertion_point(builder_scope:fedraft.VoteResponse)
  }

}
