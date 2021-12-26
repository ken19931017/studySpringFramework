# spring bean的生命周期

## Bean级生命周期接口

BeanNameAware

BeanFactoryAware

ApplicationContextAware

InitializingBean

DisposableBean



## 容器级生命周期接口

BeanPostProcessor

InstantiationAwareBeanPostProcessorAdapter



## 执行顺序

### 启动阶段

实例化-》InstantiationAwareBeanPostProcessorAdapter.postProcessBeforeInstantiation-》bean的构造函数-》InstantiationAwareBeanPostProcessorAdapter.postProcessPropertyValues-》属性赋值-》BeanNameAware-》BeanFactoryAware-》ApplicationContextAware-》BeanPostProcessor.postProcessBeforeInitialization-》InitializingBean.afterPropertiesSet-》@Bean定义的initMethod-》BeanPostProcessor.postProcessAfterInitialization-》InstantiationAwareBeanPostProcessorAdapter.postProcessAfterInitialization

### 销毁阶段

DisposableBean.destory-》@Bean定义的destoryMethod



# 案例

https://gitee.com/ken19931017/studyspringframework/tree/master/src/main/java/com/xushibo/studyspringframework/beanlifecycle

