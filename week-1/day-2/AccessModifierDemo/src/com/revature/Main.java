package com.revature;

import com.revature.anotherpackage.AnotherClass;

public class Main extends AnotherClass {

	public static void main(String[] args) {
		
		AnotherClass.somePublicStaticVariable = 100;
		
		AnotherClass.someProtectedStaticVariable = 100;
//		AnotherClass.somePrivateStaticVariable = 1000;
		
		AnotherClass ac = new AnotherClass();
		ac.somePublicInstanceVariable = 1000;
//		ac.someProtectedInstanceVariable = 2000; // It seems like I might be able to this from our
		// initial intuition, but because the object AnotherClass is the parent.. not the Subclass
		// we can't
		
		// However here, because we are instantiating a child object Main, which is a subclass of AnotherClass
		// we can access the protected instance variable
		Main main = new Main();
		main.someProtectedInstanceVariable = 1000;
	}

}
