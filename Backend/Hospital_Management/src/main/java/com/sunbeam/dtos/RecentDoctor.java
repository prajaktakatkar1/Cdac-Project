package com.sunbeam.dtos;

public class RecentDoctor 
{
	private int doctorId;
	private String doctorName;
	private String doctorDepartment;
	private String doctorEmail;
	private String doctorMobile;
	private int status;
	public RecentDoctor() {
		super();
	}
	
	
	



	public RecentDoctor(int doctorId, String doctorName, String doctorDepartment, String doctorEmail,
			String doctorMobile, int status) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorDepartment = doctorDepartment;
		this.doctorEmail = doctorEmail;
		this.doctorMobile = doctorMobile;
		this.status = status;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorDepartment() {
		return doctorDepartment;
	}
	public void setDoctorDepartment(String doctorDepartment) {
		this.doctorDepartment = doctorDepartment;
	}
	public String getDoctorEmail() {
		return doctorEmail;
	}
	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}
	public String getDoctorMobile() {
		return doctorMobile;
	}
	public void setDoctorMobile(String doctorMobile) {
		this.doctorMobile = doctorMobile;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "RecentDoctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorDepartment="
				+ doctorDepartment + ", doctorEmail=" + doctorEmail + ", doctorMobile=" + doctorMobile + ", status="
				+ status + "]";
	}
	
	
	
	
	
	
	
	

}
