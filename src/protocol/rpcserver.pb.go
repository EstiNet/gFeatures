// Code generated by protoc-gen-go. DO NOT EDIT.
// source: rpcserver.proto

/*
Package rpcserver is a generated protocol buffer package.

It is generated from these files:
	rpcserver.proto

It has these top-level messages:
	String
	ServerQuery
	ServerReply
*/
package rpcserver

import proto "github.com/golang/protobuf/proto"
import fmt "fmt"
import math "math"

import (
	context "golang.org/x/net/context"
	grpc "google.golang.org/grpc"
)

// Reference imports to suppress errors if they are not otherwise used.
var _ = proto.Marshal
var _ = fmt.Errorf
var _ = math.Inf

// This is a compile-time assertion to ensure that this generated file
// is compatible with the proto package it is being compiled against.
// A compilation error at this line likely means your copy of the
// proto package needs to be updated.
const _ = proto.ProtoPackageIsVersion2 // please upgrade the proto package

type String struct {
	Str string `protobuf:"bytes,1,opt,name=str" json:"str,omitempty"`
}

func (m *String) Reset()                    { *m = String{} }
func (m *String) String() string            { return proto.CompactTextString(m) }
func (*String) ProtoMessage()               {}
func (*String) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{0} }

func (m *String) GetStr() string {
	if m != nil {
		return m.Str
	}
	return ""
}

type ServerQuery struct {
	MessageId   int64  `protobuf:"varint,1,opt,name=message_id,json=messageId" json:"message_id,omitempty"`
	GetRam      bool   `protobuf:"varint,2,opt,name=get_ram,json=getRam" json:"get_ram,omitempty"`
	GetCpu      bool   `protobuf:"varint,3,opt,name=get_cpu,json=getCpu" json:"get_cpu,omitempty"`
	Command     string `protobuf:"bytes,4,opt,name=command" json:"command,omitempty"`
	ProcessName string `protobuf:"bytes,5,opt,name=process_name,json=processName" json:"process_name,omitempty"`
}

func (m *ServerQuery) Reset()                    { *m = ServerQuery{} }
func (m *ServerQuery) String() string            { return proto.CompactTextString(m) }
func (*ServerQuery) ProtoMessage()               {}
func (*ServerQuery) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{1} }

func (m *ServerQuery) GetMessageId() int64 {
	if m != nil {
		return m.MessageId
	}
	return 0
}

func (m *ServerQuery) GetGetRam() bool {
	if m != nil {
		return m.GetRam
	}
	return false
}

func (m *ServerQuery) GetGetCpu() bool {
	if m != nil {
		return m.GetCpu
	}
	return false
}

func (m *ServerQuery) GetCommand() string {
	if m != nil {
		return m.Command
	}
	return ""
}

func (m *ServerQuery) GetProcessName() string {
	if m != nil {
		return m.ProcessName
	}
	return ""
}

type ServerReply struct {
	Messages  []string `protobuf:"bytes,1,rep,name=messages" json:"messages,omitempty"`
	MessageId uint64   `protobuf:"varint,2,opt,name=message_id,json=messageId" json:"message_id,omitempty"`
	RamUsage  string   `protobuf:"bytes,3,opt,name=ram_usage,json=ramUsage" json:"ram_usage,omitempty"`
	CpuUsage  string   `protobuf:"bytes,4,opt,name=cpu_usage,json=cpuUsage" json:"cpu_usage,omitempty"`
}

func (m *ServerReply) Reset()                    { *m = ServerReply{} }
func (m *ServerReply) String() string            { return proto.CompactTextString(m) }
func (*ServerReply) ProtoMessage()               {}
func (*ServerReply) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{2} }

func (m *ServerReply) GetMessages() []string {
	if m != nil {
		return m.Messages
	}
	return nil
}

func (m *ServerReply) GetMessageId() uint64 {
	if m != nil {
		return m.MessageId
	}
	return 0
}

func (m *ServerReply) GetRamUsage() string {
	if m != nil {
		return m.RamUsage
	}
	return ""
}

func (m *ServerReply) GetCpuUsage() string {
	if m != nil {
		return m.CpuUsage
	}
	return ""
}

func init() {
	proto.RegisterType((*String)(nil), "String")
	proto.RegisterType((*ServerQuery)(nil), "ServerQuery")
	proto.RegisterType((*ServerReply)(nil), "ServerReply")
}

// Reference imports to suppress errors if they are not otherwise used.
var _ context.Context
var _ grpc.ClientConn

// This is a compile-time assertion to ensure that this generated file
// is compatible with the grpc package it is being compiled against.
const _ = grpc.SupportPackageIsVersion4

// Client API for RPCServer service

type RPCServerClient interface {
	Version(ctx context.Context, in *String, opts ...grpc.CallOption) (*String, error)
	List(ctx context.Context, in *String, opts ...grpc.CallOption) (*String, error)
	Stop(ctx context.Context, in *String, opts ...grpc.CallOption) (*String, error)
	Start(ctx context.Context, in *String, opts ...grpc.CallOption) (*String, error)
	Kill(ctx context.Context, in *String, opts ...grpc.CallOption) (*String, error)
	InstanceStop(ctx context.Context, in *String, opts ...grpc.CallOption) (*String, error)
	Attach(ctx context.Context, opts ...grpc.CallOption) (RPCServer_AttachClient, error)
}

type rPCServerClient struct {
	cc *grpc.ClientConn
}

func NewRPCServerClient(cc *grpc.ClientConn) RPCServerClient {
	return &rPCServerClient{cc}
}

func (c *rPCServerClient) Version(ctx context.Context, in *String, opts ...grpc.CallOption) (*String, error) {
	out := new(String)
	err := grpc.Invoke(ctx, "/RPCServer/Version", in, out, c.cc, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *rPCServerClient) List(ctx context.Context, in *String, opts ...grpc.CallOption) (*String, error) {
	out := new(String)
	err := grpc.Invoke(ctx, "/RPCServer/List", in, out, c.cc, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *rPCServerClient) Stop(ctx context.Context, in *String, opts ...grpc.CallOption) (*String, error) {
	out := new(String)
	err := grpc.Invoke(ctx, "/RPCServer/Stop", in, out, c.cc, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *rPCServerClient) Start(ctx context.Context, in *String, opts ...grpc.CallOption) (*String, error) {
	out := new(String)
	err := grpc.Invoke(ctx, "/RPCServer/Start", in, out, c.cc, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *rPCServerClient) Kill(ctx context.Context, in *String, opts ...grpc.CallOption) (*String, error) {
	out := new(String)
	err := grpc.Invoke(ctx, "/RPCServer/Kill", in, out, c.cc, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *rPCServerClient) InstanceStop(ctx context.Context, in *String, opts ...grpc.CallOption) (*String, error) {
	out := new(String)
	err := grpc.Invoke(ctx, "/RPCServer/InstanceStop", in, out, c.cc, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *rPCServerClient) Attach(ctx context.Context, opts ...grpc.CallOption) (RPCServer_AttachClient, error) {
	stream, err := grpc.NewClientStream(ctx, &_RPCServer_serviceDesc.Streams[0], c.cc, "/RPCServer/Attach", opts...)
	if err != nil {
		return nil, err
	}
	x := &rPCServerAttachClient{stream}
	return x, nil
}

type RPCServer_AttachClient interface {
	Send(*ServerQuery) error
	Recv() (*ServerReply, error)
	grpc.ClientStream
}

type rPCServerAttachClient struct {
	grpc.ClientStream
}

func (x *rPCServerAttachClient) Send(m *ServerQuery) error {
	return x.ClientStream.SendMsg(m)
}

func (x *rPCServerAttachClient) Recv() (*ServerReply, error) {
	m := new(ServerReply)
	if err := x.ClientStream.RecvMsg(m); err != nil {
		return nil, err
	}
	return m, nil
}

// Server API for RPCServer service

type RPCServerServer interface {
	Version(context.Context, *String) (*String, error)
	List(context.Context, *String) (*String, error)
	Stop(context.Context, *String) (*String, error)
	Start(context.Context, *String) (*String, error)
	Kill(context.Context, *String) (*String, error)
	InstanceStop(context.Context, *String) (*String, error)
	Attach(RPCServer_AttachServer) error
}

func RegisterRPCServerServer(s *grpc.Server, srv RPCServerServer) {
	s.RegisterService(&_RPCServer_serviceDesc, srv)
}

func _RPCServer_Version_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(String)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(RPCServerServer).Version(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/RPCServer/Version",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(RPCServerServer).Version(ctx, req.(*String))
	}
	return interceptor(ctx, in, info, handler)
}

func _RPCServer_List_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(String)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(RPCServerServer).List(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/RPCServer/List",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(RPCServerServer).List(ctx, req.(*String))
	}
	return interceptor(ctx, in, info, handler)
}

func _RPCServer_Stop_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(String)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(RPCServerServer).Stop(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/RPCServer/Stop",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(RPCServerServer).Stop(ctx, req.(*String))
	}
	return interceptor(ctx, in, info, handler)
}

func _RPCServer_Start_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(String)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(RPCServerServer).Start(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/RPCServer/Start",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(RPCServerServer).Start(ctx, req.(*String))
	}
	return interceptor(ctx, in, info, handler)
}

func _RPCServer_Kill_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(String)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(RPCServerServer).Kill(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/RPCServer/Kill",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(RPCServerServer).Kill(ctx, req.(*String))
	}
	return interceptor(ctx, in, info, handler)
}

func _RPCServer_InstanceStop_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(String)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(RPCServerServer).InstanceStop(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/RPCServer/InstanceStop",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(RPCServerServer).InstanceStop(ctx, req.(*String))
	}
	return interceptor(ctx, in, info, handler)
}

func _RPCServer_Attach_Handler(srv interface{}, stream grpc.ServerStream) error {
	return srv.(RPCServerServer).Attach(&rPCServerAttachServer{stream})
}

type RPCServer_AttachServer interface {
	Send(*ServerReply) error
	Recv() (*ServerQuery, error)
	grpc.ServerStream
}

type rPCServerAttachServer struct {
	grpc.ServerStream
}

func (x *rPCServerAttachServer) Send(m *ServerReply) error {
	return x.ServerStream.SendMsg(m)
}

func (x *rPCServerAttachServer) Recv() (*ServerQuery, error) {
	m := new(ServerQuery)
	if err := x.ServerStream.RecvMsg(m); err != nil {
		return nil, err
	}
	return m, nil
}

var _RPCServer_serviceDesc = grpc.ServiceDesc{
	ServiceName: "RPCServer",
	HandlerType: (*RPCServerServer)(nil),
	Methods: []grpc.MethodDesc{
		{
			MethodName: "Version",
			Handler:    _RPCServer_Version_Handler,
		},
		{
			MethodName: "List",
			Handler:    _RPCServer_List_Handler,
		},
		{
			MethodName: "Stop",
			Handler:    _RPCServer_Stop_Handler,
		},
		{
			MethodName: "Start",
			Handler:    _RPCServer_Start_Handler,
		},
		{
			MethodName: "Kill",
			Handler:    _RPCServer_Kill_Handler,
		},
		{
			MethodName: "InstanceStop",
			Handler:    _RPCServer_InstanceStop_Handler,
		},
	},
	Streams: []grpc.StreamDesc{
		{
			StreamName:    "Attach",
			Handler:       _RPCServer_Attach_Handler,
			ServerStreams: true,
			ClientStreams: true,
		},
	},
	Metadata: "rpcserver.proto",
}

func init() { proto.RegisterFile("rpcserver.proto", fileDescriptor0) }

var fileDescriptor0 = []byte{
	// 328 bytes of a gzipped FileDescriptorProto
	0x1f, 0x8b, 0x08, 0x00, 0x00, 0x00, 0x00, 0x00, 0x02, 0xff, 0x74, 0x92, 0xdd, 0x4a, 0xc3, 0x30,
	0x14, 0xc7, 0x89, 0xdd, 0xfa, 0x71, 0x36, 0x50, 0x72, 0x63, 0xec, 0x10, 0xea, 0xae, 0x7a, 0x35,
	0x44, 0x9f, 0x40, 0x76, 0x35, 0x14, 0xd1, 0x14, 0xbd, 0x2d, 0x31, 0x0b, 0xb5, 0xb0, 0xb4, 0x21,
	0x1f, 0xc2, 0x6e, 0x7d, 0x0d, 0x9f, 0xcd, 0x77, 0x91, 0x66, 0xed, 0x18, 0xb2, 0xdd, 0x9d, 0xff,
	0xf9, 0x9d, 0x36, 0x3f, 0x4e, 0x02, 0xe7, 0x5a, 0x71, 0x23, 0xf4, 0x97, 0xd0, 0x0b, 0xa5, 0x5b,
	0xdb, 0xce, 0x53, 0x08, 0x0b, 0xab, 0xeb, 0xa6, 0xc2, 0x17, 0x10, 0x18, 0xab, 0x09, 0xca, 0x50,
	0x9e, 0xd0, 0xae, 0x9c, 0xff, 0x20, 0x98, 0x14, 0x7e, 0xf8, 0xd5, 0x09, 0xbd, 0xc5, 0xd7, 0x00,
	0x52, 0x18, 0xc3, 0x2a, 0x51, 0xd6, 0x6b, 0x3f, 0x18, 0xd0, 0xa4, 0xef, 0xac, 0xd6, 0xf8, 0x12,
	0xa2, 0x4a, 0xd8, 0x52, 0x33, 0x49, 0xce, 0x32, 0x94, 0xc7, 0x34, 0xac, 0x84, 0xa5, 0x4c, 0x0e,
	0x80, 0x2b, 0x47, 0x82, 0x3d, 0x58, 0x2a, 0x87, 0x09, 0x44, 0xbc, 0x95, 0x92, 0x35, 0x6b, 0x32,
	0xf2, 0xc7, 0x0e, 0x11, 0xdf, 0xc0, 0x54, 0xe9, 0x96, 0x0b, 0x63, 0xca, 0x86, 0x49, 0x41, 0xc6,
	0x1e, 0x4f, 0xfa, 0xde, 0x33, 0x93, 0x62, 0xfe, 0xbd, 0xb7, 0xa3, 0x42, 0x6d, 0xb6, 0x38, 0x85,
	0xb8, 0x77, 0x31, 0x04, 0x65, 0x41, 0x9e, 0xd0, 0x7d, 0xfe, 0x67, 0xde, 0xd9, 0x8d, 0x0e, 0xcd,
	0x67, 0x90, 0x68, 0x26, 0x4b, 0xd7, 0x45, 0xaf, 0x98, 0xd0, 0x58, 0x33, 0xf9, 0xd6, 0xe5, 0x0e,
	0x72, 0xe5, 0x7a, 0xb8, 0xd3, 0x8c, 0xb9, 0x72, 0x1e, 0xde, 0xfd, 0x22, 0x48, 0xe8, 0xcb, 0x72,
	0xe7, 0x81, 0x67, 0x10, 0xbd, 0x0b, 0x6d, 0xea, 0xb6, 0xc1, 0xd1, 0x62, 0xb7, 0xd6, 0x74, 0x28,
	0x30, 0x81, 0xd1, 0x53, 0x6d, 0xec, 0x71, 0x52, 0xd8, 0x56, 0x1d, 0x21, 0x57, 0x30, 0x2e, 0x2c,
	0xd3, 0x27, 0x3e, 0x7a, 0xac, 0x37, 0x9b, 0x23, 0x24, 0x83, 0xe9, 0xaa, 0x31, 0x96, 0x35, 0x5c,
	0x9c, 0xf8, 0x6d, 0x0e, 0xe1, 0x83, 0xb5, 0x8c, 0x7f, 0xe2, 0xe9, 0xe2, 0xe0, 0x82, 0xd3, 0x21,
	0xf9, 0x85, 0xe6, 0xe8, 0x16, 0x7d, 0x84, 0xfe, 0x95, 0xdc, 0xff, 0x05, 0x00, 0x00, 0xff, 0xff,
	0x42, 0xcf, 0x55, 0x6f, 0x38, 0x02, 0x00, 0x00,
}
