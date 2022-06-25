package lizsa.userserviceclient.config;

import lizsa.userserviceclient.UserServiceClient;
import lizsa.userserviceclient.UserServiceClientImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UserServiceClient bonusServiceClient(
            @Value("${app.services.bonus.url:localhost}") String host,
            @Value("${app.services.bonus.grpc.port:31004}") int port
    ) {
        return new UserServiceClientImpl(host, port);
    }
}
