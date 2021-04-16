package com.revature.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.any;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.dao.ShipRepository;
import com.revature.dto.PostShipDTO;
import com.revature.exceptions.AddShipException;
import com.revature.exceptions.DatabaseException;
import com.revature.model.Ship;

public class ShipServiceTest {

	// Fake repository dependency (mocked w/ Mockito)
	private static ShipRepository mockShipRepository;
	
	// The system under test, our ShipService instance
	private ShipService shipService;
	
	@BeforeClass
	public static void setUp() throws DatabaseException, AddShipException {
		mockShipRepository = mock(ShipRepository.class);
		
		// Blue Pearl does not exist, so this method should return null
		when(mockShipRepository.getShipByName(eq("Blue Pearl"))).thenReturn(null);
		
		
		Ship bluePearl = new Ship(2, "Blue Pearl");
		bluePearl.setPirates(new ArrayList<>());
		when(mockShipRepository.addShip(new PostShipDTO("Blue Pearl"))).thenReturn(bluePearl);
		
		// Ship that does exist, Black Pearl, with no pirates
		Ship blackPearl = new Ship(1, "Black Pearl");
		blackPearl.setPirates(new ArrayList<>());
		when(mockShipRepository.getShipByName(eq("Black Pearl"))).thenReturn(blackPearl);
	}
	
	@Before
	public void beforeTest() {
		shipService = new ShipService(mockShipRepository); // Before each test, instantiate a new ship service,
		// passing in our fake ship repository object
	}
	
	@Test /*(expected = AddShipException.class)*/
	public void test_shipAlreadyExists() throws DatabaseException, AddShipException {
		try {
			shipService.addShip(new PostShipDTO("Black Pearl"));
			fail("AddShipException did not happen");
		} catch(AddShipException e) {
			assertEquals(e.getMessage(), "User tried to add a ship that already exists with that name");
		}
	}

	@Test
	public void test_shipDoesNotAlreadyExist() throws DatabaseException, AddShipException {
		Ship actual = shipService.addShip(new PostShipDTO("Blue Pearl"));
		Ship expected = new Ship(2, "Blue Pearl");
		expected.setPirates(new ArrayList<>());
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_blankNameForShip() throws DatabaseException {
		PostShipDTO blankNameDTO = new PostShipDTO("");
		try {
			shipService.addShip(blankNameDTO);
			fail("Add ship exception did not occur");
		} catch (AddShipException e) {
			assertEquals(e.getMessage(), "User tried to add a ship with a blank name");
		}
	}
	
	@Test
	public void test_blankNameWithSpacesForShip() throws DatabaseException {
		PostShipDTO blankNameDTO = new PostShipDTO("           ");
		try {
			shipService.addShip(blankNameDTO);
			fail("Add ship exception did not occur");
		} catch (AddShipException e) {
			assertEquals(e.getMessage(), "User tried to add a ship with a blank name");
		}
	}
}
