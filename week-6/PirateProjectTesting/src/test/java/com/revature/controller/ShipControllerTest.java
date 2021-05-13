package com.revature.controller;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exception.ShipNotFoundException;
import com.revature.model.Ship;
import com.revature.services.ShipService;

@ExtendWith(MockitoExtension.class)
public class ShipControllerTest {
	
	// You might need to select inside of your IDE the JDK instead of a JRE
	// for this to run properly
	// Right click on the JRE system library in Package Explorer, then go to properties,
	// and locate the JDK installation on your machine
	// Then change the usage over to that
	
	MockMvc mockMvc;
	
	@Mock
	ShipService shipService;
	
	@InjectMocks // Since we don't have a constructor or setter for the ShipService dependency
	// inside of ShipController, it will utilize Reflection to do "field injection"
	// of the mock ShipService. This avoids us having to create an unnecessary Constructor
	// just for injecting a mock dependency
	ShipController sc;
	
	@BeforeEach
	void setup() throws ShipNotFoundException {				
		when(shipService.getShipById(eq(1))).thenReturn(new Ship(1, "Queen Anne's Revenge"));
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(sc).build();
	}
	
	@Test
	void testGetShipById1_success() throws Exception {
		Ship expectedShip = new Ship(1, "Queen Anne's Revenge");
		ObjectMapper om = new ObjectMapper();
		String expectedShipJson = om.writeValueAsString(expectedShip);
		
		this.mockMvc
			.perform(get("/ship/1"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().json(expectedShipJson));
		
	}

}
