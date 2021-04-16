package com.revature.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.eq;

import java.sql.Connection;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.MockedStatic;

import com.revature.dao.PirateRepository;
import com.revature.dto.PostPirateDTO;
import com.revature.exceptions.AddPirateException;
import com.revature.exceptions.BadParameterException;
import com.revature.exceptions.DatabaseException;
import com.revature.model.Pirate;
import com.revature.util.ConnectionUtil;

public class PirateServiceTest {

	private static PirateRepository mockPirateRepository;
	private static Connection mockConnection;
	
	private PirateService pirateService;
	
	@BeforeClass
	public static void setUp() throws DatabaseException {
		mockPirateRepository = mock(PirateRepository.class);
		mockConnection = mock(Connection.class);
		
		when(mockPirateRepository.addPirate(eq(1), eq(new PostPirateDTO("Edward", "Thatch"))))
				.thenReturn(new Pirate(1, "Edward", "Thatch"));
	}
	
	@Before
	public void beforeTest() {
		pirateService = new PirateService(mockPirateRepository);
	}
	
	@Test
	public void test_happyPath() throws BadParameterException, DatabaseException, AddPirateException {
		
		// try-with resources
		// Syntactic sugar for creating some sort of object, in this case, mockedConnectionUtil
		// and then calling .close() on that object whenever the block of code is finished
		try(MockedStatic<ConnectionUtil> mockedConnectionUtil = mockStatic(ConnectionUtil.class)) {
			mockedConnectionUtil.when(ConnectionUtil::getConnection).thenReturn(mockConnection);
			
			Pirate actual = pirateService.addPirate("1", new PostPirateDTO("Edward", "Thatch"));
			
			Pirate expected = new Pirate(1, "Edward", "Thatch");
			
			assertEquals(expected, actual);
		}
		
	}
	
	@Test
	public void test_blankLastName_blankFirstName_bothWithoutSpaces() throws BadParameterException, DatabaseException {
		
		// We are mocking the static method getConnection, because we don't actually want to execute the real
		// Method. If we actually execute the real method, that would mean we are contacting the actual database
		// If our test environment does not have access to the real database, then we would enter into a SQLException
		// situation for our tests, which will not be great
		try(MockedStatic<ConnectionUtil> mockedConnectionUtil = mockStatic(ConnectionUtil.class)) {
			mockedConnectionUtil.when(ConnectionUtil::getConnection).thenReturn(mockConnection);
			
			try {
				pirateService.addPirate("1", new PostPirateDTO("", ""));
				fail("AddPirateException was not thrown");
			} catch (AddPirateException e) {
				assertEquals(e.getMessage(), "Pirate first/last names cannot be blank");
			}
			
		}
		
	}
	
	@Test
	public void test_blankLastName_blankFirstName_bothWithSpaces() throws BadParameterException, DatabaseException {
		
		// We are mocking the static method getConnection, because we don't actually want to execute the real
		// Method. If we actually execute the real method, that would mean we are contacting the actual database
		// If our test environment does not have access to the real database, then we would enter into a SQLException
		// situation for our tests, which will not be great
		try(MockedStatic<ConnectionUtil> mockedConnectionUtil = mockStatic(ConnectionUtil.class)) {
			mockedConnectionUtil.when(ConnectionUtil::getConnection).thenReturn(mockConnection);
			
			try {
				pirateService.addPirate("1", new PostPirateDTO("   ", "     "));
				fail("AddPirateException was not thrown");
			} catch (AddPirateException e) {
				assertEquals(e.getMessage(), "Pirate first/last names cannot be blank");
			}
			
		}
		
	}
	
	@Test
	public void test_blankLastName_blankFirstName_lastNameWithSpaces_firstNameWithout() throws BadParameterException, DatabaseException {
		
		// We are mocking the static method getConnection, because we don't actually want to execute the real
		// Method. If we actually execute the real method, that would mean we are contacting the actual database
		// If our test environment does not have access to the real database, then we would enter into a SQLException
		// situation for our tests, which will not be great
		try(MockedStatic<ConnectionUtil> mockedConnectionUtil = mockStatic(ConnectionUtil.class)) {
			mockedConnectionUtil.when(ConnectionUtil::getConnection).thenReturn(mockConnection);
			
			try {
				pirateService.addPirate("1", new PostPirateDTO("", "     "));
				fail("AddPirateException was not thrown");
			} catch (AddPirateException e) {
				assertEquals(e.getMessage(), "Pirate first/last names cannot be blank");
			}
			
		}
		
	}
	
	@Test
	public void test_blankLastName_blankFirstName_lastNameWithoutSpaces_firstNameWith() throws BadParameterException, DatabaseException {
		
		// We are mocking the static method getConnection, because we don't actually want to execute the real
		// Method. If we actually execute the real method, that would mean we are contacting the actual database
		// If our test environment does not have access to the real database, then we would enter into a SQLException
		// situation for our tests, which will not be great
		try(MockedStatic<ConnectionUtil> mockedConnectionUtil = mockStatic(ConnectionUtil.class)) {
			mockedConnectionUtil.when(ConnectionUtil::getConnection).thenReturn(mockConnection);
			
			try {
				pirateService.addPirate("1", new PostPirateDTO("     ", ""));
				fail("AddPirateException was not thrown");
			} catch (AddPirateException e) {
				assertEquals(e.getMessage(), "Pirate first/last names cannot be blank");
			}
			
		}
		
	}
	
	@Test
	public void test_blankLastNameWithoutSpaces_NonBlankFirstName() throws BadParameterException, DatabaseException {
		
		// We are mocking the static method getConnection, because we don't actually want to execute the real
		// Method. If we actually execute the real method, that would mean we are contacting the actual database
		// If our test environment does not have access to the real database, then we would enter into a SQLException
		// situation for our tests, which will not be great
		try(MockedStatic<ConnectionUtil> mockedConnectionUtil = mockStatic(ConnectionUtil.class)) {
			mockedConnectionUtil.when(ConnectionUtil::getConnection).thenReturn(mockConnection);
			
			try {
				pirateService.addPirate("1", new PostPirateDTO("Edward", ""));
				fail("AddPirateException was not thrown");
			} catch (AddPirateException e) {
				assertEquals(e.getMessage(), "Pirate first/last names cannot be blank");
			}
			
		}
		
	}
	
	@Test
	public void test_blankLastNameWithSpaces_NonBlankFirstName() throws BadParameterException, DatabaseException {
		
		// We are mocking the static method getConnection, because we don't actually want to execute the real
		// Method. If we actually execute the real method, that would mean we are contacting the actual database
		// If our test environment does not have access to the real database, then we would enter into a SQLException
		// situation for our tests, which will not be great
		try(MockedStatic<ConnectionUtil> mockedConnectionUtil = mockStatic(ConnectionUtil.class)) {
			mockedConnectionUtil.when(ConnectionUtil::getConnection).thenReturn(mockConnection);
			
			try {
				pirateService.addPirate("1", new PostPirateDTO("Edward", "              "));
				fail("AddPirateException was not thrown");
			} catch (AddPirateException e) {
				assertEquals(e.getMessage(), "Pirate first/last names cannot be blank");
			}
			
		}
		
	}
	
	@Test
	public void test_NonBlankLastName_BlankFirstNameWithoutSpaces() throws BadParameterException, DatabaseException {
		
		// We are mocking the static method getConnection, because we don't actually want to execute the real
		// Method. If we actually execute the real method, that would mean we are contacting the actual database
		// If our test environment does not have access to the real database, then we would enter into a SQLException
		// situation for our tests, which will not be great
		try(MockedStatic<ConnectionUtil> mockedConnectionUtil = mockStatic(ConnectionUtil.class)) {
			mockedConnectionUtil.when(ConnectionUtil::getConnection).thenReturn(mockConnection);
			
			try {
				pirateService.addPirate("1", new PostPirateDTO("", "Thatch"));
				fail("AddPirateException was not thrown");
			} catch (AddPirateException e) {
				assertEquals(e.getMessage(), "Pirate first/last names cannot be blank");
			}
			
		}
		
	}
	
	@Test
	public void test_NonBlankLastName_BlankFirstNameWithSpaces() throws BadParameterException, DatabaseException {
		
		// We are mocking the static method getConnection, because we don't actually want to execute the real
		// Method. If we actually execute the real method, that would mean we are contacting the actual database
		// If our test environment does not have access to the real database, then we would enter into a SQLException
		// situation for our tests, which will not be great
		try(MockedStatic<ConnectionUtil> mockedConnectionUtil = mockStatic(ConnectionUtil.class)) {
			mockedConnectionUtil.when(ConnectionUtil::getConnection).thenReturn(mockConnection);
			
			try {
				pirateService.addPirate("1", new PostPirateDTO("      ", "Thatch"));
				fail("AddPirateException was not thrown");
			} catch (AddPirateException e) {
				assertEquals(e.getMessage(), "Pirate first/last names cannot be blank");
			}
			
		}
		
	}
	
	@Test
	public void test_nonIntegerShipId() throws DatabaseException, AddPirateException {
		try(MockedStatic<ConnectionUtil> mockedConnectionUtil = mockStatic(ConnectionUtil.class)) {
			mockedConnectionUtil.when(ConnectionUtil::getConnection).thenReturn(mockConnection);
			
			try {
				pirateService.addPirate("abc", new PostPirateDTO("Edward", "Thatch"));
				fail("BadParameterException was not thrown");
			} catch (BadParameterException e) {
				assertEquals(e.getMessage(), "Ship id must be an int. User provided " + "abc");
			}
			
		}
	}

}
