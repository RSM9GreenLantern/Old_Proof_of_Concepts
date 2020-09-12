package com.revature.assignforce.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TRAINER")
public class Trainer {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="trainer")
	@SequenceGenerator(name="trainer", sequenceName="trainer_seq", allocationSize=1)
	@Column(name="TRAINER_ID")
	private int id;

	private String prefLocation;
	private String fName;
	private String lName;
	private int unavailible;

	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="CERT_TRAINERS",
			joinColumns=@JoinColumn(name="TRAINER_ID"),
			inverseJoinColumns=@JoinColumn(name="CERT_ID"))
	private Set<Cert> certs;

	public Trainer() {
		
	}

	public Trainer(int id, String prefLocation, String fName, String lName, int unavailible, Set<Cert> certs) {
		super();
		this.id = id;
		this.prefLocation = prefLocation;
		this.fName = fName;
		this.lName = lName;
		this.unavailible = unavailible;
		this.certs = certs;
	}

	public Trainer(String prefLocation, String fName, String lName, int unavailible, Set<Cert> certs) {
		super();
		this.prefLocation = prefLocation;
		this.fName = fName;
		this.lName = lName;
		this.unavailible = unavailible;
		this.certs = certs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrefLocation() {
		return prefLocation;
	}

	public void setPrefLocation(String prefLocation) {
		this.prefLocation = prefLocation;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getUnavailible() {
		return unavailible;
	}

	public void setUnavailible(int unavailible) {
		this.unavailible = unavailible;
	}

	public Set<Cert> getCerts() {
		return certs;
	}

	public void setCerts(Set<Cert> certs) {
		this.certs = certs;
	}
	
	



}
