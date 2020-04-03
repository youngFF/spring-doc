package com.hyena.springboot.controller;

import com.hyena.springboot.BaseTest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@Log4j2
public class MyControllerTest extends BaseTest {


    @Autowired
    private WebApplicationContext webApplicationContext;


    private MockMvc mockMvc;


}
