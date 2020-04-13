package com.hyena.springboot.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * BaseController存放Controller公共属性
 */
public class BaseController {

    @Autowired
    protected Gson gson;
}
