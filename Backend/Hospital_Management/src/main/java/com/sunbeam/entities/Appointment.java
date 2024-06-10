package com.sunbeam.entities;

import java.sql.Time;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="appointment")
@Entity
public class Appointment 
{


	@Id
	@Column(name="ap_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appointmentId;
	
	@Column(name="ap_date")
	@Temporal(TemporalType.DATE)
	private Date appointmentDate;
	
	@Column(name="ap_time")
	
	private Time appointmentTime;
	
	@Column(name="p_admitStatus")
	private int patientAdmitStatus;
	
	@Column(name="p_ap_status")
	private int patientAppointmentStatus;
	
	@Column(name="ap_reason")
	private String appointmentReason;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="d_id")
	private Doctor doctor;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="p_id")
	private Patient patient;
	
	@OneToOne(mappedBy = "appointment")
	private Bill bill;

	public Appointment() {
		super();
	}

	public Appointment(int appointmentId, Date appointmentDate, Time appointmentTime, int patientAdmitStatus,
			int patientAppointmentStatus, String appointmentReason, Doctor doctor, Patient patient, Bill bill) {
		super();
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.patientAdmitStatus = patientAdmitStatus;
		this.patientAppointmentStatus = patientAppointmentStatus;
		this.appointmentReason = appointmentReason;
		this.doctor = doctor;
		this.patient = patient;
		this.bill = bill;
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

	public int getPatientAdmitStatus() {
		return patientAdmitStatus;
	}

	public void setPatientAdmitStatus(int patientAdmitStatus) {
		this.patientAdmitStatus = patientAdmitStatus;
	}

	public int getPatientAppointmentStatus() {
		return patientAppointmentStatus;
	}

	public void setPatientAppointmentStatus(int patientAppointmentStatus) {
		this.patientAppointmentStatus = patientAppointmentStatus;
	}

	public String getAppointmentReason() {
		return appointmentReason;
	}

	public void setAppointmentReason(String appointmentReason) {
		this.appointmentReason = appointmentReason;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
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
		return "Appointment [appointmentId=" + appointmentId + ", appointmentDate=" + appointmentDate
				+ ", appointmentTime=" + appointmentTime + ", patientAdmitStatus=" + patientAdmitStatus
				+ ", patientAppointmentStatus=" + patientAppointmentStatus + ", appointmentReason=" + appointmentReason
				+ ", doctor=" + doctor + ", patient=" + patient + ", bill=" + bill + "]";
	}

	
	
	
	
}
