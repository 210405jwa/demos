package com.revature.services;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dao.UserDAO;
import com.revature.exception.UserNotFoundException;
import com.revature.model.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Transactional(rollbackFor = { UserNotFoundException.class }) // Checked exceptions need to be
	// specified inside of the Transactional annotation so that we don't get
	// 'UnexpectedRollbackException' being thrown by our Transaction Manager
	public User login(String username, String password) throws UserNotFoundException {
		
		try {
			User user = userDAO.getUserByUsernameAndPassword(username, password);
			return user;
		} catch (NoResultException e) {
			throw new UserNotFoundException("User not found w/ the provided username and password");
		}
		
	}
	
}
