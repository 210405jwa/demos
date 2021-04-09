package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo {

	private static final Logger logger = LoggerFactory.getLogger(Demo.class);
	
	public static void main(String[] args) {
	
		logger.info("Hello Logs from {}", Demo.class.getSimpleName());
		logger.warn("WARNING!");
		logger.error("BAD THING HAPPEN!!!!!");

	}

}
