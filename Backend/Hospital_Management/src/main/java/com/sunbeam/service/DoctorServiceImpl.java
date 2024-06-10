package com.sunbeam.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sunbeam.OTPGenerator.EmailSender;
import com.sunbeam.dao.DoctorDao;
import com.sunbeam.dtos.Credential;
import com.sunbeam.dtos.DoctorDTO;
import com.sunbeam.dtos.DtoEntityConverter;
import com.sunbeam.dtos.UserDTO;
import com.sunbeam.entities.Doctor;

@Transactional
@Service
public class DoctorServiceImpl {
	
	
	@Autowired
	private EmailSender emailSender;

	@Autowired
	private DoctorDao doctorDao;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private DtoEntityConverter dtoEntityConverter;

	public DoctorDTO findByDoctorEmailAndPassword(Credential cred) 
	{
		Doctor doctor = doctorDao.findByDoctorEmail(cred.getEmail());

		if (doctor != null && passwordEncoder.matches(cred.getPassword(), doctor.getDoctorPassword())) {
			
			return dtoEntityConverter.toDoctorDto(doctor);
		}
		return null;
	}
	
	
	public DoctorDTO saveDoctor(DoctorDTO user)
	{
		String rawpassword = user.getPassword();
		// We got encrypted password
		String encryptPassword = passwordEncoder.encode(rawpassword);
		
		 Doctor doctor = dtoEntityConverter.toDoctorEntity(user);
		 
		 doctor.setDoctorPassword(encryptPassword);
		 
		 doctor =   doctorDao.save(doctor);
		 
		 return dtoEntityConverter.toDoctorDto(doctor);
	}
	
	
	public Doctor findDoctorById(int id)
	{
		return doctorDao.findById(id).orElse(null);
	}
	
	//reject the doctor (delete the doctor and send the email to the doctor)
	// Here we are getting the doctor details and sending the rejecton mail to the doctor
	public int rejectDoctor(int id)
	{
		Doctor doctor = this.findDoctorById(id);
		String name = doctor.getDoctorFirstName();
		String email = doctor.getDoctorEmail();
		emailSender.sendRejectEmail(email, name);
		doctorDao.deleteById(id);
		
		return 1;
	}

}
