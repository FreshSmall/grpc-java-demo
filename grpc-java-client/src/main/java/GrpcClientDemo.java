import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.helloworld.GreeterGrpc;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;

public class GrpcClientDemo {

    public static void main(String[] args) {
        GrpcClientDemo demo = new GrpcClientDemo();
        demo.remoteCall("test");
    }

    private void remoteCall(String name) {
        HelloRequest.Builder builder = HelloRequest.newBuilder();
        builder.setName(name);
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext(true).build();
        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);
        HelloReply helloReply = stub.sayHello(builder.build());
        System.out.println(helloReply.getMessage());
    }
}
