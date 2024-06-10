package com.sunbeam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.OTPGenerator.EmailSender;
import com.sunbeam.OTPGenerator.OTPGenerator;
import com.sunbeam.dtos.AppointmentDTO;
import com.sunbeam.dtos.Credential;
import com.sunbeam.dtos.OTPContent;
import com.sunbeam.dtos.Response;
import com.sunbeam.dtos.UserDTO;
import com.sunbeam.entities.Patient;
import com.sunbeam.service.PatientServiceImpl;

@CrossOrigin(origins = "*")
@RequestMapping("/patient")
@RestController // @Controller + @ResponseBody
public class PatientController {
	
	@Autowired
	private PatientServiceImpl patientService;
	
	@Autowired
	private EmailSender emailSender;
	
	@Autowired
	private OTPGenerator otpGenerator;
	
	//patient signin
	@PostMapping("/signin")
	public ResponseEntity<?> signIn(@RequestBody Credential cred) {
		UserDTO userDTO = patientService.findByPatientEmailAndPassword(cred);

		if (userDTO == null) {
			return Response.error("user not found");
		} else {
			return Response.success(userDTO);

		}

	}
	
	
	//patient signup
	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody UserDTO user)
	{
		UserDTO userDTO = patientService.savePatient(user);
		
		if(userDTO!= null)
		{
			return Response.success(userDTO);
		}
		else {
			return Response.error("Patient not saved");
		}
		
		 
	}
	
	
	//Controller to handle forgot password:
		@PostMapping("/forgotPassword")
		public ResponseEntity<?> forgotPassword(@RequestBody Credential cred)
		{
			String email = cred.getEmail();
			System.out.println(email);
			// validate if the email exists :
			
			Patient user = patientService.findByPatientEmail(email);

			
			if(user==null)
			{
			return Response.error("No User found for this email!!");	
			}
			else
			{
				// generate OTP:
			 String otp = otpGenerator.generateOTP();
			 // Send this otp to the database: 
			
			 patientService.setPatientOTP(email, otp);
			 // send this otp via email:
			 emailSender.sendEmail(email, otp);
			 return Response.success(" OTP Generated");
			}
		
		}
		
		// Controller to match the entered OTP with that otp at the database
		@PostMapping("/forgotPasswordOtp")
		public ResponseEntity<?> matchOTP(@RequestBody OTPContent otpContent )
		{
			
			String email = otpContent.getEmail();
			String otp = otpContent.getOtp();
			
			// match the OTP corresponding to the user of that email;
					//Find user by email:
			Patient user = patientService.findByPatientEmail(email);
			if(user.getPatientOTP().equals(otp))
			{
				return Response.success("Correct OTP entered");
			}
			else
			{ 
				// incorrect OTP
				return Response.error("Invalid OTP");
				
			}
		
		}
		
		
		
//		 Controller to Reset the password 
		@PutMapping("/resetPassword")
		public ResponseEntity<?> resetPassword(@RequestBody Credential cred)
		{
			String email = cred.getEmail();
			String newPassword = cred.getPassword();
			System.out.println("************************!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println(email);
			System.out.println(newPassword);
			
			 int i =  patientService.resetPassword(newPassword, email);
			return  Response.success("Password updated successfully!!");
			
			
		}
		
		
		
		//api for booking the appointnment 
		@PostMapping("/bookAppointment")
		public ResponseEntity<?>bookAppointment(@RequestBody AppointmentDTO appointmentDetails)
		{
			
			return null;
		}
		
		
		

}
