package com.hyena.spring.core.model;


import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j;

@Data
@Builder
@Log4j
public class Customer {

    private User user;

    private Supplier supplier;

    private String name;

    private int age ;


    public Customer() {
        log.info("default constructor of Customer");
    }

//    public Customer(User user) {
//        this.user = user;
//        log.info("one arg of Customer constructor");
//    }

    public Customer(User user , Supplier supplier) {
        this.user = user ;
        this.supplier = supplier;
        log.info("two arg of Customer constructor");
    }

    public Customer(User user, Supplier supplier, String name, int age) {
        this.user = user ;
        this.supplier = supplier;
        this.name = name;
        this.age = age;
        log.info("four args of Customer constructor");
    }

    public Customer(User user, String name, int age) {
        this.user = user ;
        this.name = name ;
        this.age = age ;
        log.info("three args of Customer constructor");
    }


    public void init() {
        log.info("Customer init method");
    }


    public void destroy() {
        log.info("Customer destroy method");
    }
}
