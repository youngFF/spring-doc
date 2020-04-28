package com.hyena.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
