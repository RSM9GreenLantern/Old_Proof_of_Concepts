package com.revature.assignforce.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="UNAVAILABILITY")
public class Unavailability {
		
		@Id
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="unavailable")
		@SequenceGenerator(name="unavailable", sequenceName="unavailable_seq", allocationSize=1)
		@Column(name="UNAVAILABLEID")
		private int id;
		
		@Column(name="STARTDATE")
		private Timestamp startDate;
		
		@Column(name="ENDDATE")
		private Timestamp endDate;
		
		@ManyToOne(fetch=FetchType.EAGER)
		@JoinColumn(name="ROOMID")
		private RoomIdHolder roomId;
		
		@ManyToOne(fetch=FetchType.EAGER)
		@JoinColumn(name="TRAINERID")
		private TrainerIdHolder trainerId;

		public Unavailability() {
			super();
		}

		public Unavailability(int id, Timestamp startDate, Timestamp endDate, RoomIdHolder roomId,
				TrainerIdHolder trainerId) {
			super();
			this.id = id;
			this.startDate = startDate;
			this.endDate = endDate;
			this.roomId = roomId;
			this.trainerId = trainerId;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Timestamp getStartDate() {
			return startDate;
		}

		public void setStartDate(Timestamp startDate) {
			this.startDate = startDate;
		}

		public Timestamp getEndDate() {
			return endDate;
		}

		public void setEndDate(Timestamp endDate) {
			this.endDate = endDate;
		}

		public RoomIdHolder getRoomId() {
			return roomId;
		}

		public void setRoomId(RoomIdHolder roomId) {
			this.roomId = roomId;
		}

		public TrainerIdHolder getTrainerId() {
			return trainerId;
		}

		public void setTrainerId(TrainerIdHolder trainerId) {
			this.trainerId = trainerId;
		}
	
		
}
