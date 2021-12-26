package com.xushibo.studyspringframework.di;

import com.xushibo.studyspringframework.di.beans.AccountDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDIContainer {

    public static void main(String[] args){

        //创建上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-ioc-config.xml");
        //从上下文中获取bean工厂
        BeanFactory beanFactory = context.getAutowireCapableBeanFactory();
        //从上下文中获取bean
        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

        System.out.println(accountDao.toString());
        //从bean工厂中获取bean
        AccountDao accountDaoFromBeanFactory = (AccountDao) beanFactory.getBean("accountDao");

        //两个bean是否是同一个对象
        System.out.println(accountDao.equals(accountDaoFromBeanFactory));

        //bean是否为单例
        boolean isSingleton = context.isSingleton("accountDao");

        System.out.println(isSingleton);

    }

}
