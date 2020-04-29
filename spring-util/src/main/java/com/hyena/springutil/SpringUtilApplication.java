package com.hyena.springutil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringUtilApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringUtilApplication.class, args);
    }

}
