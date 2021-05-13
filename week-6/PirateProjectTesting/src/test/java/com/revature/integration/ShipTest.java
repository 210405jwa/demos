package com.revature.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Ship;
import com.revature.template.ShipTemplate;

@ExtendWith(SpringExtension.class)
@ContextHierarchy({
	@ContextConfiguration("classpath:applicationContext.xml"),
	@ContextConfiguration("classpath:dispatcherContext.xml")
})
@WebAppConfiguration
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ShipTest {

	@Autowired
	WebApplicationContext webApplicationContext;
	
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
	@Commit
	void testPostShip_andReceiveGoodJsonResponse() throws Exception {
		ShipTemplate shipTemplate = new ShipTemplate("Black Pearl");
		String shipTemplateJson = objectMapper.writeValueAsString(shipTemplate);
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
				.post("/ship")
				.contentType(MediaType.APPLICATION_JSON)
				.content(shipTemplateJson);
		
		Ship expected = new Ship(1, "Black Pearl");
		String expectedJsonResponse = objectMapper.writeValueAsString(expected);
		
		this.mockMvc
			.perform(builder)
			.andExpect(MockMvcResultMatchers.status().isCreated())
			.andExpect(MockMvcResultMatchers.content().json(expectedJsonResponse));
	}

}
