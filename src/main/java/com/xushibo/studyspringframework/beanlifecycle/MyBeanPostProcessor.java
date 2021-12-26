package com.xushibo.studyspringframework.beanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String beanName) throws BeansException {
        System.out.println("InstantiationAwareBeanPostProcessor.postProcessBeforeInitialization,name: "+beanName);
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String beanName) throws BeansException {
        System.out.println("InstantiationAwareBeanPostProcessor.postProcessAfterInitialization,name: "+beanName);
        return o;
    }
}
