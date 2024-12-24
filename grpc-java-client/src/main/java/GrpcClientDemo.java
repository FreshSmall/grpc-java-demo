import config.ClientMetaInterceptor;
import io.grpc.ClientInterceptor;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.helloworld.GreeterGrpc;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;

public class GrpcClientDemo {

    public static void main(String[] args) {
        GrpcClientDemo demo = new GrpcClientDemo();
        String name = "test";
        demo.remoteCall(name);
    }

    private void remoteCall(String name) {

        ClientInterceptor interceptor = new ClientMetaInterceptor();
        HelloRequest.Builder builder = HelloRequest.newBuilder();
        builder.setName(name);
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
        for (int i = 0; i < 2; i++) {
            GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);
            HelloReply helloReply = stub.sayHello(builder.build());
            System.out.println(helloReply.getMessage());
        }
    }
}
