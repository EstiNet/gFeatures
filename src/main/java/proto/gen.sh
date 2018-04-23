#!/bin/bash
protoc --plugin=protoc-gen-grpc-java=/home/devin/Downloads/java-grpc   --grpc-java_out="java" --proto_path="proto" "cliotesky.proto" # generate grpc service file
protoc -I proto proto/cliotesky.proto --java_out=java # generate protobuf
# Change the binary and git from here: http://search.maven.org/#search%7Cga%7C1%7Cg%3A"io.grpc"%20a%3A"protoc-gen-grpc-java"