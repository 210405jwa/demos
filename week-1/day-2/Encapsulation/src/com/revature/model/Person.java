package com.revature.model;

public class Person {

	private String name;
	private int age;
	private String occupation;
	private String phoneNumber;
	
	public Person() {}
	
	public Person(String name, int age, String occupation, String phoneNumber) {
		this.name = name;
		this.age = age;
		this.occupation = occupation;
		this.phoneNumber = phoneNumber;
	}

	/*
	 * Getter methods: Allows my objects to have "read" ability
	 * If I have only getters but no setters, I am "read-only"
	 * In other words, you can think of Person as "Immutable". Unless I add setters
	 */
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getOccupation() {
		return occupation;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/*
	 * Setter methods: Allows my objects to have "write" ability
	 * So this will actually allow me to mutate my Person objects
	 * So, if I add setters, my class is "mutable" instead of "immutable"
	 */
	
	// In this setter method, I provide some validation logic that checks if the value I want to set matches a certain pattern
	// enforced by Regex
	public void setName(String name) {
		if (name.matches("[a-zA-Z\\s']+")) {
			this.name = name;
		} else {
			throw new IllegalArgumentException("You entered an invalid name. Please include only whitespaces, alphabetical characters, "
					+ "and apostrophes (')");
		}
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
