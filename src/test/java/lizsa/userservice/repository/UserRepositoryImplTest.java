package lizsa.userservice.repository;

import lizsa.userservice.UserServiceApplicationTests;
import lizsa.userservice.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import javax.annotation.PostConstruct;


@Slf4j
class UserRepositoryImplTest extends UserServiceApplicationTests {

    @Autowired
    UserRepositoryImpl repository;

    @PostConstruct
    public void init() {
        log.info("UserRepositoryImplTest init, repository is = {}", repository);
    }

    @Test
    void getUserByName() {
        User liza = new User(1,"Liza");
        log.info("user from db = {}", repository.getUserByName("Liza"));
        log.info("user from test = {}", liza);
        Assertions.assertEquals(liza, repository.getUserByName("Liza"));
    }
}