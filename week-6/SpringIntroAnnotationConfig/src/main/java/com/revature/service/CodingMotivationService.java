package com.revature.service;

import org.springframework.stereotype.Service;

// We could do @Component here, but to be more specific, we'll use @Service
@Service
public class CodingMotivationService implements IMotivationService {

	@Override
	public String getMotivation() {
		return "Look into it";
	}

}
