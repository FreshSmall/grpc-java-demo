import io.grpc.examples.helloworld.GreeterGrpc;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;
import io.grpc.stub.StreamObserver;

public class GreeterGrpcImpl extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String name = request.getName();
        System.out.println("收到请求信息:"+name);
        HelloReply.Builder builder = HelloReply.newBuilder();
        builder.setMessage(String.format("hello 方法处理结果%s", name));
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
}
