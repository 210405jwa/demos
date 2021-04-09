package com.revature.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NumberServiceTest {
	
	public NumberService numberService;
	
	@BeforeClass
	public static void setUp() {
		// IN here you set up whatever sort of resources all of your tests might require
		System.out.println("Inside setUp()");
	}
	
	@AfterClass
	public static void tearDown() {
		// IN here we can close whatever resources we might have been using
		System.out.println("Inside tearDown()");
	}
	
	@Before
	public void beforeEachTest() {
		// @Before is typically used to create a "fresh slate" for each subsequent test
		// For example, reinstantiating a fresh object for each test
		System.out.println("Inside beforeEachTest()");
		numberService = new NumberService();
	}
	
	@After
	public void afterEachTest() {
		System.out.println("Inside afterEachTest()");
	}
	
	// 1 1 2 3 5
	
	/*
	 * Positive test examples
	 */
	@Test
	public void test_getNthFib_is5_for_fifthFibNumber() {
		int actual = numberService.getNthFib(5);
		int expected = 5;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_getNthFib_is8_for_sixthFibNumber() {
		int actual = numberService.getNthFib(6);
		int expected = 8;
		
		assertEquals(expected, actual);
	}
	
	// Tests will automatically fail if an exception (or error) is thrown
	// Here I want my test to pass IF this Error occurs
	// This is an example of a negative test
	// You are testing to see if the behavior that you want is actually happening in the case
	// of a user inputting or doing something outside of normal expectations
	
	/*
	 * Negative test examples
	 */
	@Test(expected = IllegalArgumentException.class) 
	public void test_getNthFib_forNegativeNumber() {
		numberService.getNthFib(-1);
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void test_getNthFib_forZeroNumber() {
		numberService.getNthFib(0);
	}
	
	/*
	 * Simple performance test
	 */
	// fail this test, if the code takes longer than 10 seconds to run
	// We can think of this as some sort of performance test for large n inputs
	@Test(timeout = 10000)
	public void test_getNthFib_forVeryLargeNumber() {
		numberService.getNthFib(50);
	}

}
