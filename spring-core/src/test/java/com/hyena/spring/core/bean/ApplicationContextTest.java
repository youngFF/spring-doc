package com.hyena.spring.core.bean;

import com.hyena.spring.core.base.BaseTest;
import com.hyena.spring.core.model.Customer;
import com.hyena.spring.core.model.User;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;


/**
 * 测试目标：创建Spring容器
 *
 * @author hyena
 */
public class ApplicationContextTest extends BaseTest {


    // ------------------ createSpringContainerTest unit ----------//

    /**
     * 测试目标：创建Spring容器，然后从容器中获取bean
     * 测试数据：
     * 无
     * 测试结果：positive
     * 能够从Spring容器中获取User
     */
    @Test
    public void createSpringContainerTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");
        result = context.getBean(User.class);
    }

    /**
     * 测试目标：创建Spring容器，将配置文件路径改为classpath:/spring/spring-config.xml
     * 测试数据：
     * 无
     * 测试结果：positive
     * 能够从Spring容器中获取User
     */
    @Test
    public void createSpringContainerTest1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/spring-config.xml");
        result = context.getBean(User.class);
    }


    /**
     * 测试目标：创建Spring容器，先创建Spring容器对象，然后加载配置文件，然后容器刷新
     * 测试数据：
     * 无
     * 测试结果：positive
     * 能够从Spring容器中获取User
     */
    @Test
    public void createSpringContainerTest2() {
        GenericApplicationContext context = new GenericApplicationContext();
        new XmlBeanDefinitionReader(context).loadBeanDefinitions("classpath:/spring/spring-config.xml");
        context.refresh();

        result = context.getBean(User.class);
    }

    // ------------------ createSpringContainerTest unit end----------//


    // -------------------beanDefinitionTest unit ----------//


    /**
     * 测试目标：看bean definition中每个属性都是干什么的
     * 测试数据：
     * config/app-config.xml中customer bean的配置
     * <p>
     * 测试结果：positive
     * customer能够成功配置
     * <p>
     * 注意：customer中使用了autowire=byType，这个属性能够自动注入bean的属性。
     * 可以看到配置中并没有customer的user依赖，但是代码的结果中能看见user属性
     */
    @Test
    public void beanDefinitionTest() {
        result = applicationContext.getBean("customer");

    }
    // -------------------beanDefinitionTest unit end----------//

    // ------------------constructor-base DI unite------------------//

    /**
     * 测试目标：constructor-based DI配置
     * 测试数据：
     * config/app-config.xml中anotherCustomer bean配置
     * 测试结果：positive
     * 能够获取bean
     */
    @Test
    public void constructorBaseDITest() {
        result = applicationContext.getBean("anotherCustomer");
    }
    // ------------------constructor-base DI unite end------------------//

    // ------------------setter-base DI unite     ------------------//

    /**
     * 测试目标：constructor-base和setter-base 混合配置
     * 测试数据：
     * config/app-config.xml中thirdCustomer beab配置
     * 测试结果：
     *
     */
    @Test
    public void setterAndConstructorBaseDITest() {
        result = applicationContext.getBean("thirdCustomer");
    }
    // ------------------setter-base DI unite end------------------//
}
