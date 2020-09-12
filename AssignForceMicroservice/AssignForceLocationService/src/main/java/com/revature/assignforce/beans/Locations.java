package com.revature.assignforce.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Location")
public class Locations {

	//Location_ID, Location_Name, Unavailability_ID

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="locations")
	@SequenceGenerator(name="locations", sequenceName="locations_seq", allocationSize=1)
	@Column(name="LOCATION_ID")
	private int location_id;
	
	private String location_name;
	private int unavailability_id;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<Buildings> buildings;
	
	public Locations() {
		
	}	

	/**
	 * 	CONSTRUCTOR
	 */
	public Locations(int location_id, String location_name, int unavailability_id, Set<Buildings> buildings) {
		super();
		this.location_id = location_id;
		this.location_name = location_name;
		this.unavailability_id = unavailability_id;
		this.buildings = buildings;
	}


	/**
	 * SETTERS/GETTERS
	 */
	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public String getLocation_name() {
		return location_name;
	}

	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}

	public int getUnavailability_id() {
		return unavailability_id;
	}

	public void setUnavailability_id(int unavailability_id) {
		this.unavailability_id = unavailability_id;
	}

	public Set<Buildings> getBuildings() {
		return buildings;
	}

	public void setBuildings(Set<Buildings> buildings) {
		this.buildings = buildings;
	}
}
