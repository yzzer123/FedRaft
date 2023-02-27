// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: manager_message.proto

package org.bupt.fedraft.rpc.manager.message;

/**
 * Protobuf type {@code fedraft.JobSubmitRequest}
 */
public final class JobSubmitRequest extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:fedraft.JobSubmitRequest)
        JobSubmitRequestOrBuilder {
  public static final int CONF_FIELD_NUMBER = 1;
  public static final int MODELCHUNK_FIELD_NUMBER = 2;
  private static final long serialVersionUID = 0L;
  // @@protoc_insertion_point(class_scope:fedraft.JobSubmitRequest)
  private static final org.bupt.fedraft.rpc.manager.message.JobSubmitRequest DEFAULT_INSTANCE;
  private static final com.google.protobuf.Parser<JobSubmitRequest>
          PARSER = new com.google.protobuf.AbstractParser<JobSubmitRequest>() {
    @java.lang.Override
    public JobSubmitRequest parsePartialFrom(
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
    DEFAULT_INSTANCE = new org.bupt.fedraft.rpc.manager.message.JobSubmitRequest();
  }

  private int jobInfoCase_ = 0;
  private java.lang.Object jobInfo_;
  private byte memoizedIsInitialized = -1;

  // Use JobSubmitRequest.newBuilder() to construct.
  private JobSubmitRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private JobSubmitRequest() {
  }

  public static com.google.protobuf.Descriptors.Descriptor
  getDescriptor() {
    return org.bupt.fedraft.rpc.manager.message.ManagerMessage.internal_static_fedraft_JobSubmitRequest_descriptor;
  }

  public static org.bupt.fedraft.rpc.manager.message.JobSubmitRequest parseFrom(
          java.nio.ByteBuffer data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static org.bupt.fedraft.rpc.manager.message.JobSubmitRequest parseFrom(
          java.nio.ByteBuffer data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.manager.message.JobSubmitRequest parseFrom(
          com.google.protobuf.ByteString data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static org.bupt.fedraft.rpc.manager.message.JobSubmitRequest parseFrom(
          com.google.protobuf.ByteString data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.manager.message.JobSubmitRequest parseFrom(byte[] data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static org.bupt.fedraft.rpc.manager.message.JobSubmitRequest parseFrom(
          byte[] data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.manager.message.JobSubmitRequest parseFrom(java.io.InputStream input)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input);
  }

  public static org.bupt.fedraft.rpc.manager.message.JobSubmitRequest parseFrom(
          java.io.InputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.manager.message.JobSubmitRequest parseDelimitedFrom(java.io.InputStream input)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseDelimitedWithIOException(PARSER, input);
  }

  public static org.bupt.fedraft.rpc.manager.message.JobSubmitRequest parseDelimitedFrom(
          java.io.InputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.manager.message.JobSubmitRequest parseFrom(
          com.google.protobuf.CodedInputStream input)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input);
  }

  public static org.bupt.fedraft.rpc.manager.message.JobSubmitRequest parseFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(org.bupt.fedraft.rpc.manager.message.JobSubmitRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public static org.bupt.fedraft.rpc.manager.message.JobSubmitRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  public static com.google.protobuf.Parser<JobSubmitRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
          UnusedPrivateParameter unused) {
    return new JobSubmitRequest();
  }

  @java.lang.Override
  public com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
  internalGetFieldAccessorTable() {
    return org.bupt.fedraft.rpc.manager.message.ManagerMessage.internal_static_fedraft_JobSubmitRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                    org.bupt.fedraft.rpc.manager.message.JobSubmitRequest.class, org.bupt.fedraft.rpc.manager.message.JobSubmitRequest.Builder.class);
  }

  public JobInfoCase
  getJobInfoCase() {
    return JobInfoCase.forNumber(
            jobInfoCase_);
  }

  /**
   * <code>.fedraft.JobConfiguration conf = 1;</code>
   *
   * @return Whether the conf field is set.
   */
  @java.lang.Override
  public boolean hasConf() {
    return jobInfoCase_ == 1;
  }

  /**
   * <code>.fedraft.JobConfiguration conf = 1;</code>
   *
   * @return The conf.
   */
  @java.lang.Override
  public org.bupt.fedraft.rpc.manager.message.JobConfiguration getConf() {
    if (jobInfoCase_ == 1) {
      return (org.bupt.fedraft.rpc.manager.message.JobConfiguration) jobInfo_;
    }
    return org.bupt.fedraft.rpc.manager.message.JobConfiguration.getDefaultInstance();
  }

  /**
   * <code>.fedraft.JobConfiguration conf = 1;</code>
   */
  @java.lang.Override
  public org.bupt.fedraft.rpc.manager.message.JobConfigurationOrBuilder getConfOrBuilder() {
    if (jobInfoCase_ == 1) {
      return (org.bupt.fedraft.rpc.manager.message.JobConfiguration) jobInfo_;
    }
    return org.bupt.fedraft.rpc.manager.message.JobConfiguration.getDefaultInstance();
  }

  /**
   * <code>bytes modelChunk = 2;</code>
   *
   * @return Whether the modelChunk field is set.
   */
  @java.lang.Override
  public boolean hasModelChunk() {
    return jobInfoCase_ == 2;
  }

  /**
   * <code>bytes modelChunk = 2;</code>
   *
   * @return The modelChunk.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getModelChunk() {
    if (jobInfoCase_ == 2) {
      return (com.google.protobuf.ByteString) jobInfo_;
    }
    return com.google.protobuf.ByteString.EMPTY;
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
    if (jobInfoCase_ == 1) {
      output.writeMessage(1, (org.bupt.fedraft.rpc.manager.message.JobConfiguration) jobInfo_);
    }
    if (jobInfoCase_ == 2) {
      output.writeBytes(
              2, (com.google.protobuf.ByteString) jobInfo_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (jobInfoCase_ == 1) {
      size += com.google.protobuf.CodedOutputStream
              .computeMessageSize(1, (org.bupt.fedraft.rpc.manager.message.JobConfiguration) jobInfo_);
    }
    if (jobInfoCase_ == 2) {
      size += com.google.protobuf.CodedOutputStream
              .computeBytesSize(
                      2, (com.google.protobuf.ByteString) jobInfo_);
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
    if (!(obj instanceof org.bupt.fedraft.rpc.manager.message.JobSubmitRequest)) {
      return super.equals(obj);
    }
    org.bupt.fedraft.rpc.manager.message.JobSubmitRequest other = (org.bupt.fedraft.rpc.manager.message.JobSubmitRequest) obj;

    if (!getJobInfoCase().equals(other.getJobInfoCase())) return false;
    switch (jobInfoCase_) {
      case 1:
        if (!getConf()
                .equals(other.getConf())) return false;
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
    switch (jobInfoCase_) {
      case 1:
        hash = (37 * hash) + CONF_FIELD_NUMBER;
        hash = (53 * hash) + getConf().hashCode();
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
  public com.google.protobuf.Parser<JobSubmitRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.bupt.fedraft.rpc.manager.message.JobSubmitRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

  public enum JobInfoCase
          implements com.google.protobuf.Internal.EnumLite,
          com.google.protobuf.AbstractMessage.InternalOneOfEnum {
    CONF(1),
    MODELCHUNK(2),
    JOBINFO_NOT_SET(0);
    private final int value;

    JobInfoCase(int value) {
      this.value = value;
    }

    /**
     * @param value The number of the enum to look for.
     * @return The enum associated with the given number.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static JobInfoCase valueOf(int value) {
      return forNumber(value);
    }

    public static JobInfoCase forNumber(int value) {
      switch (value) {
        case 1:
          return CONF;
        case 2:
          return MODELCHUNK;
        case 0:
          return JOBINFO_NOT_SET;
        default:
          return null;
      }
    }

    public int getNumber() {
      return this.value;
    }
  }

  /**
   * Protobuf type {@code fedraft.JobSubmitRequest}
   */
  public static final class Builder extends
          com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
          // @@protoc_insertion_point(builder_implements:fedraft.JobSubmitRequest)
          org.bupt.fedraft.rpc.manager.message.JobSubmitRequestOrBuilder {
    private int jobInfoCase_ = 0;
    private java.lang.Object jobInfo_;
    private com.google.protobuf.SingleFieldBuilderV3<
            org.bupt.fedraft.rpc.manager.message.JobConfiguration, org.bupt.fedraft.rpc.manager.message.JobConfiguration.Builder, org.bupt.fedraft.rpc.manager.message.JobConfigurationOrBuilder> confBuilder_;

    // Construct using org.bupt.fedraft.rpc.manager.message.JobSubmitRequest.newBuilder()
    private Builder() {

    }

    private Builder(
            com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }

    public static com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
      return org.bupt.fedraft.rpc.manager.message.ManagerMessage.internal_static_fedraft_JobSubmitRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
      return org.bupt.fedraft.rpc.manager.message.ManagerMessage.internal_static_fedraft_JobSubmitRequest_fieldAccessorTable
              .ensureFieldAccessorsInitialized(
                      org.bupt.fedraft.rpc.manager.message.JobSubmitRequest.class, org.bupt.fedraft.rpc.manager.message.JobSubmitRequest.Builder.class);
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (confBuilder_ != null) {
        confBuilder_.clear();
      }
      jobInfoCase_ = 0;
      jobInfo_ = null;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
    getDescriptorForType() {
      return org.bupt.fedraft.rpc.manager.message.ManagerMessage.internal_static_fedraft_JobSubmitRequest_descriptor;
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.manager.message.JobSubmitRequest getDefaultInstanceForType() {
      return org.bupt.fedraft.rpc.manager.message.JobSubmitRequest.getDefaultInstance();
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.manager.message.JobSubmitRequest build() {
      org.bupt.fedraft.rpc.manager.message.JobSubmitRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.manager.message.JobSubmitRequest buildPartial() {
      org.bupt.fedraft.rpc.manager.message.JobSubmitRequest result = new org.bupt.fedraft.rpc.manager.message.JobSubmitRequest(this);
      if (jobInfoCase_ == 1) {
        if (confBuilder_ == null) {
          result.jobInfo_ = jobInfo_;
        } else {
          result.jobInfo_ = confBuilder_.build();
        }
      }
      if (jobInfoCase_ == 2) {
        result.jobInfo_ = jobInfo_;
      }
      result.jobInfoCase_ = jobInfoCase_;
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
      if (other instanceof org.bupt.fedraft.rpc.manager.message.JobSubmitRequest) {
        return mergeFrom((org.bupt.fedraft.rpc.manager.message.JobSubmitRequest) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.bupt.fedraft.rpc.manager.message.JobSubmitRequest other) {
      if (other == org.bupt.fedraft.rpc.manager.message.JobSubmitRequest.getDefaultInstance()) return this;
      switch (other.getJobInfoCase()) {
        case CONF: {
          mergeConf(other.getConf());
          break;
        }
        case MODELCHUNK: {
          setModelChunk(other.getModelChunk());
          break;
        }
        case JOBINFO_NOT_SET: {
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
                      getConfFieldBuilder().getBuilder(),
                      extensionRegistry);
              jobInfoCase_ = 1;
              break;
            } // case 10
            case 18: {
              jobInfo_ = input.readBytes();
              jobInfoCase_ = 2;
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

    public JobInfoCase
    getJobInfoCase() {
      return JobInfoCase.forNumber(
              jobInfoCase_);
    }

    public Builder clearJobInfo() {
      jobInfoCase_ = 0;
      jobInfo_ = null;
      onChanged();
      return this;
    }

    /**
     * <code>.fedraft.JobConfiguration conf = 1;</code>
     *
     * @return Whether the conf field is set.
     */
    @java.lang.Override
    public boolean hasConf() {
      return jobInfoCase_ == 1;
    }

    /**
     * <code>.fedraft.JobConfiguration conf = 1;</code>
     *
     * @return The conf.
     */
    @java.lang.Override
    public org.bupt.fedraft.rpc.manager.message.JobConfiguration getConf() {
      if (confBuilder_ == null) {
        if (jobInfoCase_ == 1) {
          return (org.bupt.fedraft.rpc.manager.message.JobConfiguration) jobInfo_;
        }
        return org.bupt.fedraft.rpc.manager.message.JobConfiguration.getDefaultInstance();
      } else {
        if (jobInfoCase_ == 1) {
          return confBuilder_.getMessage();
        }
        return org.bupt.fedraft.rpc.manager.message.JobConfiguration.getDefaultInstance();
      }
    }

    /**
     * <code>.fedraft.JobConfiguration conf = 1;</code>
     */
    public Builder setConf(org.bupt.fedraft.rpc.manager.message.JobConfiguration value) {
      if (confBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        jobInfo_ = value;
        onChanged();
      } else {
        confBuilder_.setMessage(value);
      }
      jobInfoCase_ = 1;
      return this;
    }

    /**
     * <code>.fedraft.JobConfiguration conf = 1;</code>
     */
    public Builder setConf(
            org.bupt.fedraft.rpc.manager.message.JobConfiguration.Builder builderForValue) {
      if (confBuilder_ == null) {
        jobInfo_ = builderForValue.build();
        onChanged();
      } else {
        confBuilder_.setMessage(builderForValue.build());
      }
      jobInfoCase_ = 1;
      return this;
    }

    /**
     * <code>.fedraft.JobConfiguration conf = 1;</code>
     */
    public Builder mergeConf(org.bupt.fedraft.rpc.manager.message.JobConfiguration value) {
      if (confBuilder_ == null) {
        if (jobInfoCase_ == 1 &&
                jobInfo_ != org.bupt.fedraft.rpc.manager.message.JobConfiguration.getDefaultInstance()) {
          jobInfo_ = org.bupt.fedraft.rpc.manager.message.JobConfiguration.newBuilder((org.bupt.fedraft.rpc.manager.message.JobConfiguration) jobInfo_)
                  .mergeFrom(value).buildPartial();
        } else {
          jobInfo_ = value;
        }
        onChanged();
      } else {
        if (jobInfoCase_ == 1) {
          confBuilder_.mergeFrom(value);
        } else {
          confBuilder_.setMessage(value);
        }
      }
      jobInfoCase_ = 1;
      return this;
    }

    /**
     * <code>.fedraft.JobConfiguration conf = 1;</code>
     */
    public Builder clearConf() {
      if (confBuilder_ == null) {
        if (jobInfoCase_ == 1) {
          jobInfoCase_ = 0;
          jobInfo_ = null;
          onChanged();
        }
      } else {
        if (jobInfoCase_ == 1) {
          jobInfoCase_ = 0;
          jobInfo_ = null;
        }
        confBuilder_.clear();
      }
      return this;
    }

    /**
     * <code>.fedraft.JobConfiguration conf = 1;</code>
     */
    public org.bupt.fedraft.rpc.manager.message.JobConfiguration.Builder getConfBuilder() {
      return getConfFieldBuilder().getBuilder();
    }

    /**
     * <code>.fedraft.JobConfiguration conf = 1;</code>
     */
    @java.lang.Override
    public org.bupt.fedraft.rpc.manager.message.JobConfigurationOrBuilder getConfOrBuilder() {
      if ((jobInfoCase_ == 1) && (confBuilder_ != null)) {
        return confBuilder_.getMessageOrBuilder();
      } else {
        if (jobInfoCase_ == 1) {
          return (org.bupt.fedraft.rpc.manager.message.JobConfiguration) jobInfo_;
        }
        return org.bupt.fedraft.rpc.manager.message.JobConfiguration.getDefaultInstance();
      }
    }

    /**
     * <code>.fedraft.JobConfiguration conf = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
            org.bupt.fedraft.rpc.manager.message.JobConfiguration, org.bupt.fedraft.rpc.manager.message.JobConfiguration.Builder, org.bupt.fedraft.rpc.manager.message.JobConfigurationOrBuilder>
    getConfFieldBuilder() {
      if (confBuilder_ == null) {
        if (!(jobInfoCase_ == 1)) {
          jobInfo_ = org.bupt.fedraft.rpc.manager.message.JobConfiguration.getDefaultInstance();
        }
        confBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                org.bupt.fedraft.rpc.manager.message.JobConfiguration, org.bupt.fedraft.rpc.manager.message.JobConfiguration.Builder, org.bupt.fedraft.rpc.manager.message.JobConfigurationOrBuilder>(
                (org.bupt.fedraft.rpc.manager.message.JobConfiguration) jobInfo_,
                getParentForChildren(),
                isClean());
        jobInfo_ = null;
      }
      jobInfoCase_ = 1;
      onChanged();
      return confBuilder_;
    }

    /**
     * <code>bytes modelChunk = 2;</code>
     *
     * @return Whether the modelChunk field is set.
     */
    public boolean hasModelChunk() {
      return jobInfoCase_ == 2;
    }

    /**
     * <code>bytes modelChunk = 2;</code>
     *
     * @return The modelChunk.
     */
    public com.google.protobuf.ByteString getModelChunk() {
      if (jobInfoCase_ == 2) {
        return (com.google.protobuf.ByteString) jobInfo_;
      }
      return com.google.protobuf.ByteString.EMPTY;
    }

    /**
     * <code>bytes modelChunk = 2;</code>
     *
     * @param value The modelChunk to set.
     * @return This builder for chaining.
     */
    public Builder setModelChunk(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      jobInfoCase_ = 2;
      jobInfo_ = value;
      onChanged();
      return this;
    }

    /**
     * <code>bytes modelChunk = 2;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearModelChunk() {
      if (jobInfoCase_ == 2) {
        jobInfoCase_ = 0;
        jobInfo_ = null;
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


    // @@protoc_insertion_point(builder_scope:fedraft.JobSubmitRequest)
  }

}

