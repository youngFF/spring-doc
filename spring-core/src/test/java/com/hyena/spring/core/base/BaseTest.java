package com.hyena.spring.core.base;


import com.google.gson.Gson;
import lombok.extern.log4j.Log4j;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-config.xml"})
@Log4j
public abstract class BaseTest {

    @Autowired
    protected Gson gson;

    // object to be assigned
    protected Object result;

    // applicationContext injected
    @Autowired
    protected ApplicationContext applicationContext;


    /**
     * print result to json
     *
     */
    @After
    public void printResult2Json() {
        String clazzName = getClass().getName();
        log.info(clazzName + " : " + result);
    }
}
