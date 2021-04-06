package com.revature;

import com.revature.model.Person;

public class Application {

	public static void main(String[] args) {
		Person p1 = new Person("Billy", 21, "Student", "512-000-0000");

		System.out.println(p1);
		
		System.out.println("p1 name: " + p1.getName());
		System.out.println("p1 age: " + p1.getAge());
		System.out.println("p1 occupation: " + p1.getOccupation());
		System.out.println("p1 phone number: " + p1.getPhoneNumber());
		
		p1.setName("Bob O'Leary");
		p1.setAge(22);
		p1.setOccupation("Software Engineer");
		p1.setPhoneNumber("833-000-0000");
		
		System.out.println();
		System.out.println("p1 name: " + p1.getName());
		System.out.println("p1 age: " + p1.getAge());
		System.out.println("p1 occupation: " + p1.getOccupation());
		System.out.println("p1 phone number: " + p1.getPhoneNumber());
	}

}
