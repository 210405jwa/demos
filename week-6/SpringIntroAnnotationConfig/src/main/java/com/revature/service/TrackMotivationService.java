package com.revature.service;

import org.springframework.stereotype.Service;

@Service
public class TrackMotivationService implements IMotivationService {

	@Override
	public String getMotivation() {
		return "Move it, maggot";
	}

}
