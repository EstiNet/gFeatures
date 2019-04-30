package net.estinet.gFeatures.ClioteSky;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/*
 * gFeatures
 * https://github.com/EstiNet/gFeatures
 *
 *    Copyright 2019 EstiNet
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

/**
 */
@javax.annotation.Generated(
        value = "by gRPC proto compiler (version 1.11.0)",
        comments = "Source: cliotesky.proto")
public final class ClioteSkyServiceGrpc {

    private ClioteSkyServiceGrpc() {}

    public static final String SERVICE_NAME = "ClioteSkyService";

    // Static method descriptors that strictly reflect the proto.
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    @java.lang.Deprecated // Use {@link #getRequestMethod()} instead.
    public static final io.grpc.MethodDescriptor<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Token,
            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.ClioteMessage> METHOD_REQUEST = getRequestMethodHelper();

    private static volatile io.grpc.MethodDescriptor<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Token,
            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.ClioteMessage> getRequestMethod;

    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static io.grpc.MethodDescriptor<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Token,
            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.ClioteMessage> getRequestMethod() {
        return getRequestMethodHelper();
    }

    private static io.grpc.MethodDescriptor<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Token,
            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.ClioteMessage> getRequestMethodHelper() {
        io.grpc.MethodDescriptor<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Token, net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.ClioteMessage> getRequestMethod;
        if ((getRequestMethod = ClioteSkyServiceGrpc.getRequestMethod) == null) {
            synchronized (ClioteSkyServiceGrpc.class) {
                if ((getRequestMethod = ClioteSkyServiceGrpc.getRequestMethod) == null) {
                    ClioteSkyServiceGrpc.getRequestMethod = getRequestMethod =
                            io.grpc.MethodDescriptor.<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Token, net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.ClioteMessage>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                                    .setFullMethodName(generateFullMethodName(
                                            "ClioteSkyService", "Request"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Token.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.ClioteMessage.getDefaultInstance()))
                                    .setSchemaDescriptor(new ClioteSkyServiceMethodDescriptorSupplier("Request"))
                                    .build();
                }
            }
        }
        return getRequestMethod;
    }
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    @java.lang.Deprecated // Use {@link #getSendMethod()} instead.
    public static final io.grpc.MethodDescriptor<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.ClioteSend,
            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Empty> METHOD_SEND = getSendMethodHelper();

    private static volatile io.grpc.MethodDescriptor<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.ClioteSend,
            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Empty> getSendMethod;

    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static io.grpc.MethodDescriptor<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.ClioteSend,
            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Empty> getSendMethod() {
        return getSendMethodHelper();
    }

    private static io.grpc.MethodDescriptor<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.ClioteSend,
            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Empty> getSendMethodHelper() {
        io.grpc.MethodDescriptor<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.ClioteSend, net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Empty> getSendMethod;
        if ((getSendMethod = ClioteSkyServiceGrpc.getSendMethod) == null) {
            synchronized (ClioteSkyServiceGrpc.class) {
                if ((getSendMethod = ClioteSkyServiceGrpc.getSendMethod) == null) {
                    ClioteSkyServiceGrpc.getSendMethod = getSendMethod =
                            io.grpc.MethodDescriptor.<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.ClioteSend, net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Empty>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "ClioteSkyService", "Send"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.ClioteSend.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Empty.getDefaultInstance()))
                                    .setSchemaDescriptor(new ClioteSkyServiceMethodDescriptorSupplier("Send"))
                                    .build();
                }
            }
        }
        return getSendMethod;
    }
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    @java.lang.Deprecated // Use {@link #getAuthMethod()} instead.
    public static final io.grpc.MethodDescriptor<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.AuthRequest,
            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Token> METHOD_AUTH = getAuthMethodHelper();

    private static volatile io.grpc.MethodDescriptor<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.AuthRequest,
            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Token> getAuthMethod;

    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static io.grpc.MethodDescriptor<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.AuthRequest,
            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Token> getAuthMethod() {
        return getAuthMethodHelper();
    }

    private static io.grpc.MethodDescriptor<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.AuthRequest,
            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Token> getAuthMethodHelper() {
        io.grpc.MethodDescriptor<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.AuthRequest, net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Token> getAuthMethod;
        if ((getAuthMethod = ClioteSkyServiceGrpc.getAuthMethod) == null) {
            synchronized (ClioteSkyServiceGrpc.class) {
                if ((getAuthMethod = ClioteSkyServiceGrpc.getAuthMethod) == null) {
                    ClioteSkyServiceGrpc.getAuthMethod = getAuthMethod =
                            io.grpc.MethodDescriptor.<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.AuthRequest, net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Token>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "ClioteSkyService", "Auth"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.AuthRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Token.getDefaultInstance()))
                                    .setSchemaDescriptor(new ClioteSkyServiceMethodDescriptorSupplier("Auth"))
                                    .build();
                }
            }
        }
        return getAuthMethod;
    }
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    @java.lang.Deprecated // Use {@link #getCheckNameTakenMethod()} instead.
    public static final io.grpc.MethodDescriptor<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.String,
            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Boolean> METHOD_CHECK_NAME_TAKEN = getCheckNameTakenMethodHelper();

    private static volatile io.grpc.MethodDescriptor<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.String,
            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Boolean> getCheckNameTakenMethod;

    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static io.grpc.MethodDescriptor<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.String,
            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Boolean> getCheckNameTakenMethod() {
        return getCheckNameTakenMethodHelper();
    }

    private static io.grpc.MethodDescriptor<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.String,
            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Boolean> getCheckNameTakenMethodHelper() {
        io.grpc.MethodDescriptor<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.String, net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Boolean> getCheckNameTakenMethod;
        if ((getCheckNameTakenMethod = ClioteSkyServiceGrpc.getCheckNameTakenMethod) == null) {
            synchronized (ClioteSkyServiceGrpc.class) {
                if ((getCheckNameTakenMethod = ClioteSkyServiceGrpc.getCheckNameTakenMethod) == null) {
                    ClioteSkyServiceGrpc.getCheckNameTakenMethod = getCheckNameTakenMethod =
                            io.grpc.MethodDescriptor.<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.String, net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Boolean>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "ClioteSkyService", "CheckNameTaken"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.String.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Boolean.getDefaultInstance()))
                                    .setSchemaDescriptor(new ClioteSkyServiceMethodDescriptorSupplier("CheckNameTaken"))
                                    .build();
                }
            }
        }
        return getCheckNameTakenMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static ClioteSkyServiceStub newStub(io.grpc.Channel channel) {
        return new ClioteSkyServiceStub(channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static ClioteSkyServiceBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        return new ClioteSkyServiceBlockingStub(channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static ClioteSkyServiceFutureStub newFutureStub(
            io.grpc.Channel channel) {
        return new ClioteSkyServiceFutureStub(channel);
    }

    /**
     */
    public static abstract class ClioteSkyServiceImplBase implements io.grpc.BindableService {

        /**
         */
        public void request(net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Token request,
                            io.grpc.stub.StreamObserver<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.ClioteMessage> responseObserver) {
            asyncUnimplementedUnaryCall(getRequestMethodHelper(), responseObserver);
        }

        /**
         */
        public void send(net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.ClioteSend request,
                         io.grpc.stub.StreamObserver<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Empty> responseObserver) {
            asyncUnimplementedUnaryCall(getSendMethodHelper(), responseObserver);
        }

        /**
         */
        public void auth(net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.AuthRequest request,
                         io.grpc.stub.StreamObserver<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Token> responseObserver) {
            asyncUnimplementedUnaryCall(getAuthMethodHelper(), responseObserver);
        }

        /**
         * <pre>
         *check if name is taken
         * </pre>
         */
        public void checkNameTaken(net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.String request,
                                   io.grpc.stub.StreamObserver<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Boolean> responseObserver) {
            asyncUnimplementedUnaryCall(getCheckNameTakenMethodHelper(), responseObserver);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            getRequestMethodHelper(),
                            asyncServerStreamingCall(
                                    new MethodHandlers<
                                            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Token,
                                            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.ClioteMessage>(
                                            this, METHODID_REQUEST)))
                    .addMethod(
                            getSendMethodHelper(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.ClioteSend,
                                            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Empty>(
                                            this, METHODID_SEND)))
                    .addMethod(
                            getAuthMethodHelper(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.AuthRequest,
                                            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Token>(
                                            this, METHODID_AUTH)))
                    .addMethod(
                            getCheckNameTakenMethodHelper(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.String,
                                            net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Boolean>(
                                            this, METHODID_CHECK_NAME_TAKEN)))
                    .build();
        }
    }

    /**
     */
    public static final class ClioteSkyServiceStub extends io.grpc.stub.AbstractStub<ClioteSkyServiceStub> {
        private ClioteSkyServiceStub(io.grpc.Channel channel) {
            super(channel);
        }

        private ClioteSkyServiceStub(io.grpc.Channel channel,
                                     io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected ClioteSkyServiceStub build(io.grpc.Channel channel,
                                             io.grpc.CallOptions callOptions) {
            return new ClioteSkyServiceStub(channel, callOptions);
        }

        /**
         */
        public void request(net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Token request,
                            io.grpc.stub.StreamObserver<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.ClioteMessage> responseObserver) {
            asyncServerStreamingCall(
                    getChannel().newCall(getRequestMethodHelper(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void send(net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.ClioteSend request,
                         io.grpc.stub.StreamObserver<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Empty> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getSendMethodHelper(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void auth(net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.AuthRequest request,
                         io.grpc.stub.StreamObserver<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Token> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getAuthMethodHelper(), getCallOptions()), request, responseObserver);
        }

        /**
         * <pre>
         *check if name is taken
         * </pre>
         */
        public void checkNameTaken(net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.String request,
                                   io.grpc.stub.StreamObserver<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Boolean> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getCheckNameTakenMethodHelper(), getCallOptions()), request, responseObserver);
        }
    }

    /**
     */
    public static final class ClioteSkyServiceBlockingStub extends io.grpc.stub.AbstractStub<ClioteSkyServiceBlockingStub> {
        private ClioteSkyServiceBlockingStub(io.grpc.Channel channel) {
            super(channel);
        }

        private ClioteSkyServiceBlockingStub(io.grpc.Channel channel,
                                             io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected ClioteSkyServiceBlockingStub build(io.grpc.Channel channel,
                                                     io.grpc.CallOptions callOptions) {
            return new ClioteSkyServiceBlockingStub(channel, callOptions);
        }

        /**
         */
        public java.util.Iterator<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.ClioteMessage> request(
                net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Token request) {
            return blockingServerStreamingCall(
                    getChannel(), getRequestMethodHelper(), getCallOptions(), request);
        }

        /**
         */
        public net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Empty send(net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.ClioteSend request) {
            return blockingUnaryCall(
                    getChannel(), getSendMethodHelper(), getCallOptions(), request);
        }

        /**
         */
        public net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Token auth(net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.AuthRequest request) {
            return blockingUnaryCall(
                    getChannel(), getAuthMethodHelper(), getCallOptions(), request);
        }

        /**
         * <pre>
         *check if name is taken
         * </pre>
         */
        public net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Boolean checkNameTaken(net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.String request) {
            return blockingUnaryCall(
                    getChannel(), getCheckNameTakenMethodHelper(), getCallOptions(), request);
        }
    }

    /**
     */
    public static final class ClioteSkyServiceFutureStub extends io.grpc.stub.AbstractStub<ClioteSkyServiceFutureStub> {
        private ClioteSkyServiceFutureStub(io.grpc.Channel channel) {
            super(channel);
        }

        private ClioteSkyServiceFutureStub(io.grpc.Channel channel,
                                           io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected ClioteSkyServiceFutureStub build(io.grpc.Channel channel,
                                                   io.grpc.CallOptions callOptions) {
            return new ClioteSkyServiceFutureStub(channel, callOptions);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Empty> send(
                net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.ClioteSend request) {
            return futureUnaryCall(
                    getChannel().newCall(getSendMethodHelper(), getCallOptions()), request);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Token> auth(
                net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.AuthRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getAuthMethodHelper(), getCallOptions()), request);
        }

        /**
         * <pre>
         *check if name is taken
         * </pre>
         */
        public com.google.common.util.concurrent.ListenableFuture<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Boolean> checkNameTaken(
                net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.String request) {
            return futureUnaryCall(
                    getChannel().newCall(getCheckNameTakenMethodHelper(), getCallOptions()), request);
        }
    }

    private static final int METHODID_REQUEST = 0;
    private static final int METHODID_SEND = 1;
    private static final int METHODID_AUTH = 2;
    private static final int METHODID_CHECK_NAME_TAKEN = 3;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final ClioteSkyServiceImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(ClioteSkyServiceImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_REQUEST:
                    serviceImpl.request((net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Token) request,
                            (io.grpc.stub.StreamObserver<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.ClioteMessage>) responseObserver);
                    break;
                case METHODID_SEND:
                    serviceImpl.send((net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.ClioteSend) request,
                            (io.grpc.stub.StreamObserver<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Empty>) responseObserver);
                    break;
                case METHODID_AUTH:
                    serviceImpl.auth((net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.AuthRequest) request,
                            (io.grpc.stub.StreamObserver<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Token>) responseObserver);
                    break;
                case METHODID_CHECK_NAME_TAKEN:
                    serviceImpl.checkNameTaken((net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.String) request,
                            (io.grpc.stub.StreamObserver<net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.Boolean>) responseObserver);
                    break;
                default:
                    throw new AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(
                io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new AssertionError();
            }
        }
    }

    private static abstract class ClioteSkyServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        ClioteSkyServiceBaseDescriptorSupplier() {}

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("ClioteSkyService");
        }
    }

    private static final class ClioteSkyServiceFileDescriptorSupplier
            extends ClioteSkyServiceBaseDescriptorSupplier {
        ClioteSkyServiceFileDescriptorSupplier() {}
    }

    private static final class ClioteSkyServiceMethodDescriptorSupplier
            extends ClioteSkyServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final String methodName;

        ClioteSkyServiceMethodDescriptorSupplier(String methodName) {
            this.methodName = methodName;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(methodName);
        }
    }

    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (ClioteSkyServiceGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new ClioteSkyServiceFileDescriptorSupplier())
                            .addMethod(getRequestMethodHelper())
                            .addMethod(getSendMethodHelper())
                            .addMethod(getAuthMethodHelper())
                            .addMethod(getCheckNameTakenMethodHelper())
                            .build();
                }
            }
        }
        return result;
    }
}
