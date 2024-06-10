package com.sunbeam.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="bill")
@Entity
public class Bill {
	

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="bill_id")
	private int billId;
	
	@Column(name="doctor_fees")
	private double doctorFees;
	
	@Column(name="room_duration")
	private int roomDuration;
	
	@OneToOne
	@JoinColumn(name="ap_id")
	private Appointment appointment;
	
	@OneToOne
	@JoinColumn(name="room_id")
	private Room room;

	public Bill() {
		super();
	}

	public Bill(int billId, double doctorFees, int roomDuration) {
		super();
		this.billId = billId;
		this.doctorFees = doctorFees;
		this.roomDuration = roomDuration;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public double getDoctorFees() {
		return doctorFees;
	}

	public void setDoctorFees(double doctorFees) {
		this.doctorFees = doctorFees;
	}

	public int getRoomDuration() {
		return roomDuration;
	}

	public void setRoomDuration(int roomDuration) {
		this.roomDuration = roomDuration;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", doctorFees=" + doctorFees + ", roomDuration=" + roomDuration + "]";
	}

	
	

}
