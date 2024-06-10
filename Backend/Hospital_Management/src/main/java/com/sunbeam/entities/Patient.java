package com.sunbeam.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="patient")
@Entity
public class Patient {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="p_id")
	private int patientId;
	@Column(name="p_firstName")
	private String patientFirstName;
	
	@Column(name="p_lastName")
	private String patientLastName;
	@Column(name="p_email")
	private String patientEmail;
	@Column(name="p_password")
	private String patientPassword;
	@Column(name="p_contact")
	private String patientContact;
	@Column(name="p_gender")
	private String patientGender;
	@Column(name="p_dob")
	@Temporal(TemporalType.DATE)
	private Date patientDOB;
	@Column(name="p_bloodGroup")
	private String patientBloodGroup;
	@Column(name="p_address")
	private String patientAddress;
	
	@Column(name="p_otp")
	private String patientOTP;
	
	@OneToMany(mappedBy = "patient")
	private List<Room> roomList;
	
	@OneToMany(mappedBy = "patient")
	private List<Appointment> patientAppointmentList;
	
	
	
	@OneToMany(mappedBy = "patient")
	private List<Prescription> patientPrescriptionList;



	public Patient() {
		super();
	}



	public Patient(int patientId, String patientFirstName, String patientLastName, String patientEmail,
			String patientPassword, String patientContact, String patientGender, Date patientDOB,
			String patientBloodGroup, String patientAddress, String patientOTP, List<Room> roomList,
			List<Appointment> patientAppointmentList, List<Prescription> patientPrescriptionList) {
		super();
		this.patientId = patientId;
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		this.patientEmail = patientEmail;
		this.patientPassword = patientPassword;
		this.patientContact = patientContact;
		this.patientGender = patientGender;
		this.patientDOB = patientDOB;
		this.patientBloodGroup = patientBloodGroup;
		this.patientAddress = patientAddress;
		this.patientOTP = patientOTP;
		this.roomList = roomList;
		this.patientAppointmentList = patientAppointmentList;
		this.patientPrescriptionList = patientPrescriptionList;
	}



	public int getPatientId() {
		return patientId;
	}



	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}



	public String getPatientFirstName() {
		return patientFirstName;
	}



	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}



	public String getPatientLastName() {
		return patientLastName;
	}



	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}



	public String getPatientEmail() {
		return patientEmail;
	}



	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}



	public String getPatientPassword() {
		return patientPassword;
	}



	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}



	public String getPatientContact() {
		return patientContact;
	}



	public void setPatientContact(String patientContact) {
		this.patientContact = patientContact;
	}



	public String getPatientGender() {
		return patientGender;
	}



	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}



	public Date getPatientDOB() {
		return patientDOB;
	}



	public void setPatientDOB(Date patientDOB) {
		this.patientDOB = patientDOB;
	}



	public String getPatientBloodGroup() {
		return patientBloodGroup;
	}



	public void setPatientBloodGroup(String patientBloodGroup) {
		this.patientBloodGroup = patientBloodGroup;
	}



	public String getPatientAddress() {
		return patientAddress;
	}



	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}



	public String getPatientOTP() {
		return patientOTP;
	}



	public void setPatientOTP(String patientOTP) {
		this.patientOTP = patientOTP;
	}



	public List<Room> getRoomList() {
		return roomList;
	}



	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}



	public List<Appointment> getPatientAppointmentList() {
		return patientAppointmentList;
	}



	public void setPatientAppointmentList(List<Appointment> patientAppointmentList) {
		this.patientAppointmentList = patientAppointmentList;
	}



	public List<Prescription> getPatientPrescriptionList() {
		return patientPrescriptionList;
	}



	public void setPatientPrescriptionList(List<Prescription> patientPrescriptionList) {
		this.patientPrescriptionList = patientPrescriptionList;
	}



	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientFirstName=" + patientFirstName + ", patientLastName="
				+ patientLastName + ", patientEmail=" + patientEmail + ", patientPassword=" + patientPassword
				+ ", patientContact=" + patientContact + ", patientGender=" + patientGender + ", patientDOB="
				+ patientDOB + ", patientBloodGroup=" + patientBloodGroup + ", patientAddress=" + patientAddress
				+ ", patientOTP=" + patientOTP + ", roomList=" + roomList + "]";
	}


	
	


	
	
	

}
