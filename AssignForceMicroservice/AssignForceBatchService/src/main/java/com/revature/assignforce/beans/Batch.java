package com.revature.assignforce.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Batch")
public class Batch {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Batch_ID")
	@SequenceGenerator(name="Batch_ID", sequenceName="Batch_ID_seq", allocationSize=1)
	@Column(name="Batch_ID")
	private int id;

	@Column(name="Batch_Name")
	private String name;
	
	@Column(name="start_Date")
	private Date startDate;
	
	@Column(name="end_Date")
	private Date endDate;
	
	@Column(name="Curriculum_Id")
	private int curriculum;
	
	@Column(name="Trainer_Id")
	private int trainer;
	
	@Column(name="Cotrainer_Id")
	private int cotrainer;
	
	@Column(name="Room_Id")
	private int room;
	
	
	public Batch() {
		super();
	}

	public Batch(int id, String batchName, int trainerId, int cotrainerId, int curriculumId, int roomId, Date startDate,
			Date endDate) {
		super();
		this.id = id;
		name = batchName;
		trainer = trainerId;
		cotrainer = cotrainerId;
		curriculum = curriculumId;
		room = roomId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Batch(String batchName, int trainerId, int cotrainerId, int curriculumId, int roomId, Date startDate,
			Date endDate) {
		super();
		name = batchName;
		trainer = trainerId;
		cotrainer = cotrainerId;
		curriculum = curriculumId;
		room = roomId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBatchName() {
		return name;
	}

	public void setBatchName(String batchName) {
		name = batchName;
	}

	public int getTrainerId() {
		return trainer;
	}

	public void setTrainerId(int trainerId) {
		trainer = trainerId;
	}

	public int getCotrainerId() {
		return cotrainer;
	}

	public void setCotrainerId(int cotrainerId) {
		cotrainer = cotrainerId;
	}

	public int getCurriculumId() {
		return curriculum;
	}

	public void setCurriculumId(int curriculumId) {
		curriculum = curriculumId;
	}

	public int getRoomId() {
		return room;
	}

	public void setRoomId(int roomId) {
		room = roomId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	
	
}
