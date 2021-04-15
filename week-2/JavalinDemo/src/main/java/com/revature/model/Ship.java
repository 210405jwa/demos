package com.revature.model;

import java.util.List;

public class Ship {

	private int id;
	private String shipName;
	private List<Pirate> pirates;
	
	public Ship() {
		super();
	}
	
	public Ship(int id, String shipName) {
		this.id = id;
		this.shipName = shipName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public List<Pirate> getPirates() {
		return pirates;
	}

	public void setPirates(List<Pirate> pirates) {
		this.pirates = pirates;
	}

	@Override
	public String toString() {
		return "Ship [id=" + id + ", shipName=" + shipName + ", pirates=" + pirates + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((pirates == null) ? 0 : pirates.hashCode());
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
		Ship other = (Ship) obj;
		if (id != other.id)
			return false;
		if (pirates == null) {
			if (other.pirates != null)
				return false;
		} else if (!pirates.equals(other.pirates))
			return false;
		if (shipName == null) {
			if (other.shipName != null)
				return false;
		} else if (!shipName.equals(other.shipName))
			return false;
		return true;
	}
 
}
