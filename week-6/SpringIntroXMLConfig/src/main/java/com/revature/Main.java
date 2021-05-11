package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		// ApplicationContext is an interface that extends upon another interface called BeanFactory
		// ApplicationContext and BeanFactory are both IoC containers (meaning they establish the
		// principle of inversion of control) by instantiating beans and storing beans inside of 
		// the container
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// When we spin up the IoC container ^^, it will look through our configuration file
		// and automatically instantiate the beans
		
		Coach coach = (Coach) context.getBean("myTrackCoach");
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getMotivation());
		
		Coach coach2 = (Coach) context.getBean("myCodingCoach");
		System.out.println(coach2.getDailyWorkout());
		System.out.println(coach2.getMotivation());
		
		// the close method is on the ClassPathXmlApplicationContext class itself, not ApplicationContext
		// So I need to downcast to access the close method
		((ClassPathXmlApplicationContext) context).close();
	}

}
