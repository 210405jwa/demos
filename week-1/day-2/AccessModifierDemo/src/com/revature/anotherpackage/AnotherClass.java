package com.revature.anotherpackage;

public class AnotherClass {

	public static int somePublicStaticVariable;
	protected static int someProtectedStaticVariable;
	static int someDefaultStaticVariable; // just leave off the access modifier in the case of default access
	// the 'default' keyword is totally unrelated to the default access modifier
	private static int somePrivateStaticVariable;
	
	// From most accessible to least
	public int somePublicInstanceVariable;
	protected int someProtectedInstanceVariable;
	int someDefaultInstanceVariable;
	private int somePrivateInstanceVariable;
	
	public static void someStaticMethod() {
		somePrivateStaticVariable = -5000;
		
		AnotherClass ac = new AnotherClass();
		ac.somePrivateInstanceVariable = 2000;
	}
}
