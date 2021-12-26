# bean的实例化失败问题解析

bean的实例化基本还是java对象的实例化。且spring是不能干涉java的实例化的。

通常springbean是需要经历实例化-》依赖关系注入-》bean的初始化后，才能正常使用。

如果想在某个bean的构造方法中直接使用容器管理的依赖注入的bean,会因为此时bean还未实例化导致NPE。

案例如下

**需求：我想在我的服务类初始化时做些业务检查**

样例代码：

```java
package com.xushibo.studyspringframework.beaninstance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyService {

    @Autowired
    private LightService lightService;
    /**失败写法*/
    public MyService() {
        lightService.check();
    }
    


}
```

此时我们想在构造MyService时获取自动注入的LightService，就会报空指针。

springbean的初始化周期如下

![img](bean%E7%9A%84%E5%AE%9E%E4%BE%8B%E5%8C%96.assets/6ff70ab627711065bc17c54c001ef08a.png)



创建bean的核心代码如下

```java
protected Object doCreateBean(final String beanName, final RootBeanDefinition mbd, final @Nullable Object[] args)
    throws BeanCreationException {
    //省略非关键代码
  if (instanceWrapper == null) {
    instanceWrapper = createBeanInstance(beanName, mbd, args);
  }
  final Object bean = instanceWrapper.getWrappedInstance();

    //省略非关键代码
    Object exposedObject = bean;
    try {
       populateBean(beanName, mbd, instanceWrapper);
       exposedObject = initializeBean(beanName, exposedObject, mbd);
    }
    catch (Throwable ex) {
    //省略非关键代码
}
```



其中createBeanInstance 是bean的实例化，populateBean是处理依赖关系，initializeBean是bean最终的初始化。

再深入看下createBeanInstance方法，你会发现默认构造器显然是在类实例化的时候被自动调用的，Spring 也无法控制。而此时负责自动装配的 populateBean 方法还没有被执行，LightMgrService 的属性 LightService 还是 null，因而得到空指针异常也在情理之中。

因此解决办法有如下三种

1. 隐式构造器注入
2. PostConstruct注解
3. 实现InitializingBean 接口



样例代码

```
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
```



```
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

```



```
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

```

