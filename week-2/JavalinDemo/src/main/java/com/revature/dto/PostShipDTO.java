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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((shipName == null) ? 0 : shipName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostShipDTO other = (PostShipDTO) obj;
		if (shipName == null) {
			if (other.shipName != null)
				return false;
		} else if (!shipName.equals(other.shipName))
			return false;
		return true;
	}
	
}
