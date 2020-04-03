package com.hyena.springboot;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public abstract class BaseTest {

    protected Object result;
    @Autowired
    private Gson gson;

    public void printReslt() {
        log.info("result: " + gson.toJson(result));
    }


}
