package com.revature.map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	public static void demo() {
		Map<String, Long> phoneBook = new HashMap<>(); // ctrl + shift + o to import fast
		
		phoneBook.put("Alice", 5120000000L);
		phoneBook.put("Alex", 5120000001L);
		
		Long phoneNumber = phoneBook.get("Alice"); // The operation of retrieval is pretty much instantaneous, thanks to how
		// HashMaps are structured. 
		// More generally, this is concept in computer science known as hash tables
		// So, if you want to do more research on that, go ahead
		System.out.println(phoneNumber);
	}
	
}
