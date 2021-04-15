package com.revature.dto;

public class PostShipDTO {

	private String shipName;
	
	public PostShipDTO() {
		super();
	}
	
	public PostShipDTO(String shipName) {
		this.shipName = shipName;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	
}
