package com.hyena.spring.core.beanpostprocessor;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;


@NoArgsConstructor
@Log4j
public class InstantiateTraceBeanPostProcessor implements BeanPostProcessor, Ordered {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        String clazzName = bean.getClass().getName();
        log.info("clazzName: " + clazzName + " beanName: " + beanName);
        return bean;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
