package com.revature.main;

import com.revature.model.Product;

public class PassByValue {

	public static void main(String[] args) {
		
		Product p1 = new Product();
		
		changeProduct(p1);
		
		System.out.println(p1.productName);
		
		/*
		 * 
		 */
		
		int x = 10;

		changeNumber(x);
		
		System.out.println(x);
	}
	
	private static void changeNumber(int a) {
		System.out.println("a: " + a);
		a = 30;
	}
	
	private static void changeProduct(Product product) {
		product.productName = "iPhone";
		product.price = 1200;
		product.taxRate = 0.0625;
	}

}
