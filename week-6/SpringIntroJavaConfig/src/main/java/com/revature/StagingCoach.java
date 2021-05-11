package com.revature;

import com.revature.service.IMotivationService;

public class StagingCoach implements Coach {

	private IMotivationService motivateService;
	private String name;
	
	public StagingCoach(IMotivationService motivateService, String name) {
		this.motivateService = motivateService;
		this.name = name;
	}

	@Override
	public String getDailyWorkout() {
		return this.name + " says to practice technical interviewing.";
	}

	@Override
	public String getMotivation() {
		return this.name + " says " + this.motivateService.getMotivation();
	}

}
