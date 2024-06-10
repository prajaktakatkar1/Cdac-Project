package com.sunbeam.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sunbeam.dao.PatientDao;
import com.sunbeam.dtos.AppointmentDTO;
import com.sunbeam.dtos.Credential;
import com.sunbeam.dtos.DtoEntityConverter;
import com.sunbeam.dtos.UserDTO;
import com.sunbeam.entities.Doctor;
import com.sunbeam.entities.Patient;

@Transactional
@Service
public class PatientServiceImpl 
{
	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private DtoEntityConverter dtoEntityConverter;
	
	public UserDTO findByPatientEmailAndPassword(Credential cred) 
	{
		Patient patient = patientDao.findByPatientEmail(cred.getEmail());

		if (patient != null && passwordEncoder.matches(cred.getPassword(), patient.getPatientPassword())) {
			
			return dtoEntityConverter.toPatientDto(patient);
		}
		return null;
	}
	
	
	// method to get patient by email
	public Patient findByPatientEmail(String email)
	{
		return patientDao.findByPatientEmail(email);
	}
	
	
	
	
	public UserDTO savePatient(UserDTO user)
	{
		String rawpassword = user.getPassword();
		// We got encrypted password
		String encryptPassword = passwordEncoder.encode(rawpassword);
		
		 Patient patient= dtoEntityConverter.toPatientEntity(user);
		 
		patient.setPatientPassword(encryptPassword);
		 
		 patient = patientDao.save(patient);
		 
		 return dtoEntityConverter.toPatientDto(patient);
	}
	
	
	
	// setting the OTP in the database when user clicks on forgot password
	public int setPatientOTP(String email , String otp)
	{
		return patientDao.setPatientOTP(email, otp);
	}
	
	
	// Method for resetting the password:
		public int resetPassword(String newPassword , String email)
		{
			String encryptedPassword = passwordEncoder.encode(newPassword);
			return patientDao.resetPassword(encryptedPassword, email);
		}
	
		
		
		// Method for saving the patient appointment booking details
		public AppointmentDTO saveAppoinementBooking(AppointmentDTO appointmentDetail)
		{
			
			
			return null;
		}

}
