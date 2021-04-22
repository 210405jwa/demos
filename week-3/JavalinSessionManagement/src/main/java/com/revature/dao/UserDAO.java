package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.dto.LoginDTO;
import com.revature.model.User;

public class UserDAO {

	// Pretend we have an actual database
	List<User> users = new ArrayList<>();
	
	{
		users.add(new User(1, "user", "password"));
	}
	
	public User getUserByUsernameAndPassword(LoginDTO loginDTO) {
		for (User u : users) {
			if (loginDTO.getUsername().equals(u.getUsername()) && loginDTO.getPassword().equals(u.getPassword())) {
				return u;
			}
		}
		
		return null;
	}
	
}
