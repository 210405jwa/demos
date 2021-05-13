package com.revature.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ShipDAO;
import com.revature.model.Ship;
import com.revature.model.User;
import com.revature.template.ShipTemplate;

@ExtendWith(SpringExtension.class)
@ContextHierarchy({
	@ContextConfiguration("classpath:applicationContext.xml"),
	@ContextConfiguration("classpath:dispatcherContext.xml")
})
@WebAppConfiguration
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class ShipTest {

	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Autowired
	ShipDAO shipDAO;
	
	private MockMvc mockMvc;
	private ObjectMapper objectMapper;
	
	@BeforeEach
	void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		this.objectMapper = new ObjectMapper();
	}
	
	@Test
	@Order(1)
	@Transactional
	@Commit // Or @Rollback(false)
	void testPostShip_andReceiveGoodJsonResponse() throws Exception {
		MockHttpSession session = new MockHttpSession();
		
		User user = new User(1, "user", "pass");
		session.setAttribute("loggedInUser", user);
		
		ShipTemplate shipTemplate = new ShipTemplate("Black Pearl");
		String shipTemplateJson = objectMapper.writeValueAsString(shipTemplate);
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
				.post("/ship")
				.contentType(MediaType.APPLICATION_JSON)
				.content(shipTemplateJson)
				.session(session);
		
		Ship expected = new Ship(1, "Black Pearl");
		String expectedJsonResponse = objectMapper.writeValueAsString(expected);
		
		MvcResult result = this.mockMvc
			.perform(builder)
			.andExpect(MockMvcResultMatchers.status().isCreated())
			.andExpect(MockMvcResultMatchers.content().json(expectedJsonResponse)).andReturn();
		
		System.out.println(result.getResponse().getContentAsString());
	}
	
	@Test
	@Order(2)
	void testShip1ExistsInDB() throws Exception {
		MockHttpSession session = new MockHttpSession();
		
		User user = new User(1, "user", "pass");
		session.setAttribute("loggedInUser", user);
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
				.get("/ship/1")
				.session(session);
		
		Ship ship = new Ship(1, "Black Pearl");
		String shipJson = objectMapper.writeValueAsString(ship);
		
		this.mockMvc
			.perform(builder)
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().json(shipJson));
	}

}
