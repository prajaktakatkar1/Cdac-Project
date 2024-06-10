package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="admin")
public class Admin {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="a_id")
	private int adminId;
	@Column(name="a_firstName")
	private String adminFirstName;
	
	@Column(name="a_lastName")
	private String adminLastName;
	@Column(name="a_email")
	private String adminEmail;
	@Column(name="a_password")
	private String password;
	
	
	@Column(name="a_otp")
	private String adminOTP;
	@Column(name="a_contact")
	private String adminContact;
	public Admin() {
		super();
	}
	public Admin(int adminId, String adminFirstName, String adminLastName, String adminEmail, String password,
			String adminOTP, String adminContact) {
		super();
		this.adminId = adminId;
		this.adminFirstName = adminFirstName;
		this.adminLastName = adminLastName;
		this.adminEmail = adminEmail;
		this.password = password;
		this.adminOTP = adminOTP;
		this.adminContact = adminContact;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminFirstName() {
		return adminFirstName;
	}
	public void setAdminFirstName(String adminFirstName) 
	{
		this.adminFirstName = adminFirstName;
	}
	public String getAdminLastName() {
		return adminLastName;
	}
	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdminOTP() {
		return adminOTP;
	}
	public void setAdminOTP(String adminOTP) {
		this.adminOTP = adminOTP;
	}
	public String getAdminContact() {
		return adminContact;
	}
	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminFirstName=" + adminFirstName + ", adminLastName=" + adminLastName
				+ ", adminEmail=" + adminEmail + ", password=" + password + ", adminOTP=" + adminOTP + ", adminContact="
				+ adminContact + "]";
	}
	
	
	

	
	
}
