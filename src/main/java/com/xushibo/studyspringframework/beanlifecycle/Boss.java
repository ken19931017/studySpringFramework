package com.xushibo.studyspringframework.beanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *实例化-》InstantiationAwareBeanPostProcessorAdapter.postProcessBeforeInstantiation
 * -》bean的构造函数-》InstantiationAwareBeanPostProcessorAdapter.postProcessPropertyValues
 * -》属性赋值-》BeanNameAware-》BeanFactoryAware-》ApplicationContextAware
 * -》BeanPostProcessor.postProcessBeforeInitialization-》InitializingBean.afterPropertiesSet
 * -》@Bean定义的initMethod-》BeanPostProcessor.postProcessAfterInitialization
 * -》InstantiationAwareBeanPostProcessorAdapter.postProcessAfterInitialization
 * **/
public class Boss implements BeanNameAware , BeanFactoryAware , ApplicationContextAware
 , InitializingBean , DisposableBean {

    private String bossName;
    public Boss(){
        System.out.println("Boss constructor invoke");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("Boss.setBeanName invoke");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Boss.setBeanFactory invoke");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Boss.setApplicationContext invoke");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Boss.afterPropertiesSet invoke");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Boss.destroy invoke");
    }

    @Value("${Boss.bossName}")
    public void setBossName(String bossName) {
        this.bossName = bossName;
        System.out.println("Boss.setName invoke :Boss name ="+bossName);
    }

    public void myPostConstruct(){
        System.out.println("Boss.myPostConstruct invoke");
    }

    public void myPreDestory(){
        System.out.println("Boss.myPreDestory invoke");
        System.out.println("-------------Destory--------------------");
    }
}
