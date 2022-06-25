package lizsa.userserviceclient;

import io.grpc.ManagedChannelBuilder;
import lizsa.userserviceclient.operations.UserOperation;

public class UserServiceClientImpl implements UserServiceClient {

    UserOperation userOperation;

    public UserServiceClientImpl(String host, int port) {
        var grpcChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

    }

    @Override
    public UserOperation userOperation() {
        return userOperation;
    }
}
