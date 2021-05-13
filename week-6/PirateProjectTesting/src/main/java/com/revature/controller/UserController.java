package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.exception.UserNotFoundException;
import com.revature.model.User;
import com.revature.services.UserService;
import com.revature.template.LoginTemplate;

import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpServletRequest request; // This will be a bean that is "request" scoped
	@Autowired
	private HttpServletResponse response; // This will be a bean that is "request" scoped
	
	@PostMapping(path = "login")
	public ResponseEntity<Void> login(@RequestBody @Valid LoginTemplate loginTemplate) {
		
		try {
			User user = userService.login(loginTemplate.getUsername(), loginTemplate.getPassword());
			
			HttpSession session = request.getSession(true); // if false, does not create a new session
			// but if true, does create a new session if one doesn't already exist
			session.setAttribute("loggedInUser", user);
			
			return ResponseEntity.status(200).build();
		} catch (UserNotFoundException e) {
			
			return ResponseEntity.status(400).build();
			
		}
		
	}
	
}
