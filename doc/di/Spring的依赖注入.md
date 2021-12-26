# Spring的依赖注入

Spring框架的两大特性，DI和AOP。实现这两大特性的首先的基础，是它创建了一个IOC容器。万物基于对象转变为万物基于Spring Bean。在我们还没想好怎么设计业务对象之前，Spring以首先给我们未来的对象加上一层包装。通过Bean Definition,Spring使普通的对象具有了被容器管理的能力。从而，它获取了被依赖查找和被依赖注入的能力。这种现象就是所谓的控制反转-IOC。因此，Spring创建的容器被赋予IOC的前缀。

Spring的IOC容器的主要接口，BeanFactory和ApplicationContext。主要说明了容器的特性。我们查看源码可以得知有如下几种能力



- 通过各种方式获取容器里的bean
- 是否包含某个bean
- 是否为单例
- 是否类型匹配
- 获取bean的类型
- 获取bean的别名
- 获取bean的元信息
- 通过类型或者注解获取bean的名字
- 容器上下文id
- 容器上下文启动时间
- 容器上下文的父上下文
- 获取可以自动装配的beanfactory



此外，ApplicationContext作为主要的容器实现，它还继承了环境装配，资源获取，国际化，事件发布等接口。所以，官方更推荐通过继承ApplicationContext，实现自己特色的IOC容器。

实现容器，可以通过xml配置文件或者java编程的方式。实例化容器，也就是启动容器的过程。启动容器后我们可以通过上述容器的特性去控制被容器管理的bean,乃至可以获取到bean的元信息，或者通过元信息去使用ｂｅａｎ．

容器的实例化和ｂｅａｎ的实例化是一起的。所以容器的生命周期和ｂｅａｎ的生命周期也有交集。依赖注入的过程也是发生在这两个生命周期启动期间，或者如果是懒加载的方式，最起码也是运行期。

ｂｅａｎ的作用域，此时只有单例和原型两种。

```ｊａｖａ
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
```



```ｘｍｌ
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="accountDao"
          class="com.xushibo.studyspringframework.di.beans.AccountDao"
    scope="prototype">
        <property name="accountName" value="xushibo"/>
    </bean>

    <!-- more bean definitions for data access objects go here -->

</beans>
```



结果如下

![image-20210912195108215](Spring%E7%9A%84%E4%BE%9D%E8%B5%96%E6%B3%A8%E5%85%A5.assets/image-20210912195108215-1631447470573.png)



关联脑图如下

![spring核心内容](Spring%E7%9A%84%E4%BE%9D%E8%B5%96%E6%B3%A8%E5%85%A5.assets/spring%E6%A0%B8%E5%BF%83%E5%86%85%E5%AE%B9-1631447512611.jpg)

