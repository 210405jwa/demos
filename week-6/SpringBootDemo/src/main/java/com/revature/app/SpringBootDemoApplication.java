package com.revature.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.revature.dao.ShipRepository;
import com.revature.entity.Ship;
import com.revature.service.ShipService;

@SpringBootApplication
@ComponentScan("com.revature")
@EntityScan("com.revature.entity")
@EnableJpaRepositories("com.revature.dao")
public class SpringBootDemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
	
	@Autowired
	private ShipService shipService;
	
	@Autowired
	private ShipRepository shipRepository;
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				List<Ship> ships = shipService.getShipsByPriceGreaterThan(2000);
				System.out.println(ships);
				
				System.out.println(shipRepository.findByShipNameStartingWith("Blac"));
				
				shipService.updatePriceOfShipById(1, 200000);
			}
		};
	}
	
}
