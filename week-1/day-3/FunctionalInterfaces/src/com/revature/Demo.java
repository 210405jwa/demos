package com.revature;

import java.util.function.Consumer;

public class Demo {

	public static void main(String[] args) {
		// Anonymous class: a class that has no name
		// So here, I am creating a class that Overrides the consume method inside my Interface
		// and instantiating an instance of it
		MyFunctionalInterface<String> printStringWithExclamationMark = new MyFunctionalInterface<String>() {
			@Override
			public void consume(String s) {
				System.out.println(s + "!");
			}
		};
		
//		useString("Hello", printStringWithExclamationMark);
		
		// The above with the Anonymous class seems verbose, so we have this idea of lambdas, which is really just
		// for the most part, syntactic sugar
		MyFunctionalInterface<String> myLambda = (String s) -> {
			System.out.println(s);
			System.out.println(s + "!");
		};
		
//		useString("Hello", myLambda);
		
		// You don't typically need to create your own functional interfaces. There are already so many different types
		// So we can just make use of what is already available.
		// Consumer is built in
		Consumer<String> myConsumer = (String s) -> {
			System.out.println(s + "!!!!!");
		};
		
		useString("Hello", myConsumer);
		
		// Java has a Stream API that is really useful to perform operations such as map, filter, and reduce
		// These are operations commonly performed in big data processing
		// We can utilize lambdas to make this process easier
	}
	
	public static void useString(String s, Consumer<String> f) {
		f.accept(s);
	}

}
