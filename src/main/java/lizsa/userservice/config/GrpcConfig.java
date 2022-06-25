package lizsa.userservice.config;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.List;

@Slf4j
@Configuration
public class GrpcConfig {

    private final Server server;

    public GrpcConfig(List<BindableService> services) {
        var builder = ServerBuilder.forPort(31004);
        services.forEach(builder::addService);
        log.info("grpc started on port {}", 31004);
        this.server = builder.build();
    }

    @PostConstruct
    public void init() throws IOException {
        server.start();
    }

    @PreDestroy
    public void stop() {
        server.shutdown();
    }
}
