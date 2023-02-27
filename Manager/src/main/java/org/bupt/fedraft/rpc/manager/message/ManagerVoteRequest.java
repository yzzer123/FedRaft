// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: manager_message.proto

package org.bupt.fedraft.rpc.manager.message;

/**
 * Protobuf type {@code fedraft.ManagerVoteRequest}
 */
public final class ManagerVoteRequest extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:fedraft.ManagerVoteRequest)
        ManagerVoteRequestOrBuilder {
    public static final int TERM_FIELD_NUMBER = 1;

    // Use ManagerVoteRequest.newBuilder() to construct.
    private ManagerVoteRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private ManagerVoteRequest() {
    }

    public static final int CANDIDATEID_FIELD_NUMBER = 2;

    @java.lang.Override
    public com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
        return this.unknownFields;
    }

    public static final int ENTRYINDEX_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0L;
    // @@protoc_insertion_point(class_scope:fedraft.ManagerVoteRequest)
    private static final org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest DEFAULT_INSTANCE;
    private static final com.google.protobuf.Parser<ManagerVoteRequest>
            PARSER = new com.google.protobuf.AbstractParser<ManagerVoteRequest>() {
        @java.lang.Override
        public ManagerVoteRequest parsePartialFrom(
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

    /**
     * <code>int32 term = 1;</code>
     *
     * @return The term.
     */
    @java.lang.Override
    public int getTerm() {
        return term_;
    }

    static {
        DEFAULT_INSTANCE = new org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest();
    }

    private int term_;

    /**
     * <code>int64 candidateId = 2;</code>
     *
     * @return The candidateId.
     */
    @java.lang.Override
    public long getCandidateId() {
        return candidateId_;
    }

    private long candidateId_;
    private long entryIndex_;

    /**
     * <pre>
     * 拓扑索引
     * </pre>
     *
     * <code>int64 entryIndex = 3;</code>
     *
     * @return The entryIndex.
     */
    @java.lang.Override
    public long getEntryIndex() {
        return entryIndex_;
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

    public static com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
        return org.bupt.fedraft.rpc.manager.message.ManagerMessage.internal_static_fedraft_ManagerVoteRequest_descriptor;
    }

    public static org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    public static org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public static org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  public static com.google.protobuf.Parser<ManagerVoteRequest> parser() {
      return PARSER;
  }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
            UnusedPrivateParameter unused) {
        return new ManagerVoteRequest();
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
        return org.bupt.fedraft.rpc.manager.message.ManagerMessage.internal_static_fedraft_ManagerVoteRequest_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest.class, org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest.Builder.class);
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
        if (term_ != 0) {
            output.writeInt32(1, term_);
        }
        if (candidateId_ != 0L) {
            output.writeInt64(2, candidateId_);
        }
        if (entryIndex_ != 0L) {
            output.writeInt64(3, entryIndex_);
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
      if (candidateId_ != 0L) {
          size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, candidateId_);
      }
      if (entryIndex_ != 0L) {
          size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, entryIndex_);
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
      if (!(obj instanceof org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest)) {
          return super.equals(obj);
      }
      org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest other = (org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest) obj;

      if (getTerm()
              != other.getTerm()) return false;
      if (getCandidateId()
              != other.getCandidateId()) return false;
      if (getEntryIndex()
              != other.getEntryIndex()) return false;
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
      hash = (37 * hash) + CANDIDATEID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
              getCandidateId());
      hash = (37 * hash) + ENTRYINDEX_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
              getEntryIndex());
      hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
      return hash;
  }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }

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
  public com.google.protobuf.Parser<ManagerVoteRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
  }

    /**
     * Protobuf type {@code fedraft.ManagerVoteRequest}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:fedraft.ManagerVoteRequest)
            org.bupt.fedraft.rpc.manager.message.ManagerVoteRequestOrBuilder {
        private int term_;
        private long candidateId_;
        private long entryIndex_;

        // Construct using org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest.newBuilder()
        private Builder() {

        }

        @java.lang.Override
        public Builder clear() {
            super.clear();
            term_ = 0;

            candidateId_ = 0L;

            entryIndex_ = 0L;

            return this;
        }

        private Builder(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            super(parent);

        }

        @java.lang.Override
        public org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest getDefaultInstanceForType() {
            return org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest.getDefaultInstance();
        }

        @java.lang.Override
        public org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest build() {
      org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest buildPartial() {
      org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest result = new org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest(this);
      result.term_ = term_;
        result.candidateId_ = candidateId_;
        result.entryIndex_ = entryIndex_;
        onBuilt();
        return result;
    }

        @java.lang.Override
        public Builder clone() {
            return super.clone();
        }

        public static com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return org.bupt.fedraft.rpc.manager.message.ManagerMessage.internal_static_fedraft_ManagerVoteRequest_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return org.bupt.fedraft.rpc.manager.message.ManagerMessage.internal_static_fedraft_ManagerVoteRequest_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest.class, org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest.Builder.class);
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
            return org.bupt.fedraft.rpc.manager.message.ManagerMessage.internal_static_fedraft_ManagerVoteRequest_descriptor;
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

        public Builder mergeFrom(org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest other) {
            if (other == org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest.getDefaultInstance()) return this;
            if (other.getTerm() != 0) {
                setTerm(other.getTerm());
            }
            if (other.getCandidateId() != 0L) {
                setCandidateId(other.getCandidateId());
            }
            if (other.getEntryIndex() != 0L) {
                setEntryIndex(other.getEntryIndex());
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

        /**
         * <code>int32 term = 1;</code>
         *
         * @return The term.
         */
        @java.lang.Override
        public int getTerm() {
            return term_;
        }

        @java.lang.Override
        public Builder mergeFrom(com.google.protobuf.Message other) {
            if (other instanceof org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest) {
                return mergeFrom((org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
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
              candidateId_ = input.readInt64();

              break;
            } // case 16
            case 24: {
              entryIndex_ = input.readInt64();

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

        /**
         * <code>int32 term = 1;</code>
         *
         * @param value The term to set.
         * @return This builder for chaining.
         */
        public Builder setTerm(int value) {

            term_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>int64 candidateId = 2;</code>
         *
         * @return The candidateId.
         */
        @java.lang.Override
        public long getCandidateId() {
            return candidateId_;
        }

        /**
         * <code>int32 term = 1;</code>
         *
         * @return This builder for chaining.
         */
        public Builder clearTerm() {

      term_ = 0;
      onChanged();
      return this;
    }

    /**
     * <code>int64 candidateId = 2;</code>
     * @param value The candidateId to set.
     * @return This builder for chaining.
     */
    public Builder setCandidateId(long value) {

      candidateId_ = value;
      onChanged();
      return this;
    }

    /**
     * <code>int64 candidateId = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearCandidateId() {

      candidateId_ = 0L;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 拓扑索引
     * </pre>
     *
     * <code>int64 entryIndex = 3;</code>
     * @return The entryIndex.
     */
    @java.lang.Override
    public long getEntryIndex() {
      return entryIndex_;
    }

    /**
     * <pre>
     * 拓扑索引
     * </pre>
     *
     * <code>int64 entryIndex = 3;</code>
     * @param value The entryIndex to set.
     * @return This builder for chaining.
     */
    public Builder setEntryIndex(long value) {

      entryIndex_ = value;
        onChanged();
        return this;
    }

        /**
         * <pre>
         * 拓扑索引
         * </pre>
         *
         * <code>int64 entryIndex = 3;</code>
         *
         * @return This builder for chaining.
         */
        public Builder clearEntryIndex() {

            entryIndex_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:fedraft.ManagerVoteRequest)
  }

}

