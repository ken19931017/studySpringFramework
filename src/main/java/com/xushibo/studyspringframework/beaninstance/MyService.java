package com.xushibo.studyspringframework.beaninstance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyService {

    @Autowired
    private LightService lightService;
    /**失败写法*/
    //public MyService() {
        //lightService.check();
    //}
    /**成功写法 隐式构造器注入*/
    public MyService(LightService lightService){
        lightService.check();
    }


}
