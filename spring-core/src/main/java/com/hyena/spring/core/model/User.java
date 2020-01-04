package com.hyena.spring.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户实体类
 *
 * @author hyena
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {

    /**
     * 用户名称
     */
    private String name;


    /**
     * 用户年龄
     */
    private Integer age;

}
