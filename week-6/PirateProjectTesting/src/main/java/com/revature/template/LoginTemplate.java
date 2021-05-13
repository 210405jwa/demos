package com.revature.template;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class LoginTemplate {
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String password;
	
}
