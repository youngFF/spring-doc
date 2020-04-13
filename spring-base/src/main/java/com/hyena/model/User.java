package com.hyena.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    /**
     * 用户名称
     */
    private String name;


    /**
     * 年龄
     */
    private Integer age;
}
