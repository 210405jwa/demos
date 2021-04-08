package com.revature;

// A functional interface is simply an interface that has a single abstract method
@FunctionalInterface // This annotation just helps us to know if we are actually creating a functional interface or not
public interface MyFunctionalInterface<T> {

	void consume(T t);
	
}
