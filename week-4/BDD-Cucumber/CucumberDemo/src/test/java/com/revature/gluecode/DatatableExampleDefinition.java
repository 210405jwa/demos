package com.revature.gluecode;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DatatableExampleDefinition {

    @Given("^I am just doing a fake scenario$")
    public void i_am_just_doing_a_fake_scenario() throws Throwable {

    }

    @When("^I provide this data in the form of a table$")
    public void i_provide_this_data_in_the_form_of_a_table(DataTable dataTable) throws Throwable {
    	List<Map<String, String>> maps = dataTable.asMaps();
    	
    	for (Map<String, String> map : maps) {
    		System.out.println(map.get("FirstName"));
    	}
    	
//    	List<List<String>> rows = dataTable.asLists();
//    	for (List<String> row : rows) {
//    		for (String element : row) {
//    			System.out.println(element);
//    		}
//    	}
    }

    @Then("^We're not really going to do anything but print it out$")
    public void were_not_really_going_to_do_anything_but_print_it_out() throws Throwable {

    }
	
}
