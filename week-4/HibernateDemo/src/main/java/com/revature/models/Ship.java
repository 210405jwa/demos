package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "pirate_ship")
@NamedQueries({ @NamedQuery(name = "getPiratesByShipId", query = "SELECT p FROM Pirate p JOIN p.ship s WHERE s.id = :id") })
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Ship {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ship_id")
	private int id;

	@Column(name = "ship_name", length = 50)
	private String shipName;
	
	@OneToMany(mappedBy = "ship", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	//	@JsonManagedReference // This would help resolve infinite looping when serializing to JSON
	// We need the Jackson databind dependency for this annotation, which is the dependency that Javalin depends on for
	// JSON serialization
	private List<Pirate> pirates;
	
	// You shouldn't use CascadeType.ALL unless that is what you really need
	// For example... refer to the ManyToOne mapping the pirate class
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE })
	private ShipDetail shipDetail;
	
	// Technically, we could have a @ManyToOne and a @OneToMany on both tables of the relationship
	// but you will probably run into a lot of issues doing that
	// so, I like to stick with just @ManyToOne instead, such as what I have on the Pirate class
//	@OneToMany
//	private List<Pirate> pirates;

	public Ship() {
		super();
	}

	public Ship(String shipName) {
		super();
		this.shipName = shipName;
	}
	
	// Add our own method to add pirates
	public void addPirate(Pirate pirate) {
		if (pirates == null) {
			pirates = new ArrayList<>();
		}
		
		pirate.setShip(this); // Associates the pirate w/ this particular Ship when adding the pirate to the ship
		pirates.add(pirate);
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

	public ShipDetail getShipDetail() {
		return shipDetail;
	}

	public void setShipDetail(ShipDetail shipDetail) {
		this.shipDetail = shipDetail;
	}

	public List<Pirate> getPirates() {
		return pirates;
	}

	public void setPirates(List<Pirate> pirates) {
		this.pirates = pirates;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((pirates == null) ? 0 : pirates.hashCode());
		result = prime * result + ((shipDetail == null) ? 0 : shipDetail.hashCode());
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
		if (shipDetail == null) {
			if (other.shipDetail != null)
				return false;
		} else if (!shipDetail.equals(other.shipDetail))
			return false;
		if (shipName == null) {
			if (other.shipName != null)
				return false;
		} else if (!shipName.equals(other.shipName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ship [id=" + id + ", shipName=" + shipName + ", pirates=" + pirates + ", shipDetail=" + shipDetail
				+ "]";
	}

}
