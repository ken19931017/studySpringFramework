# AOP与Spring

AOP是spring 框架的两大核心能力之一。2000年初Rod写《EXPERT ONE-ON-ONE J2EE DEVELOPMENT WITHOUT EJB》时，就专门提过AOP,在当时，这个概念还很新鲜。但是到今天，从Spring Framework到SpringBoot,这个特性可以说已经深入人心。从这一方面看，它也确实具有很强的应用价值。在Spring的官方指导文档中，它专门把声明式事务管理当作AOP在Spring中应用的一大场景。原话如下

> - Provide declarative enterprise services. The most important such service is [declarative transaction management](https://docs.spring.io/spring-framework/docs/current/reference/html/data-access.html#transaction-declarative).
>
>   

并且，Spring的AOP实践并不是闭门造车和另起炉灶。它使用了很多流行的概念。例如，aspect,join-piont,point-cut,advice等。Spring的AOP默认基于AspectJ。AspectJ是编译时增强，而Spring AOP是运行时动态代理进行增强。由此可见，虽然Spring AOP默认使用AspectJ的众多概念（注解）,但是仍是用自己的一套实现。在Spring IOC容器中，和AOP的定制化组合也是Spring的一大优势。

Spring的AOP是纯基于JAVA编程的，这样使他具有了很大的通用性，不需要开发者专门使用某个类加载器或者针对不同的web容器进行适配。当时Spring AOP目前只支持方法执行。如果想进行实例域的执行，可能就需要专门使用AspectJ这样的AOP工具框架了。另外Spring AOP设计初衷是为了利用起现有的IOC框架给使用者以最通用的AOP使用能力，解决最常见的问题。所以Spring并不执着AOP所有特性的实现，只使用其中最核心实用的部分。

Spring的切面增强其实是加在了目标类对应的代理类上了。

