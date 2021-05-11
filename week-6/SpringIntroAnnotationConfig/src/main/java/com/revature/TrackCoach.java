package com.revature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.revature.service.IMotivationService;

@Component
public class TrackCoach implements Coach {

	private IMotivationService motivateService;

	// @Autowired will tell Spring to figure out what bean to inject into this constructor
	// It will see that this bean when it is instantiated, requires an IMotivationService bean
	// So if there is only 1 single IMotivationService bean, it will use that one
	// In our example here, we have 2 IMotivationServices, so we need to explicitly tell Spring
	// Which IMotivationService should be injected
	@Autowired
	public TrackCoach(@Qualifier("trackMotivationService") IMotivationService service) {
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
