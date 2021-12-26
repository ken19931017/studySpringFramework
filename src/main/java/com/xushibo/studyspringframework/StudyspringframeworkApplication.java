package com.xushibo.studyspringframework;

import com.xushibo.studyspringframework.beanlifecycle.Boss;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudyspringframeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyspringframeworkApplication.class, args);
	}

	@Bean(initMethod = "myPostConstruct",destroyMethod = "myPreDestory")
	public Boss boss(){
		return new Boss();
	}
}
