// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vote_massage.proto

package org.bupt.cad.fedraft.rpc.message;

/**
 * Protobuf type {@code fedraft.TriggerElectionRequest}
 */
public final class TriggerElectionRequest extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:fedraft.TriggerElectionRequest)
        TriggerElectionRequestOrBuilder {
    public static final int TERM_FIELD_NUMBER = 1;
    public static final int LEADER_ID_FIELD_NUMBER = 2;
    public static final int LEADER_MODEL_INDEX_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0L;
    // @@protoc_insertion_point(class_scope:fedraft.TriggerElectionRequest)
    private static final org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest DEFAULT_INSTANCE;
    private static final com.google.protobuf.Parser<TriggerElectionRequest>
            PARSER = new com.google.protobuf.AbstractParser<TriggerElectionRequest>() {
        @java.lang.Override
        public TriggerElectionRequest parsePartialFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return new TriggerElectionRequest(input, extensionRegistry);
        }
    };

    static {
        DEFAULT_INSTANCE = new org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest();
    }

    private int term_;
    private long leaderId_;
    private int leaderModelIndex_;
    private byte memoizedIsInitialized = -1;

    // Use TriggerElectionRequest.newBuilder() to construct.
    private TriggerElectionRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private TriggerElectionRequest() {
    }

    private TriggerElectionRequest(
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

                        leaderId_ = input.readUInt64();
                        break;
                    }
                    case 40: {

                        leaderModelIndex_ = input.readUInt32();
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
        return org.bupt.cad.fedraft.rpc.message.VoteMassage.internal_static_fedraft_TriggerElectionRequest_descriptor;
    }

    public static org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    public static org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    public static org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<TriggerElectionRequest> parser() {
        return PARSER;
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
            UnusedPrivateParameter unused) {
        return new TriggerElectionRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
        return this.unknownFields;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
        return org.bupt.cad.fedraft.rpc.message.VoteMassage.internal_static_fedraft_TriggerElectionRequest_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest.class, org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest.Builder.class);
    }

    /**
     * <code>uint32 term = 1;</code>
     *
     * @return The term.
     */
    @java.lang.Override
    public int getTerm() {
        return term_;
    }

    /**
     * <code>uint64 leader_id = 2;</code>
     *
     * @return The leaderId.
     */
    @java.lang.Override
    public long getLeaderId() {
        return leaderId_;
    }

    /**
     * <code>uint32 leader_model_index = 5;</code>
     *
     * @return The leaderModelIndex.
     */
    @java.lang.Override
    public int getLeaderModelIndex() {
        return leaderModelIndex_;
    }

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
        if (leaderId_ != 0L) {
            output.writeUInt64(2, leaderId_);
        }
        if (leaderModelIndex_ != 0) {
            output.writeUInt32(5, leaderModelIndex_);
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
        if (leaderId_ != 0L) {
            size += com.google.protobuf.CodedOutputStream
                    .computeUInt64Size(2, leaderId_);
        }
        if (leaderModelIndex_ != 0) {
            size += com.google.protobuf.CodedOutputStream
                    .computeUInt32Size(5, leaderModelIndex_);
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
        if (!(obj instanceof org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest)) {
            return super.equals(obj);
        }
        org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest other = (org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest) obj;

        if (getTerm()
                != other.getTerm()) return false;
        if (getLeaderId()
                != other.getLeaderId()) return false;
        if (getLeaderModelIndex()
                != other.getLeaderModelIndex()) return false;
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
        hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                getLeaderId());
        hash = (37 * hash) + LEADER_MODEL_INDEX_FIELD_NUMBER;
        hash = (53 * hash) + getLeaderModelIndex();
        hash = (29 * hash) + unknownFields.hashCode();
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
    public com.google.protobuf.Parser<TriggerElectionRequest> getParserForType() {
        return PARSER;
    }

    @java.lang.Override
    public org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /**
     * Protobuf type {@code fedraft.TriggerElectionRequest}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:fedraft.TriggerElectionRequest)
            org.bupt.cad.fedraft.rpc.message.TriggerElectionRequestOrBuilder {
        private int term_;
        private long leaderId_;
        private int leaderModelIndex_;

        // Construct using org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest.newBuilder()
        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            super(parent);
            maybeForceBuilderInitialization();
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return org.bupt.cad.fedraft.rpc.message.VoteMassage.internal_static_fedraft_TriggerElectionRequest_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return org.bupt.cad.fedraft.rpc.message.VoteMassage.internal_static_fedraft_TriggerElectionRequest_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest.class, org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest.Builder.class);
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

            leaderId_ = 0L;

            leaderModelIndex_ = 0;

            return this;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
            return org.bupt.cad.fedraft.rpc.message.VoteMassage.internal_static_fedraft_TriggerElectionRequest_descriptor;
        }

        @java.lang.Override
        public org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest getDefaultInstanceForType() {
            return org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest.getDefaultInstance();
        }

        @java.lang.Override
        public org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest build() {
            org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        @java.lang.Override
        public org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest buildPartial() {
            org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest result = new org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest(this);
            result.term_ = term_;
            result.leaderId_ = leaderId_;
            result.leaderModelIndex_ = leaderModelIndex_;
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
            if (other instanceof org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest) {
                return mergeFrom((org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest other) {
            if (other == org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest.getDefaultInstance()) return this;
            if (other.getTerm() != 0) {
                setTerm(other.getTerm());
            }
            if (other.getLeaderId() != 0L) {
                setLeaderId(other.getLeaderId());
            }
            if (other.getLeaderModelIndex() != 0) {
                setLeaderModelIndex(other.getLeaderModelIndex());
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
            org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest parsedMessage = null;
            try {
                parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                parsedMessage = (org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } finally {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
            }
            return this;
        }

        /**
         * <code>uint32 term = 1;</code>
         *
         * @return The term.
         */
        @java.lang.Override
        public int getTerm() {
            return term_;
        }

        /**
         * <code>uint32 term = 1;</code>
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
         * <code>uint64 leader_id = 2;</code>
         *
         * @return The leaderId.
         */
        @java.lang.Override
        public long getLeaderId() {
            return leaderId_;
        }

        /**
         * <code>uint64 leader_id = 2;</code>
         *
         * @param value The leaderId to set.
         * @return This builder for chaining.
         */
        public Builder setLeaderId(long value) {

            leaderId_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>uint64 leader_id = 2;</code>
         *
         * @return This builder for chaining.
         */
        public Builder clearLeaderId() {

            leaderId_ = 0L;
            onChanged();
            return this;
        }

        /**
         * <code>uint32 leader_model_index = 5;</code>
         *
         * @return The leaderModelIndex.
         */
        @java.lang.Override
        public int getLeaderModelIndex() {
            return leaderModelIndex_;
        }

        /**
         * <code>uint32 leader_model_index = 5;</code>
         *
         * @param value The leaderModelIndex to set.
         * @return This builder for chaining.
         */
        public Builder setLeaderModelIndex(int value) {

            leaderModelIndex_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>uint32 leader_model_index = 5;</code>
         *
         * @return This builder for chaining.
         */
        public Builder clearLeaderModelIndex() {

            leaderModelIndex_ = 0;
            onChanged();
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


        // @@protoc_insertion_point(builder_scope:fedraft.TriggerElectionRequest)
    }

}

