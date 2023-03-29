// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: manager_message.proto

package org.bupt.fedraft.rpc.manager.message;

/**
 * Protobuf type {@code fedraft.JobSubmitResponse}
 */
public final class JobSubmitResponse extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:fedraft.JobSubmitResponse)
        JobSubmitResponseOrBuilder {
    public static final int SUCCESS_FIELD_NUMBER = 1;
    public static final int LOGS_FIELD_NUMBER = 2;
    public static final int CHUNK_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0L;
    // @@protoc_insertion_point(class_scope:fedraft.JobSubmitResponse)
    private static final org.bupt.fedraft.rpc.manager.message.JobSubmitResponse DEFAULT_INSTANCE;
    private static final com.google.protobuf.Parser<JobSubmitResponse>
            PARSER = new com.google.protobuf.AbstractParser<JobSubmitResponse>() {
        @java.lang.Override
        public JobSubmitResponse parsePartialFrom(
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
        DEFAULT_INSTANCE = new org.bupt.fedraft.rpc.manager.message.JobSubmitResponse();
    }

    private int logCase_ = 0;
    private java.lang.Object log_;
    private byte memoizedIsInitialized = -1;

    // Use JobSubmitResponse.newBuilder() to construct.
    private JobSubmitResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private JobSubmitResponse() {
    }

    /**
     * <code>bool success = 1;</code>
     *
     * @return Whether the success field is set.
     */
    @java.lang.Override
    public boolean hasSuccess() {
        return logCase_ == 1;
    }

    /**
     * <code>bool success = 1;</code>
     * @return The success.
     */
    @java.lang.Override
    public boolean getSuccess() {
        if (logCase_ == 1) {
            return (java.lang.Boolean) log_;
        }
        return false;
    }

    public static com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
        return org.bupt.fedraft.rpc.manager.message.ManagerMessage.internal_static_fedraft_JobSubmitResponse_descriptor;
    }

    /**
     * <code>string logs = 2;</code>
     *
     * @return Whether the logs field is set.
     */
    public boolean hasLogs() {
        return logCase_ == 2;
    }

    public static org.bupt.fedraft.rpc.manager.message.JobSubmitResponse parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static org.bupt.fedraft.rpc.manager.message.JobSubmitResponse parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static org.bupt.fedraft.rpc.manager.message.JobSubmitResponse parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static org.bupt.fedraft.rpc.manager.message.JobSubmitResponse parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static org.bupt.fedraft.rpc.manager.message.JobSubmitResponse parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static org.bupt.fedraft.rpc.manager.message.JobSubmitResponse parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static org.bupt.fedraft.rpc.manager.message.JobSubmitResponse parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static org.bupt.fedraft.rpc.manager.message.JobSubmitResponse parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static org.bupt.fedraft.rpc.manager.message.JobSubmitResponse parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    public static org.bupt.fedraft.rpc.manager.message.JobSubmitResponse parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static org.bupt.fedraft.rpc.manager.message.JobSubmitResponse parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static org.bupt.fedraft.rpc.manager.message.JobSubmitResponse parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(org.bupt.fedraft.rpc.manager.message.JobSubmitResponse prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    public static org.bupt.fedraft.rpc.manager.message.JobSubmitResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<JobSubmitResponse> parser() {
        return PARSER;
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
            UnusedPrivateParameter unused) {
        return new JobSubmitResponse();
    }

    @java.lang.Override
    public com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
        return this.unknownFields;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
        return org.bupt.fedraft.rpc.manager.message.ManagerMessage.internal_static_fedraft_JobSubmitResponse_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        org.bupt.fedraft.rpc.manager.message.JobSubmitResponse.class, org.bupt.fedraft.rpc.manager.message.JobSubmitResponse.Builder.class);
    }

    public LogCase
    getLogCase() {
        return LogCase.forNumber(
                logCase_);
    }

    /**
     * <code>string logs = 2;</code>
     * @return The logs.
   */
  public java.lang.String getLogs() {
    java.lang.Object ref = "";
    if (logCase_ == 2) {
      ref = log_;
    }
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
        com.google.protobuf.ByteString bs =
                (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (logCase_ == 2) {
            log_ = s;
        }
        return s;
    }
  }

    /**
     * <code>string logs = 2;</code>
     *
     * @return The bytes for logs.
     */
    public com.google.protobuf.ByteString
    getLogsBytes() {
        java.lang.Object ref = "";
        if (logCase_ == 2) {
            ref = log_;
        }
        if (ref instanceof java.lang.String) {
            com.google.protobuf.ByteString b =
                    com.google.protobuf.ByteString.copyFromUtf8(
                            (java.lang.String) ref);
            if (logCase_ == 2) {
                log_ = b;
            }
            return b;
        } else {
            return (com.google.protobuf.ByteString) ref;
        }
    }

    /**
     * <code>bytes chunk = 3;</code>
     *
     * @return Whether the chunk field is set.
     */
    @java.lang.Override
    public boolean hasChunk() {
        return logCase_ == 3;
    }

    /**
     * <code>bytes chunk = 3;</code>
     *
     * @return The chunk.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getChunk() {
        if (logCase_ == 3) {
            return (com.google.protobuf.ByteString) log_;
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
        if (logCase_ == 1) {
            output.writeBool(
                    1, (Boolean) log_);
        }
        if (logCase_ == 2) {
            com.google.protobuf.GeneratedMessageV3.writeString(output, 2, log_);
        }
        if (logCase_ == 3) {
            output.writeBytes(
                    3, (com.google.protobuf.ByteString) log_);
        }
        getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) return size;

        size = 0;
        if (logCase_ == 1) {
            size += com.google.protobuf.CodedOutputStream
                    .computeBoolSize(
                            1, (Boolean) log_);
        }
        if (logCase_ == 2) {
            size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, log_);
        }
        if (logCase_ == 3) {
            size += com.google.protobuf.CodedOutputStream
                    .computeBytesSize(
                            3, (com.google.protobuf.ByteString) log_);
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
    if (!(obj instanceof org.bupt.fedraft.rpc.manager.message.JobSubmitResponse)) {
      return super.equals(obj);
    }
    org.bupt.fedraft.rpc.manager.message.JobSubmitResponse other = (org.bupt.fedraft.rpc.manager.message.JobSubmitResponse) obj;

    if (!getLogCase().equals(other.getLogCase())) return false;
      switch (logCase_) {
          case 1:
              if (getSuccess()
                      != other.getSuccess()) return false;
              break;
          case 2:
              if (!getLogs()
                      .equals(other.getLogs())) return false;
              break;
          case 3:
              if (!getChunk()
                      .equals(other.getChunk())) return false;
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
        switch (logCase_) {
            case 1:
                hash = (37 * hash) + SUCCESS_FIELD_NUMBER;
                hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
                        getSuccess());
                break;
            case 2:
                hash = (37 * hash) + LOGS_FIELD_NUMBER;
                hash = (53 * hash) + getLogs().hashCode();
                break;
            case 3:
                hash = (37 * hash) + CHUNK_FIELD_NUMBER;
                hash = (53 * hash) + getChunk().hashCode();
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
    public com.google.protobuf.Parser<JobSubmitResponse> getParserForType() {
        return PARSER;
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.manager.message.JobSubmitResponse getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public enum LogCase
            implements com.google.protobuf.Internal.EnumLite,
            com.google.protobuf.AbstractMessage.InternalOneOfEnum {
        SUCCESS(1),
        LOGS(2),
        CHUNK(3),
        LOG_NOT_SET(0);
        private final int value;

        LogCase(int value) {
            this.value = value;
        }
    /**
     * @param value The number of the enum to look for.
     * @return The enum associated with the given number.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static LogCase valueOf(int value) {
      return forNumber(value);
    }

        public static LogCase forNumber(int value) {
            switch (value) {
                case 1:
                    return SUCCESS;
                case 2:
                    return LOGS;
                case 3:
                    return CHUNK;
                case 0:
                    return LOG_NOT_SET;
                default:
                    return null;
            }
        }

        public int getNumber() {
            return this.value;
        }
    }

    /**
     * Protobuf type {@code fedraft.JobSubmitResponse}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:fedraft.JobSubmitResponse)
            org.bupt.fedraft.rpc.manager.message.JobSubmitResponseOrBuilder {
        private int logCase_ = 0;
        private java.lang.Object log_;

        // Construct using org.bupt.fedraft.rpc.manager.message.JobSubmitResponse.newBuilder()
        private Builder() {

        }

        private Builder(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            super(parent);

        }

        public static com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return org.bupt.fedraft.rpc.manager.message.ManagerMessage.internal_static_fedraft_JobSubmitResponse_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return org.bupt.fedraft.rpc.manager.message.ManagerMessage.internal_static_fedraft_JobSubmitResponse_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            org.bupt.fedraft.rpc.manager.message.JobSubmitResponse.class, org.bupt.fedraft.rpc.manager.message.JobSubmitResponse.Builder.class);
        }

        @java.lang.Override
        public org.bupt.fedraft.rpc.manager.message.JobSubmitResponse getDefaultInstanceForType() {
            return org.bupt.fedraft.rpc.manager.message.JobSubmitResponse.getDefaultInstance();
        }

        @java.lang.Override
        public org.bupt.fedraft.rpc.manager.message.JobSubmitResponse build() {
            org.bupt.fedraft.rpc.manager.message.JobSubmitResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.manager.message.JobSubmitResponse buildPartial() {
      org.bupt.fedraft.rpc.manager.message.JobSubmitResponse result = new org.bupt.fedraft.rpc.manager.message.JobSubmitResponse(this);
      if (logCase_ == 1) {
        result.log_ = log_;
      }
      if (logCase_ == 2) {
        result.log_ = log_;
      }
      if (logCase_ == 3) {
        result.log_ = log_;
      }
        result.logCase_ = logCase_;
        onBuilt();
        return result;
    }

        @java.lang.Override
        public Builder clear() {
            super.clear();
            logCase_ = 0;
            log_ = null;
            return this;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
            return org.bupt.fedraft.rpc.manager.message.ManagerMessage.internal_static_fedraft_JobSubmitResponse_descriptor;
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

        public Builder mergeFrom(org.bupt.fedraft.rpc.manager.message.JobSubmitResponse other) {
            if (other == org.bupt.fedraft.rpc.manager.message.JobSubmitResponse.getDefaultInstance()) return this;
            switch (other.getLogCase()) {
                case SUCCESS: {
                    setSuccess(other.getSuccess());
          break;
        }
        case LOGS: {
          logCase_ = 2;
          log_ = other.log_;
          onChanged();
          break;
        }
        case CHUNK: {
          setChunk(other.getChunk());
          break;
        }
        case LOG_NOT_SET: {
          break;
        }
      }
      this.mergeUnknownFields(other.getUnknownFields());
            onChanged();
            return this;
        }

        @java.lang.Override
        public Builder addRepeatedField(
                com.google.protobuf.Descriptors.FieldDescriptor field,
                java.lang.Object value) {
            return super.addRepeatedField(field, value);
        }

        @java.lang.Override
        public Builder mergeFrom(com.google.protobuf.Message other) {
            if (other instanceof org.bupt.fedraft.rpc.manager.message.JobSubmitResponse) {
                return mergeFrom((org.bupt.fedraft.rpc.manager.message.JobSubmitResponse) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
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
                            log_ = input.readBool();
                            logCase_ = 1;
                            break;
                        } // case 8
                        case 18: {
                            java.lang.String s = input.readStringRequireUtf8();
              logCase_ = 2;
              log_ = s;
              break;
            } // case 18
            case 26: {
              log_ = input.readBytes();
              logCase_ = 3;
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
    public LogCase
        getLogCase() {
      return LogCase.forNumber(
          logCase_);
    }

    public Builder clearLog() {
      logCase_ = 0;
      log_ = null;
      onChanged();
      return this;
    }


    /**
     * <code>bool success = 1;</code>
     * @return Whether the success field is set.
     */
    public boolean hasSuccess() {
      return logCase_ == 1;
    }
    /**
     * <code>bool success = 1;</code>
     * @return The success.
     */
    public boolean getSuccess() {
      if (logCase_ == 1) {
        return (java.lang.Boolean) log_;
      }
      return false;
    }
    /**
     * <code>bool success = 1;</code>
     * @param value The success to set.
     * @return This builder for chaining.
     */
    public Builder setSuccess(boolean value) {
      logCase_ = 1;
      log_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool success = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearSuccess() {
      if (logCase_ == 1) {
        logCase_ = 0;
        log_ = null;
        onChanged();
      }
      return this;
    }

    /**
     * <code>string logs = 2;</code>
     * @return Whether the logs field is set.
     */
    @java.lang.Override
    public boolean hasLogs() {
      return logCase_ == 2;
    }

    /**
     * <code>string logs = 2;</code>
     * @return The logs.
     */
    @java.lang.Override
    public java.lang.String getLogs() {
      java.lang.Object ref = "";
      if (logCase_ == 2) {
          ref = log_;
      }
        if (!(ref instanceof java.lang.String)) {
            com.google.protobuf.ByteString bs =
                    (com.google.protobuf.ByteString) ref;
            java.lang.String s = bs.toStringUtf8();
            if (logCase_ == 2) {
                log_ = s;
            }
            return s;
        } else {
            return (java.lang.String) ref;
        }
    }

        /**
         * <code>string logs = 2;</code>
         *
         * @param value The logs to set.
         * @return This builder for chaining.
         */
        public Builder setLogs(
                java.lang.String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            logCase_ = 2;
            log_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>string logs = 2;</code>
         *
         * @return The bytes for logs.
         */
        @java.lang.Override
        public com.google.protobuf.ByteString
        getLogsBytes() {
            java.lang.Object ref = "";
            if (logCase_ == 2) {
                ref = log_;
            }
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                if (logCase_ == 2) {
                    log_ = b;
                }
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        /**
         * <code>string logs = 2;</code>
         *
         * @param value The bytes for logs to set.
         * @return This builder for chaining.
         */
        public Builder setLogsBytes(
                com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            checkByteStringIsUtf8(value);
            logCase_ = 2;
            log_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>string logs = 2;</code>
         *
         * @return This builder for chaining.
         */
        public Builder clearLogs() {
            if (logCase_ == 2) {
                logCase_ = 0;
                log_ = null;
                onChanged();
            }
            return this;
        }

        /**
         * <code>bytes chunk = 3;</code>
         * @return Whether the chunk field is set.
     */
    public boolean hasChunk() {
      return logCase_ == 3;
    }
    /**
     * <code>bytes chunk = 3;</code>
     * @return The chunk.
     */
    public com.google.protobuf.ByteString getChunk() {
      if (logCase_ == 3) {
        return (com.google.protobuf.ByteString) log_;
      }
        return com.google.protobuf.ByteString.EMPTY;
    }

        /**
         * <code>bytes chunk = 3;</code>
         *
         * @param value The chunk to set.
         * @return This builder for chaining.
         */
        public Builder setChunk(com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            logCase_ = 3;
            log_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>bytes chunk = 3;</code>
         *
         * @return This builder for chaining.
         */
        public Builder clearChunk() {
            if (logCase_ == 3) {
                logCase_ = 0;
                log_ = null;
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


    // @@protoc_insertion_point(builder_scope:fedraft.JobSubmitResponse)
  }

}

