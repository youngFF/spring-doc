package com.hyena.springboot.config;


import com.hyena.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public User getUser() {
        return new User();
    }
}
