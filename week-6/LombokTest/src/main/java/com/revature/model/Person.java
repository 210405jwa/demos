package com.revature.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter @Setter @NoArgsConstructor @ToString @EqualsAndHashCode
// Could also use @Data
@Data @AllArgsConstructor @NoArgsConstructor
public class Person {

	private String name;
	private int age;
	
}
