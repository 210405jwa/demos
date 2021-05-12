package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.revature.dao.ShipDAO;

@Service
//@Scope("prototype") // Specify scope using @Scope annotation
public class ShipService {

	@Autowired
	private ShipDAO fakeDAO;
	
	public String demo() {
		return "demo() from MyDemoService: Hi!!!!";
	}
	
}
