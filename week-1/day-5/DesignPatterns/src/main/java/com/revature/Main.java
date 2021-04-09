package com.revature;

import com.revature.exception.StudentTypeDoesNotExistException;
import com.revature.factory.College;
import com.revature.factory.Student;
import com.revature.singleton.SingletonClass;

public class Main {

	public static void main(String[] args) {
		// Cannot be done, since the constructor is private
//		SingletonClass sc = new SingletonClass();

		SingletonClass sc = SingletonClass.getInstance();
		SingletonClass sc2 = SingletonClass.getInstance();
		
		// Ternary expression
		// <boolean expression> ? <expression if true> : <expression if false>
		System.out.println("Are they the same instance? " + (sc == sc2 ? "Yes" : "No"));
		
		/*
		 * Factory example
		 */
		College studentFactory = College.getInstance();
		
		try {
			Student student = studentFactory.getStudent("math", "John", 20);
			student.study();
			
			student = studentFactory.getStudent("history", "Bob", 19);
			student.study();
			
			student = studentFactory.getStudent("english", "Jill", 22);
			student.study();
			
			student = studentFactory.getStudent("dfdfd", "Test", 30);
		} catch (StudentTypeDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
