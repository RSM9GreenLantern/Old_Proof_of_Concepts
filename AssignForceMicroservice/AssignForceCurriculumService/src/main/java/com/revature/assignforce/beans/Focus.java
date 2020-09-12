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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="Focus")
public class Focus {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="focus")
	@SequenceGenerator(name="focus", sequenceName="focus_seq", allocationSize=1)
	@Column(name="FOCUS_ID")
	private int focusId;
	
	private String name;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="FOCUS_SKILLS",
	joinColumns=@JoinColumn(name="FOCUS_ID"),
	inverseJoinColumns=@JoinColumn(name="SKILL_ID"))
	private Set<Skills> focus_skills;

	public Focus() {
		super();
	}

	

	public Focus(int focusId, String name, Set<Skills> focus_skills) {
		super();
		this.focusId = focusId;
		this.name = name;
		this.focus_skills = focus_skills;
	}



	public int getFocusId() {
		return focusId;
	}



	public void setFocusId(int focusId) {
		this.focusId = focusId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Set<Skills> getFocus_skills() {
		return focus_skills;
	}



	public void setFocus_skills(Set<Skills> focus_skills) {
		this.focus_skills = focus_skills;
	}



	
	
	
	
}
