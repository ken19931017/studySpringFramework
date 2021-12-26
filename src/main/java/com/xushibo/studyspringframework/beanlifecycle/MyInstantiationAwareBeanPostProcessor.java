package com.xushibo.studyspringframework.beanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {

        System.out.println("InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation,name: "+beanName);
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {

        System.out.println("InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation,name: "+beanName);
        return true;
    }
}
