package com.hyena.spring.core.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Log4j
public class Customer {

    private User user ;

    private String name;

    private int age ;


    public void init() {
        log.info("Customer init method");
    }


    public void destroy() {
        log.info("Customer destroy method");
    }
}
