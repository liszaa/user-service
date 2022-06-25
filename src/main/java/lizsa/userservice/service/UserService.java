package lizsa.userservice.service;

import com.google.protobuf.StringValue;
import io.grpc.stub.StreamObserver;
import lizsa.userservice.model.User;
import lizsa.userservice.proto.GrpcUser;
import lizsa.userservice.proto.UserServiceGrpc;
import lizsa.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserService extends UserServiceGrpc.UserServiceImplBase {

    UserRepository repository;

    @Override
    public void getUser(StringValue request, StreamObserver<GrpcUser> responseObserver) {
        User user = repository.getUserByName(request.getValue());
        GrpcUser gUser = GrpcUser.newBuilder()
                        .setId(user.getId())
                        .setName(user.getName())
                        .build();

        responseObserver.onNext(gUser);
        responseObserver.onCompleted();
    }
}
