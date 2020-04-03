package com.hyena.springboot.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;


public class BaseController {


    @Autowired
    protected Gson gson;
}
