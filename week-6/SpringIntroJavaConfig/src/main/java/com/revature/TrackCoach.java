package com.revature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.revature.service.IMotivationService;

public class TrackCoach implements Coach {

	private IMotivationService motivateService;

	public TrackCoach(IMotivationService service) {
		System.out.println("TrackCoach: 1-arg Constructor invoked");
		this.motivateService = service;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Today's workout: Run a 30 minute 5k";
	}
	
	public String getMotivation() {
		return "The track coach says: " + motivateService.getMotivation();
	}
	
}
