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
@Table(name="Buildings")
public class Buildings {

	//Building_ID, Building_Name, Location_ID, Unavailability
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="buildings")
	@SequenceGenerator(name="buildings", sequenceName="buildings_seq", allocationSize=1)
	@Column(name="BUILDING_ID")
	private int building_id;
	
	private String building_name;
	private int location_id;
	private int unavailability_id;

	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<Rooms> rooms;
	
	public Buildings() {
		super();
	}


	/**
	 * 	CONSTRUCTOR
	 */
	public Buildings(int building_id, String building_name, int location_id, int unavailability_id, Set<Rooms> rooms) {
		super();
		this.building_id = building_id;
		this.building_name = building_name;
		this.location_id = location_id;
		this.unavailability_id = unavailability_id;
		this.rooms = rooms;
	}

	
	/**
	 * SETTERS/GETTERS
	 */
	public int getBuilding_id() {
		return building_id;
	}

	public void setBuilding_id(int building_id) {
		this.building_id = building_id;
	}

	public String getBuilding_name() {
		return building_name;
	}

	public void setBuilding_name(String building_name) {
		this.building_name = building_name;
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public int getUnavailability_id() {
		return unavailability_id;
	}

	public void setUnavailability_id(int unavailability_id) {
		this.unavailability_id = unavailability_id;
	}

	public Set<Rooms> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Rooms> rooms) {
		this.rooms = rooms;
	}
	
}
