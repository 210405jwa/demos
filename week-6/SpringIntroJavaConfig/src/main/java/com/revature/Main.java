package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.config.MyBeanConfig;

public class Main {

	public static void main(String[] args) {
		
		// ApplicationContext is an interface that extends upon another interface called BeanFactory
		// ApplicationContext and BeanFactory are both IoC containers (meaning they establish the
		// principle of inversion of control) by instantiating beans and storing beans inside of 
		// the container
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// When we spin up the IoC container ^^, it will look through our configuration file
		// and automatically instantiate the beans
		
		Coach coach = (Coach) context.getBean("trackCoach");
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getMotivation());
		
		Coach coach2 = (Coach) context.getBean("codingCoach");
		System.out.println(coach2.getDailyWorkout());
		System.out.println(coach2.getMotivation());
		
		Coach coach3 = (Coach) context.getBean("stagingCoach");
		System.out.println(coach3.getDailyWorkout());
		System.out.println(coach3.getMotivation());
		
		// the close method is on the ClassPathXmlApplicationContext class itself, not ApplicationContext
		// So I need to downcast to access the close method
		((ClassPathXmlApplicationContext) context).close();
	}

}
