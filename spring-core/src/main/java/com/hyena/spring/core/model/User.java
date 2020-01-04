package com.hyena.spring.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * 用户实体类
 *
 * @author hyena
 */


@AllArgsConstructor
@Data
@Builder
@Log4j
public class User {

    /**
     * 用户名称
     */
    private String name;


    /**
     * 用户年龄
     */
    private Integer age;

    public User() {
       log.info("default constructor of User");
    }
}
