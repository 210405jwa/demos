package com.revature.factory;

public class HistoryStudent extends Student {

	public HistoryStudent() {
		super();
	}

	public HistoryStudent(int age, String name) {
		super(age, name, "History");
	}

	@Override
	public void study() {
		System.out.println("Learning about the postwar era");
	}

}
