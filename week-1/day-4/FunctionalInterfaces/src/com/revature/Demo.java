package com.revature;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

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
		// There is an analytics engine known as Apache spark, that you can use with Java (using lambdas)
		// To do big data processing as well
		
		List<String> names = new ArrayList<>();
		names.add("Naruto");
		names.add("Pikachu");
		names.add("Cole MacGrath");
		names.add("Mario");
		names.add("Kenny");
		names.add("Jimmy John");
		names.add("Scott the Woz");
		names.add("Subway");
		
		// In streams, we have this idea of intermediate and terminal operations.
		// To actually get a final result that I can view, I need to do a terminal operation
		List<String> namesWithK = names.stream()
				.map((name) -> name.toUpperCase())
				.filter((name) -> name.contains("K"))
				.collect(Collectors.toList());
		
		System.out.println(namesWithK);
		
		System.out.println(names); // Original data inside my list of names is still unmodified
		IntSummaryStatistics summaryStats = names.stream().mapToInt((name) -> name.length()).summaryStatistics();
		
		double avg = summaryStats.getAverage();
		System.out.println("Average length of names: " + avg);
		int min = summaryStats.getMin();
		System.out.println("Minimum length of names: " + min);
		int max = summaryStats.getMax();
		System.out.println("Maximum length of names: " + max);
	}
	
	public static void useString(String s, Consumer<String> f) {
		f.accept(s);
	}

}
