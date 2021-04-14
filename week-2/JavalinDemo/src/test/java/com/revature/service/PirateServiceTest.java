package com.revature.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.dao.PirateRepository;
import com.revature.exceptions.BadParameterException;
import com.revature.exceptions.PirateNotFoundException;
import com.revature.model.Pirate;

public class PirateServiceTest {

	private static PirateRepository mockPirateRepository;
	
	public PirateService pirateService;
	
	@BeforeClass
	public static void setUp() {
		mockPirateRepository = mock(PirateRepository.class);
		
		// Defining to the mock object what to respond with when it receives a parameter of 1 for int id
		when(mockPirateRepository.getPirateById(eq(1)))
			.thenReturn(new Pirate(1, "Edward", "Thatch"));
		
		when(mockPirateRepository.getPirateById(eq(2)))
			.thenReturn(new Pirate(2, "Peggy", "Pegleg"));
	}
	
	@Before
	public void beforeEachTest() {
		pirateService = new PirateService(mockPirateRepository);
	}
	
	@Test
	public void test_getPirateById_validIdOf1() throws BadParameterException, PirateNotFoundException {
		Pirate actual = pirateService.getPirateById("1");
		
		Pirate expected = new Pirate(1, "Edward", "Thatch");
		
		assertEquals(expected, actual);
	}
	
	@Test(expected=PirateNotFoundException.class)
	public void test_getPirateById_idNotFoundOf3() throws BadParameterException, PirateNotFoundException {
		Pirate actual = pirateService.getPirateById("3");
	}
	
	@Test(expected=BadParameterException.class)
	public void test_getPirateById_idNotFormattedCorrectly() throws BadParameterException, PirateNotFoundException {
		Pirate actual = pirateService.getPirateById("abc");
	}
	
	@Test
	public void test_exceptionMessageFor_getPirateById_idNotFormattedCorrectly() throws PirateNotFoundException {
		try {
			pirateService.getPirateById("abc");
			
			fail("Exception did not occur");
		} catch (BadParameterException e) {
			assertEquals("Pirate id must be an int. User provided abc", e.getMessage());
		}
	}

}
