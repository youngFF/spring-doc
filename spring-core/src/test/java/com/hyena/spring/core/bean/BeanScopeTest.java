package com.hyena.spring.core.bean;

import com.hyena.spring.core.base.BaseTest;
import com.hyena.spring.core.model.Customer;
import org.junit.Test;


/**
 * 测试目标：Bean作用域
 *
 * @author yangxingdong
 */
public class BeanScopeTest extends BaseTest {


    //--------------- singletonTest unite -------------//

    /**
     * 测试目标：spring singleton scope
     * 测试数据：
     * config/app-config.xml中User配置
     * 测试结果：positive
     */
    @Test
    public void singletonBeanTest() {
        Object obj1 = applicationContext.getBean("user");
        Object obj2 = applicationContext.getBean("user");

        result = (obj1 == obj2);
    }
    //--------------- singletonTest unite end-------------//

    //--------------- prototypeTest unit------------------//

    /**
     * 测试目标：spring prototype scope
     * 测试数据：
     * config/app-config.xml中sixthCustomer配置
     * 测试结果：positive
     */
    @Test
    public void prototypeTest() {
        Object obj1 = applicationContext.getBean("sixthCustomer");
        Object obj2 = applicationContext.getBean("sixthCustomer");

        result = (obj1 == obj2);
    }
    //--------------- prototypeTest unit end------------------//


    //---------------aop:proxy-scoped unit ------------//

    /**
     * 测试目标：aop:scoped-proxy
     * 测试数据：
     *      config/app-config.xml中seventhCustomer依赖supplier，
     *      而supplier被<aop:scoped-proxy>
     *
     * 测试结果：positive
     *         说明：打印注入到seventhCustomer中的supplier的类型为
     *         com.hyena.spring.core.model.Supplier$$EnhancerBySpringCGLIB$$e375cf53
     *
     *        spring默认使用CGLIB代理
     *
     *
     *
     *
     *
     */
    @Test
    public void proxyScopedTest() {
        Customer seventhCustomer = applicationContext.getBean("seventhCustomer", Customer.class);
        result = seventhCustomer.getSupplier().getClass().getName();

    }
    //---------------aop:proxy-scoped unit end------------//


}
