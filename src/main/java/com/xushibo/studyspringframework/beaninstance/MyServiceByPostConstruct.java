package com.xushibo.studyspringframework.beaninstance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyServiceByPostConstruct {

    @Autowired
    private LightService lightService;
    /**失败写法*/
    //public MyService() {
    //lightService.check();
    //}
    /**成功写法 postConstruct*/
    @PostConstruct
    public void init(){
        lightService.check();
    }

}
