package com.sunbeam.dtos;

public class OTPContent {

	
	private String email;
	private String otp;
	public OTPContent() {
		super();
	}
	public OTPContent(String email, String otp) {
		super();
		this.email = email;
		this.otp = otp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "OTPContent [email=" + email + ", otp=" + otp + "]";
	}
	
	
}
