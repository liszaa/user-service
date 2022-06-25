package lizsa.userservice.model;

import lizsa.userservice.proto.GrpcUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
public class User {

    private long id;
    private String name;

    public static User fromGrpc(GrpcUser grpcUser) {
        return User.builder()
                .id(grpcUser.getId())
                .name(grpcUser.getName())
                .build();
    }

    public static GrpcUser toGrpc(User user) {
        return GrpcUser.newBuilder()
                .setId(user.getId())
                .setName(user.getName())
                .build();
    }
}
