package com.revature.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListDemo {

	public static void demo() {
		
		// Lists maintain order. Whatever order I add them in, that is the order that will be maintained
		// I can have duplicate elements
		List<String> list = new ArrayList<>();
		
		list.add("Peaches");
		list.add("Avocadoes");
		list.add("Apples");
		list.add("Plums");
		list.add("Oranges");
		list.add("Kiwis");
		list.add("Kiwis");
		list.add("Kiwis");
		
		System.out.println("List: " + list);
		System.out.println("How many elements are inside the list: " + list.size());
		
		list.add(1, "Pears");
		System.out.println("List: " + list);
		
		System.out.println(list.get(3));
		
		list.remove(3);
		System.out.println(list);
		
		list.remove(new String("Kiwis")); // using .equals in the background to remove the first occurrence of .equals being true
		System.out.println(list);
		
		// traversing list
		for (int i = 0; i < list.size(); i++) {
			System.out.println("index: " + i + ": " + list.get(i));
			if (list.get(i).equals("Kiwis")) {
				list.remove(i);
				i--;
			}
		}
		System.out.println(list);
		
		// Enhanced for loop (for each)
		// Behind the scenes, the enhanced for loop is making use of an Iterator to iterate over the elements
		System.out.println();
		for (String i : list) {
			System.out.println(i);
		}
		
		// This code is pretty much the same as the enhanced for loop
		list.add("Kiwis");
		list.add("Kiwis");
		
		System.out.println(list);
		
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			if(iter.next().equals("Kiwis")) {
				iter.remove();
			}
		}
		
		System.out.println(list);
		
		System.out.println("list contains Apples: " + list.contains("Apples"));
		System.out.println("index of 'Pears' inside our list: " + list.indexOf("Pears"));
		System.out.println("index of 'Apples' inside our list: " + list.indexOf("Apples"));
		
		// Collections class: Utility class w/ useful methods
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
	}
	
//	public static void useList(List<String> al) {
//		// Use the ArrayList in here to do something
//		al.add("String 1");
//	}
	
}
