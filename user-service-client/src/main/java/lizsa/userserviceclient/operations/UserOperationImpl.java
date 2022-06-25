package lizsa.userserviceclient.operations;

import com.google.protobuf.StringValue;
import io.grpc.ManagedChannel;
import lizsa.userservice.model.User;
import lizsa.userservice.proto.UserServiceGrpc;

public class UserOperationImpl implements UserOperation {

    private final UserServiceGrpc.UserServiceBlockingStub userGrpc;

    public UserOperationImpl(ManagedChannel channel) {
        this.userGrpc = UserServiceGrpc.newBlockingStub(channel);
    }

    @Override
    public User getUser(String name) {
        var grpcUser =  userGrpc.getUser(StringValue.newBuilder()
                .setValue(name)
                .build());
        return User.fromGrpc(grpcUser);
    }
}
