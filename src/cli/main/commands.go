package main

import (
	_ "log"
	"context"
	pb "../../protocol"
	"google.golang.org/grpc/connectivity"
	"time"
)

func CommandHelp(input string) {
	println("-----Help-----")
	println("-h               | Get the help interface for flags.")
	println("version          | Get the version of this instance.")
	println("status           | Get the status of the instance")
	println("instancestop     | Stop this instance of EstiConsole.")
	println("list             | List all of the client servers.")
	println("attach [process] | Switch view to another process.")
	println("stop [process]   | Stop the process using the default stop command.")
	println("start [process]  | Start the process.")
	println("kill [process]   | Forcibly kill the process.")
}

func CommandVersion(input string) {
	startCon()
	reply, err := client.Version(context.Background(), &pb.String{Str: "test reply"})
	checkError(err)
	println("Version: ", reply.Str)
}

func CommandList(input string) {
	startCon()
	reply, err := client.List(context.Background(), &pb.String{Str: ""})
	checkError(err)
	println(reply.Str)
}

func CommandStop(input string) {
	startCon()
	reply, err := client.Stop(context.Background(), &pb.String{Str: input})
	checkError(err)
	println(reply.Str)
}

func CommandInstanceStop(input string) {
	startCon()
	reply, err := client.InstanceStop(context.Background(), &pb.String{Str: ""})
	checkError(err)
	println(reply.Str)
}

func CommandStart(input string) {
	startCon()
	reply, err := client.Start(context.Background(), &pb.String{Str: input})
	checkError(err)
	println(reply.Str)
}

func CommandKill(input string) {
	startCon()
	reply, err := client.Kill(context.Background(), &pb.String{Str: input})
	checkError(err)
	println(reply.Str)
}

func CommandStatus(input string) {
	startCon()
	if conn.GetState() == connectivity.Ready {
		println("Connection successful!")
	}
}

var cpuInfo, ramInfo string

func CommandAttach(input string) { //TODO check if process (input) exists
	startCon()
	//go attachCUI()
	ping := pb.ServerQuery{MessageId:-2, GetRam:true, GetCpu:true, ProcessName:input}
	for {
		reply, err := client.Attach(context.Background(), &ping)
		checkError(err)
		if reply.messageId
		time.Sleep(1000) //TODO dynamic time switch for message urgency
	}
}
