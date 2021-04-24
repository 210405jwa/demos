package com.revature;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyTest {

	@BeforeAll // In JUnit 4, the equivalent was @BeforeClass
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll // JUnit4: @AfterClass
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach // JUnit4: @Before
	void setUp() throws Exception {
	}

	@AfterEach // JUnit4: @After
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		
	}

}
