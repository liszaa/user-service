package lizsa.userservice.repository;


import lizsa.userservice.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

@Slf4j
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    RowMapper<User> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> new User(resultSet.getLong("id"), resultSet.getString("name"));

    @PostConstruct
    public void init() {
        log.info("UserRepositoryImpl init jdbcTemplate is: " + jdbcTemplate);
    }

    @Override
    public User getUserByName(String name) {
        return jdbcTemplate.queryForObject("select * from users where name=?", new Object[]{name}, ROW_MAPPER);
    }
}
