package com.revature.models;

// Notice, I'm not using annotations here. Instead we will provide the configuration in another xml file that is linked to our
// hibernate.cfg.xml file
public class ShipDetail {

	private int id;
	private int capacity;
	private String shipDescription;
	
	public ShipDetail() {
		super();
	}
	
	public ShipDetail(int capacity, String shipDescription) {
		this.capacity = capacity;
		this.shipDescription = shipDescription;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getShipDescription() {
		return shipDescription;
	}

	public void setShipDescription(String shipDescription) {
		this.shipDescription = shipDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacity;
		result = prime * result + id;
		result = prime * result + ((shipDescription == null) ? 0 : shipDescription.hashCode());
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
		ShipDetail other = (ShipDetail) obj;
		if (capacity != other.capacity)
			return false;
		if (id != other.id)
			return false;
		if (shipDescription == null) {
			if (other.shipDescription != null)
				return false;
		} else if (!shipDescription.equals(other.shipDescription))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShipDetail [id=" + id + ", capacity=" + capacity + ", shipDescription=" + shipDescription + "]";
	}
	
}
