package com.xushibo.studyspringframework.beanlifecycle;

import org.springframework.stereotype.Component;

/**
 *bean的实例化
 *
 * */
@Component
public class Car {

       public Car(){
           System.out.println("Car constructor invoke");
       }

}
