package lizsa.userservice.repository;

import lizsa.userservice.model.User;

public interface UserRepository {

     User getUserByName(String name);
}
