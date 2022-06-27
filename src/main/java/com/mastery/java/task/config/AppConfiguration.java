package com.mastery.java.task.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.mastery.java.task")
public class AppConfiguration {

    //@Value("${spring.datasource.url}")
    private String dbUrl = "jdbc:postgresql://localhost:5432/employeeDB";

    //@Value("${spring.datasource.username}")
    private String dbUsername = "postgres";

    //@Value("${spring.datasource.password}")
    private String dbPassword = "password";

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(dbUrl, dbUsername, dbPassword);
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        DataSource dataSource = new DriverManagerDataSource(dbUrl, dbUsername, dbPassword);
        return new JdbcTemplate(dataSource);
    }
}
