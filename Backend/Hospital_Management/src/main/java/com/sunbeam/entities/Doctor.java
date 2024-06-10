package com.sunbeam.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="doctor")
@Entity
public class Doctor {


	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="d_id")
	private int doctorId;
	@Column(name="d_firstName")
	private String doctorFirstName;
	
	@Column(name="d_lastName")
	private String doctorLastName;
	
	@Temporal(TemporalType.DATE)
	@Column(name="d_joinDate")
	private Date doctorJoinDate;
	
	@Column(name="d_email")
	private String doctorEmail;
	@Column(name = "d_password")
	private String doctorPassword;
	@Column(name ="d_contact")
	private String doctorContact;
	@Column(name ="d_qualification")
	private String doctorQualification;
	@Column(name ="d_status")
	private int doctorStatus;
	@Column(name ="d_address")
	private String doctorAddress;
	@Temporal(TemporalType.DATE)
	@Column(name="d_dob")
	private Date doctorDOB;
	@Column(name="d_gender")
	private String doctorGender;
	
	@Column(name="d_otp")
	private String doctorOTP;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name="dept_id")
	private Department doctorDepartment;
	
	
	@OneToMany(mappedBy = "patient")
	private List<Appointment> doctorappointmentList;


	public Doctor() {
		super();
	}


	public Doctor(int doctorId, String doctorFirstName, String doctorLastName, Date doctorJoinDate, String doctorEmail,
			String doctorPassword, String doctorContact, String doctorQualification, int doctorStatus,
			String doctorAddress, Date doctorDOB, String doctorGender, String doctorOTP, Department doctorDepartment,
			List<Appointment> doctorappointmentList) {
		super();
		this.doctorId = doctorId;
		this.doctorFirstName = doctorFirstName;
		this.doctorLastName = doctorLastName;
		this.doctorJoinDate = doctorJoinDate;
		this.doctorEmail = doctorEmail;
		this.doctorPassword = doctorPassword;
		this.doctorContact = doctorContact;
		this.doctorQualification = doctorQualification;
		this.doctorStatus = doctorStatus;
		this.doctorAddress = doctorAddress;
		this.doctorDOB = doctorDOB;
		this.doctorGender = doctorGender;
		this.doctorOTP = doctorOTP;
	this.doctorDepartment = doctorDepartment;
		this.doctorappointmentList = doctorappointmentList;
	}


	public int getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}


	public String getDoctorFirstName() {
		return doctorFirstName;
	}


	public void setDoctorFirstName(String doctorFirstName) {
		this.doctorFirstName = doctorFirstName;
	}


	public String getDoctorLastName() {
		return doctorLastName;
	}


	public void setDoctorLastName(String doctorLastName) {
		this.doctorLastName = doctorLastName;
	}


	public Date getDoctorJoinDate() {
		return doctorJoinDate;
	}


	public void setDoctorJoinDate(Date doctorJoinDate) {
		this.doctorJoinDate = doctorJoinDate;
	}


	public String getDoctorEmail() {
		return doctorEmail;
	}


	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}


	public String getDoctorPassword() {
		return doctorPassword;
	}


	public void setDoctorPassword(String doctorPassword) {
		this.doctorPassword = doctorPassword;
	}


	public String getDoctorContact() {
		return doctorContact;
	}


	public void setDoctorContact(String doctorContact) {
		this.doctorContact = doctorContact;
	}


	public String getDoctorQualification() {
		return doctorQualification;
	}


	public void setDoctorQualification(String doctorQualification) {
		this.doctorQualification = doctorQualification;
	}


	public int getDoctorStatus() {
		return doctorStatus;
	}


	public void setDoctorStatus(int doctorStatus) {
		this.doctorStatus = doctorStatus;
	}


	public String getDoctorAddress() {
		return doctorAddress;
	}


	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}


	public Date getDoctorDOB() {
		return doctorDOB;
	}


	public void setDoctorDOB(Date doctorDOB) {
		this.doctorDOB = doctorDOB;
	}


	public String getDoctorGender() {
		return doctorGender;
	}


	public void setDoctorGender(String doctorGender) {
		this.doctorGender = doctorGender;
	}


	public String getDoctorOTP() {
		return doctorOTP;
	}


	public void setDoctorOTP(String doctorOTP) {
		this.doctorOTP = doctorOTP;
	}


	public Department getDoctorDepartment() {
		return doctorDepartment;
	}


	public void setDoctorDepartment(Department doctorDepartment) {
		this.doctorDepartment = doctorDepartment;
	}


	public List<Appointment> getDoctorappointmentList() {
		return doctorappointmentList;
	}


	public void setDoctorappointmentList(List<Appointment> doctorappointmentList) {
		this.doctorappointmentList = doctorappointmentList;
	}


	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorFirstName=" + doctorFirstName + ", doctorLastName="
				+ doctorLastName + ", doctorJoinDate=" + doctorJoinDate + ", doctorEmail=" + doctorEmail
				+ ", doctorPassword=" + doctorPassword + ", doctorContact=" + doctorContact + ", doctorQualification="
				+ doctorQualification + ", doctorStatus=" + doctorStatus + ", doctorAddress=" + doctorAddress
				+ ", doctorDOB=" + doctorDOB + ", doctorGender=" + doctorGender + ", doctorOTP=" + doctorOTP + "]";
	}


	
	
	
	


	
	

	
	
	
	
}
	
