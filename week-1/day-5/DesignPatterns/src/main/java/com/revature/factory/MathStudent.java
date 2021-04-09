package com.revature.factory;

public class MathStudent extends Student {

	public MathStudent() {
		super();
	}
	
	public MathStudent(int age, String name) {
		super(age, name, "Mathematics");
	}
	
	@Override
	public void study() {
		System.out.println("Doing math problems");
	}

}
