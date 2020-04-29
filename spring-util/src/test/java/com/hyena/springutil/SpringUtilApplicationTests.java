package com.hyena.springutil;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes = SpringUtilApplication.class)
class SpringUtilApplicationTests {

    @Autowired
    protected ApplicationContext applicationContext;

    @Test
    void contextLoads() {
    }

}
