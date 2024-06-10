package com.sunbeam.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sunbeam.dao.AdminDao;
import com.sunbeam.dtos.Credential;
import com.sunbeam.dtos.RecentDoctor;
import com.sunbeam.dtos.RecentPatient;
import com.sunbeam.entities.Admin;

@Transactional
@Service

public class AdminServiceImpl
{
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public Admin findByEmail(String email)
	{
		
		return  adminDao.findByAdminEmail(email);
	}
	
	// find by admin email and password
	public Admin findByAdminEmailAndPassword(Credential cred)
	{
		
		Admin admin = adminDao.findByAdminEmail(cred.getEmail());
		
		if(admin != null && passwordEncoder.matches(cred.getPassword(), admin.getPassword()))
		{
			return admin;
		}
		
		
		return null;	
	}
	
	//getting number of all doctors 
	public int findDoctorCount()
	{
		 return adminDao.findDoctorCount();
	}
	
	// getting all admitted patients
	public int findAdmittedPatients()
	{
		return adminDao.findAdmittedPatients();
	}
	
	// getting all approved  appointments
	public int findApprovedPatients()
	{
		return adminDao.findApprovedPatients();
	}
	
	
	// find all new appointment request
	public int findNewAppointmentRequest()
	{
		return adminDao.findNewAppointmentRequest();
	}
	
	// getting the list of patient via order by clause
	public List<RecentPatient> listOfRecentPatient()
	{
		return adminDao.listOfRecentPatient();
	}
	
	
	// getting the list of doctor  via order by clause
	public List<RecentDoctor> listOfRecentDoctors()
	{
		return adminDao.listOfRecentDoctors();
	}
	
	
	
	// setting the OTP in the database when user clicks on forgot password
	public int setAdminOTP(String email , String otp)
	{
		return adminDao.setAdminOTP(email, otp);
	}
	
	// Method for resetting the password:
	public int resetPassword(String newPassword , String email)
	{
		String encryptedPassword = passwordEncoder.encode(newPassword);
		return adminDao.resetPassword(encryptedPassword, email);
	}
	
	
	
	// Getting all non approved doctors:
	public List<RecentDoctor> nonApprovedDoctors()
	{
		return adminDao.getNonApprovedDoctors();
	}
	
	
	// Approving /updating the doctor approve status
	public int updateDoctorStatus(int id)
	{
		return adminDao.updateDoctorStatus(id);
	}
	
	
	// Getting all  approved doctors:
		public List<RecentDoctor> approvedDoctors()
		{
			return adminDao.getApprovedDoctors();
		}
		
	
	
	
	
	
	
	

}
