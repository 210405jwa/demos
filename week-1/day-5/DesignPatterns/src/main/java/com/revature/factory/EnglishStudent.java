package com.revature.factory;

public class EnglishStudent extends Student {

	public EnglishStudent() {
		super();
	}

	public EnglishStudent(int age, String name) {
		super(age, name, "English");
	}

	@Override
	public void study() {
		System.out.println("Writing essays");
	}

}
