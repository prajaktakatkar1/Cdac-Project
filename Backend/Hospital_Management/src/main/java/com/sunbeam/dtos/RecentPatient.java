package com.sunbeam.dtos;

public class RecentPatient {
	
	private String patientFirstName;
	private String patientAppointmentReason;
	private String patientContact;
	private String patientAddress;
	private int patientAppointmentStatus;
	public RecentPatient() {
		super();
	}
	public RecentPatient(String patientFirstName, String patientAppointmentReason, String patientContact,
			String patientAddress, int patientAppointmentStatus) {
		super();
		this.patientFirstName = patientFirstName;
		this.patientAppointmentReason = patientAppointmentReason;
		this.patientContact = patientContact;
		this.patientAddress = patientAddress;
		this.patientAppointmentStatus = patientAppointmentStatus;
	}
	public String getPatientFirstName() {
		return patientFirstName;
	}
	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}
	public String getPatientAppointmentReason() {
		return patientAppointmentReason;
	}
	public void setPatientAppointmentReason(String patientAppointmentReason) {
		this.patientAppointmentReason = patientAppointmentReason;
	}
	public String getPatientContact() {
		return patientContact;
	}
	public void setPatientContact(String patientContact) {
		this.patientContact = patientContact;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	public int getPatientAppointmentStatus() {
		return patientAppointmentStatus;
	}
	public void setPatientAppointmentStatus(int patientAppointmentStatus) {
		this.patientAppointmentStatus = patientAppointmentStatus;
	}
	@Override
	public String toString() {
		return "RecentPatient [patientFirstName=" + patientFirstName + ", patientAppointmentReason="
				+ patientAppointmentReason + ", patientContact=" + patientContact + ", patientAddress=" + patientAddress
				+ ", patientAppointmentStatus=" + patientAppointmentStatus + "]";
	}
	
	
	
	
	

}
