package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.services.MyDemoService;

@Controller
public class MyDemoController {
	
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
	
	@RequestMapping(path = "hello", produces = {"application/json"})
	@ResponseBody
	public ResponseEntity<String> ourFirstEndpoint() {
		return ResponseEntity.ok(demoService.demo());
	}
}
