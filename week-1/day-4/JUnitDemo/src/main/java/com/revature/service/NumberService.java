package com.revature.service;

import java.util.HashMap;
import java.util.Map;

public class NumberService {

	public int getNthFib(int n) {
		if (n <= 0) throw new IllegalArgumentException("n must be 1 or greater");
		
		Map<Integer, Integer> memoize = new HashMap<Integer, Integer>();
		
		memoize.put(1, 1);
		memoize.put(2, 1);
		return getNthFib(n, memoize);
	}
	
	// Create helper method
	private int getNthFib(int n, Map<Integer, Integer> memoize) {
		if (memoize.containsKey(n)) {
			return memoize.get(n);
		} else {
			memoize.put(n, getNthFib(n - 1, memoize) + getNthFib(n - 2, memoize));
			return memoize.get(n);
		}
	}
	
	public int getNthPrime(int n) {
		return 0;
	}
	
}
