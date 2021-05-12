package com.revature.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.services.MyDemoService;

@Controller // This is a stereotype annotation, just like @Component, @Service, @Repository
// What those annotations are for, is to have Spring register it as a Spring Bean
public class MyDemoController implements BeanNameAware, BeanFactoryAware {
	
	@Autowired
	private MyDemoService demoService;
	
	// We could still have a constructor here for passing in a mock demoService if we wanted to unit test
	// our controller
	// For testing controllers in general (unit OR integration testing), we can make use of mockMVC
	// Which is a library that allows us to have mock HTTP requests that will trigger our method handlers
	// for the endpoint
	public MyDemoController(MyDemoService myDemoService) {
		this.demoService = myDemoService;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "hello", produces = {"application/json"})
	public ResponseEntity<String> ourFirstEndpoint() {
		return ResponseEntity.status(200).body(demoService.demo());
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "test")
	public String viewResolverExample() { // Without wrapping the String inside of a ResponseEntity
		// or using @ResponseBody to tell Spring MVC to serialize the String into JSON,
		// Spring MVC is going to consult the viewResolver w/ the 'myfile' String
		return "myfile";
	}

	@Override
	public void setBeanName(String name) {
		// I can put custom logic here that I want related to this lifecycle "hook"
		System.out.println("MyDemoController bean name set: " + name);
	}
	
	@PostConstruct
	public void myInitMethod() {
		System.out.println("This runs during the initialization phase of the bean lifecycle");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println(beanFactory);
	}
}
