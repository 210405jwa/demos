package com.revature.model;

public class AnotherClass {

	public static int someStaticVariable;
	public int someInstanceVariable;
	
	public static void someStaticMethod() {
		System.out.println("someStaticVariable: " + someStaticVariable);
	}
	
	public void someInstanceMethod() {
		System.out.println("someInstanceVariable: " + this.someInstanceVariable);
	}
}
