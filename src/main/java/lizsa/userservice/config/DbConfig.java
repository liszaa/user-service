package lizsa.userservice.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Slf4j
//@Configuration
public class DbConfig {


//    @Bean
//    public DataSource dataSource() {
//        log.info("init dataSource");
//        DataSource dbSource =  new JdbcDataSource();
//                .setType(EmbeddedDatabaseType.H2)
//                .addDefaultScripts().build();
//    }
//
//    @Bean
//    public JdbcTemplate jdbcTemplate(DataSource source) {
//        JdbcTemplate template = new JdbcTemplate(source);
//        log.info("JdbcTemplate is: {}", template);
//        return template;
//    }
}
