package training;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class Application {

    private JdbcTemplate jdbcTemplate;

    @Value("${database.url}")
    private String URL;

    @Value("${database.username}")
    private String USERNAME;

    @Value("${database.password}")
    private String PASSWORD;

    @Bean
    public JdbcTemplate theTemplate() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
        ds.setUrl(URL);
        ds.setUsername(USERNAME);
        ds.setPassword(PASSWORD);
        return new JdbcTemplate(ds);
    }

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
