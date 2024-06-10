package com.sunbeam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.entities.Patient;

public interface PatientDao  extends JpaRepository<Patient, Integer>{
	
	public Patient findByPatientEmail(String email);
	
	
	// query to update the otp in patient database :
	@Modifying
	@Query("UPDATE Patient p SET p.patientOTP = ?2 WHERE p.patientEmail = ?1")
	public int setPatientOTP(String email , String otp);
	
	
	// method to reset the password 
	@Modifying
	@Query("UPDATE Patient p SET p.patientPassword =?1 where p.patientEmail = ?2")
	public int resetPassword(String newPassword , String email);
	
	
	
	
	
}
