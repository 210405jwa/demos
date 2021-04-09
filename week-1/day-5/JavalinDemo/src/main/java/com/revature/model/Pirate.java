package com.revature.model;

public class Pirate {

	private String name;
	private String shipName;
	private double totalBounties;
	private String role;
	
	public Pirate() {
		super();
	}
	
	public Pirate(String name, String shipName, double totalBounties, String role) {
		this.name = name;
		this.shipName = shipName;
		this.totalBounties = totalBounties;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public double getTotalBounties() {
		return totalBounties;
	}

	public void setTotalBounties(double totalBounties) {
		this.totalBounties = totalBounties;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((shipName == null) ? 0 : shipName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalBounties);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Pirate other = (Pirate) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (shipName == null) {
			if (other.shipName != null)
				return false;
		} else if (!shipName.equals(other.shipName))
			return false;
		if (Double.doubleToLongBits(totalBounties) != Double.doubleToLongBits(other.totalBounties))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pirate [name=" + name + ", shipName=" + shipName + ", totalBounties=" + totalBounties + ", role=" + role
				+ "]";
	}
	
}
