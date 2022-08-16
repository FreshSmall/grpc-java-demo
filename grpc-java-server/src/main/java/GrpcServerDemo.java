import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServerDemo {

    private Server server;

    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcServerDemo demo = new GrpcServerDemo();
        // 启动server
        demo.start();
        // block 一直到退出程序
        demo.blockUntilShutdown();
    }

    private void start() throws IOException {
        server = ServerBuilder.forPort(50051)
                .addService(new GreeterGrpcImpl())
                .build().start();
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server!=null) {
            server.awaitTermination();
        }
    }
}
