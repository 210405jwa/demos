package com.revature.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.revature.Coach;
import com.revature.CodingCoach;
import com.revature.StagingCoach;
import com.revature.TrackCoach;
import com.revature.service.CodingMotivationService;
import com.revature.service.IMotivationService;
import com.revature.service.TrackMotivationService;

@Configuration // This tells Spring that this is a special bean that should be instantiated, that provides
// configuration for other beans
@PropertySource("classpath:myproperties.properties")
public class MyBeanConfig {

	@Bean
	public IMotivationService myTrackMotivationService() {
		return new TrackMotivationService();
	}
	
	@Bean
	public IMotivationService myCodingMotivationService() {
		return new CodingMotivationService();
	}
	
	@Bean
	public Coach trackCoach() {
		return new TrackCoach(myTrackMotivationService());
	}
	
	@Bean
	public Coach codingCoach() {
		
		// An advantage of Java based configuration such as this, is that you can create an object
		// Do some configuration on it
		// and then have that object returned as a bean to be stored in the IoC container
		CodingCoach coach = new CodingCoach();
		coach.setMotivateService(myCodingMotivationService());
		coach.setName("Bach");
		
		return coach;
	}
	
	@Bean
	public Coach stagingCoach() {
		return new StagingCoach(myCodingMotivationService(), "Jennifer");
	}
	
}
