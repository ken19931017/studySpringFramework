package com.xushibo.studyspringframework.beaninstance;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyServiceByInitializingBean implements InitializingBean {
    @Autowired
    private LightService lightService;
    /**失败写法*/
    //public MyService() {
    //lightService.check();
    //}
    /**成功写法 实现InitializingBean 接口*/
    @Override
    public void afterPropertiesSet() throws Exception {
        lightService.check();
    }
}
