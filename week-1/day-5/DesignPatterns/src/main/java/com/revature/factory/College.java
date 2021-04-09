package com.revature.factory;

import com.revature.exception.StudentTypeDoesNotExistException;

public class College {
	/*
	 * Making College a Singleton
	 */
	private static College instance = null;
	
	private College() {
		super();
	}
	
	public static College getInstance() {
		if(instance == null) {
			instance = new College();
		}
		
		return instance;
	}
	
	// Factory method
	public Student getStudent(String type, String name, int age) {
		if(type == null) {
			return null;
		}
		
		switch (type.toLowerCase()) {
		case "math":
			return new MathStudent(age, name);
		case "english":
			return new EnglishStudent(age, name);
		case "history":
			return new HistoryStudent(age, name);
		default:
			throw new StudentTypeDoesNotExistException("Type " + type + " does not exist!");
		}
	}
	
}
