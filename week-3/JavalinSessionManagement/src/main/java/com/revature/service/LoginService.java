package com.revature.service;

import com.revature.dao.UserDAO;
import com.revature.dto.LoginDTO;
import com.revature.exception.BadParameterException;
import com.revature.exception.LoginException;
import com.revature.model.User;

public class LoginService {

	private UserDAO userDAO;
	
	public LoginService() {
		this.userDAO = new UserDAO();
	}
	
	// This one is for Mockito
	public LoginService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public User login(LoginDTO loginDTO) throws BadParameterException, LoginException {
		// Do some checking for blank username, blank password
		if (loginDTO.getUsername().trim().equals("") || loginDTO.getPassword().trim().equals("")) {
			throw new BadParameterException("Cannot have blank username and/or password");
		}
		
		User user = userDAO.getUserByUsernameAndPassword(loginDTO);
		
		if (user == null) {
			throw new LoginException("User was not able to login in with the supplied username and password");
		}
		
		return user;
	}
	
}
