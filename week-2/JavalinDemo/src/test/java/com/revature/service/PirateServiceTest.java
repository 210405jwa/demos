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
	
	

}
