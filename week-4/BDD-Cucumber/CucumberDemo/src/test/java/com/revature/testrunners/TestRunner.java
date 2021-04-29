package com.revature.testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/com/revature/features",
		glue="com.revature.gluecode") 
// I can specify just the directory of where all of the different features are for the features option, or 
// I can specify a specific feature file
public class TestRunner {

}
