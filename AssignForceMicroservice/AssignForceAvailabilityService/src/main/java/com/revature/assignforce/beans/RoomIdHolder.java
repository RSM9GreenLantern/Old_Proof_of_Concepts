package com.revature.assignforce.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="ROOMIDHOLDER")
public class RoomIdHolder {
	
	@Id
	@Column(name="ROOMID")
	private int roomId;

	public RoomIdHolder() {
		super();
	}

	public RoomIdHolder(int roomId) {
		super();
		this.roomId = roomId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	
}
