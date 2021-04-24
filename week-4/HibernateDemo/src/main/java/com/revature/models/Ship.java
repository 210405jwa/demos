package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pirate_ship")
public class Ship {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ship_id")
	private int id;

	@Column(name = "ship_name", length = 50)
	private String shipName;
	
	// Technically, we could have a @ManyToOne and a @OneToMany on both tables of the relationship
	// but you will probably run into a lot of issues doing that
	// so, I like to stick with just @ManyToOne instead, such as what I have on the Pirate class
//	@OneToMany
//	private List<Pirate> pirates;

	public Ship() {
		super();
	}

	public Ship(int id, String shipName) {
		super();
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

	@Override
	public String toString() {
		return "Ship [id=" + id + ", shipName=" + shipName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		if (shipName == null) {
			if (other.shipName != null)
				return false;
		} else if (!shipName.equals(other.shipName))
			return false;
		return true;
	}

}
