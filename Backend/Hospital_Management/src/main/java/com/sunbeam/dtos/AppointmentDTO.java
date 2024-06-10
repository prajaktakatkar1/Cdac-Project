package com.sunbeam.dtos;

import java.sql.Time;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sunbeam.entities.Bill;
import com.sunbeam.entities.Department;
import com.sunbeam.entities.Doctor;
import com.sunbeam.entities.Patient;

public class AppointmentDTO {


	
	private int appointmentId;
	private Date appointmentDate;
	private Time appointmentTime;
	private String appointmentReason;
	private int doctorId;
	private int patientId;
	public AppointmentDTO() {
		super();
	}
	public AppointmentDTO(int appointmentId, Date appointmentDate, Time appointmentTime, String appointmentReason,
			int doctorId, int patientId) {
		super();
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.appointmentReason = appointmentReason;
		this.doctorId = doctorId;
		this.patientId = patientId;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public Time getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(Time appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public String getAppointmentReason() {
		return appointmentReason;
	}
	public void setAppointmentReason(String appointmentReason) {
		this.appointmentReason = appointmentReason;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	@Override
	public String toString() {
		return "AppointmentDTO [appointmentId=" + appointmentId + ", appointmentDate=" + appointmentDate
				+ ", appointmentTime=" + appointmentTime + ", appointmentReason=" + appointmentReason + ", doctorId="
				+ doctorId + ", patientId=" + patientId + "]";
	}
	
	

	
	
	
	
	
	
}
