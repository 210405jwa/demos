package com.revature.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.entity.Ship;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Integer> {

	public Optional<Ship> findByShipName(String shipName);
	
	public List<Ship> findByPriceGreaterThan(int greaterThan);
	
	public Ship findByShipNameStartingWith(String startsWith);
	
}
