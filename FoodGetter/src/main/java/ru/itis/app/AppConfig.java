package ru.itis.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
@ComponentScan("ru.itis")
@EnableWebMvc
@PropertySource("classpath:database.properties")
public class AppConfig extends WebMvcConfigurerAdapter {
    @Autowired
    Environment environment;

    @Bean
    public DriverManagerDataSource driverManagerDataSourse() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setPassword(environment.getProperty("db.password"));
        dataSource.setUsername(environment.getProperty("db.username"));
        dataSource.setUrl(environment.getProperty("db.url"));
        dataSource.setDriverClassName(environment.getProperty("db.driverClassName"));
        return dataSource;
    }
}
