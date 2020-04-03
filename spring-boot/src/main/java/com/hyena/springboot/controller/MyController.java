package com.hyena.springboot.controller;


import com.hyena.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hyena/user")
@Log4j2
public class MyController extends BaseController {

    @Autowired
    private User user;


    @RequestMapping(value = "/get/{echo}", method = {RequestMethod.GET, RequestMethod.POST})
    public User getUser(@PathVariable String echo) {
        log.info("echo is :" + gson.toJson(echo));
        user.setAge(12);
        user.setName("hyena");

        return user;
    }

}
