package com.revature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.revature.service.IMotivationService;

@Component
public class StagingCoach implements Coach {

	@Autowired // This is an example of field injection. Instead of putting @Autowired on our setters
	// or constructor, we put it directly on the field
	// This will set the value using... REFLECTION
	@Qualifier("codingMotivationService") // We don't need this if we only have a single bean
	// of the type IMotivationService. But, we have 2
	private IMotivationService motivateService;
	
	@Value("Jennifer")
	private String name;

	@Override
	public String getDailyWorkout() {
		return this.name + " says to practice technical interviewing.";
	}

	@Override
	public String getMotivation() {
		return this.name + " says " + this.motivateService.getMotivation();
	}

}
