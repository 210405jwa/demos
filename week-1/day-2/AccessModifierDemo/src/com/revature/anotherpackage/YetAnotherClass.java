package com.revature.anotherpackage;

import com.revature.Main;

public class YetAnotherClass {

	public static void someStaticMethod() {
		AnotherClass.someDefaultStaticVariable = 0;
		
		AnotherClass ac = new AnotherClass();
		ac.someDefaultInstanceVariable = 1000;
	}
	
}
