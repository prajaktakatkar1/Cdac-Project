package com.sunbeam.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="room")
@Entity
public class Room {
	
	    
	@Id	
	@Column(name="room_id")
	private int roomId;
	@Column(name="room_type")
	private String roomType;
	@Column(name="room_rate")
	private double roomRate;
	@Column(name="room_status")
	private int roomStatus;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="p_id")
	private Patient patient;

	@OneToOne(mappedBy = "room")
	private Bill bill;

	public Room() {
		super();
	}

	public Room(int roomId, String roomType, double roomRate, int roomStatus, Patient patient, Bill bill) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.roomRate = roomRate;
		this.roomStatus = roomStatus;
		this.patient = patient;
		this.bill = bill;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getRoomRate() {
		return roomRate;
	}

	public void setRoomRate(double roomRate) {
		this.roomRate = roomRate;
	}

	public int getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(int roomStatus) {
		this.roomStatus = roomStatus;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomType=" + roomType + ", roomRate=" + roomRate + ", roomStatus="
				+ roomStatus + ", patient=" + patient + ", bill=" + bill + "]";
	}
	
	
	
	

	
	
	
	
	
	
	
	
}
