package com.revature;

import com.revature.service.IMotivationService;

public class CodingCoach implements Coach {

	private IMotivationService motivateService;
	private String name;
	
	// Just a no args constructor for this example, because we'll use setter injection instead
	public CodingCoach() {
		super();
	}
	
	public void setMotivateService(IMotivationService motivateService) {
		System.out.println("CodingCoach: setMotivateService invoked");
		this.motivateService = motivateService;
	}

	public void setName(String name) {
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
