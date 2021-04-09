package com.revature.singleton;

/*
 * A Singleton is a class where you restrict construction of an instance, such that you can ever
 * only have 1 instance in your program
 * 
 * This is accomplished by having a private constructor (so that you can't arbitrarily construct
 * new instances using the new keyword)
 * 
 * We then have some sort of method, in this case we'll call it getInstance, which will check to see
 * if the instance property is null, and if it is, will construct a new object. Otherwise, it will
 * return the already existing instance.
 */
public class SingletonClass {

	private static SingletonClass instance = null;
	
	private SingletonClass() {
		super();
	}
	
	public static SingletonClass getInstance() {
		// Instantiate an instance if it doesn't already exist
		if (instance == null) {
			instance = new SingletonClass();
		}
		
		// return the one instance
		return instance;
	}
	
}
