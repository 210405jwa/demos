package com.revature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.revature.service.IMotivationService;

@Component // Component is just a name for a "general" spring bean
// We also have annotations such as @Service, @Repository, @Controller
// For other beans
public class CodingCoach implements Coach {

	private IMotivationService motivateService;
	private String name;
	
	// Just a no args constructor for this example, because we'll use setter injection instead
	public CodingCoach() {
		super();
	}
	
	@Autowired
	// Setter injection using AutoWired
	public void setMotivateService(@Qualifier("codingMotivationService") IMotivationService motivateService) {
		System.out.println("CodingCoach: setMotivateService invoked");
		this.motivateService = motivateService;
	}

	// Injecting strings or primitives using @Value
	@Autowired
	public void setName(@Value("${coach.name}") String name) {
		System.out.println("CodingCoach: setName invoked");
		this.name = name;
	}

	@Override
	public String getDailyWorkout() {
		return this.name + " says: Do 100 coding challenges today";
	}

	@Override
	public String getMotivation() {
		return this.name + " says: " +  motivateService.getMotivation();
	}

}
