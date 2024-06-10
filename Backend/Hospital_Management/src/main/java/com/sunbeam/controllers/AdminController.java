package com.sunbeam.controllers;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.OTPGenerator.EmailSender;
import com.sunbeam.OTPGenerator.OTPGenerator;
import com.sunbeam.dtos.Credential;
import com.sunbeam.dtos.OTPContent;
import com.sunbeam.dtos.RecentDoctor;
import com.sunbeam.dtos.RecentPatient;
import com.sunbeam.dtos.Response;
import com.sunbeam.entities.Admin;
import com.sunbeam.service.AdminServiceImpl;
import com.sunbeam.service.DoctorServiceImpl;

@CrossOrigin(origins = "*")
@RequestMapping("/admin")
@RestController // @Controller + @ResponseBody
public class AdminController {
	
	@Autowired
	private AdminServiceImpl adminService;
	
	@Autowired
	private DoctorServiceImpl doctorService;
	
	@Autowired
	private OTPGenerator otpGenerator;
	
	@Autowired
	private EmailSender emailSender;
	
	@PostMapping("/signin")
	public ResponseEntity<?> signIn(@RequestBody Credential cred)
	{
		Admin admin = adminService.findByAdminEmailAndPassword(cred);
		
		if( admin == null)
		{
			return Response.error("user not found");
		}
		else
		{
			return Response.success(admin);
			
		}
		
		
	}
	
	
	@GetMapping("/adminDashboardContent")
	public ResponseEntity<?> findCountInDashBoard()
	{
		// Getting dashboard cards details:
		int doctorCount = adminService.findDoctorCount();
		int admittedPatientatientCount = adminService.findAdmittedPatients();
		int approvedAppointment = adminService.findApprovedPatients();
		int newAppointmentRequest = adminService.findNewAppointmentRequest();
		
		
		
		
		// Getting list of patients:
		List<RecentPatient> recentPatients=  adminService.listOfRecentPatient();
		
		
		// Getting list of doctors:
		List<RecentDoctor> recentDoctors=  adminService.listOfRecentDoctors();
		
	
		// Storing values in the MAP:
		Map<String , Object> adminDashboard = new HashMap<>();
		
		adminDashboard.put( "doctorCount",doctorCount);
		adminDashboard.put("admittedPatientatientCount",admittedPatientatientCount);
		adminDashboard.put("approvedAppointment",approvedAppointment);
		adminDashboard.put("newAppointmentRequest",newAppointmentRequest);
		//
		adminDashboard.put("recentPatients" , recentPatients);
		//
		adminDashboard.put("recentDoctors" , recentDoctors);
		
		return Response.success(adminDashboard);
		
	}
	

	//Controller to handle forgot password:
	@PostMapping("/forgotPassword")
	public ResponseEntity<?> forgotPassword(@RequestBody Credential cred)
	{
		String email = cred.getEmail();
		System.out.println(email);
		// validate if the email exists :
		Admin user = adminService.findByEmail(email);

		
		if(user==null)
		{
		return Response.error("No User found for this email!!");	
		}
		else
		{
			// generate OTP:
		 String otp = otpGenerator.generateOTP();
		 // Send this otp to the database: 
		 adminService.setAdminOTP(email, otp);
		 // send this otp via email:
		 emailSender.sendEmail(email, otp);
		 return Response.success(" OTP Generated");
		}
	
	}
	
	
	
	// Controller to match the entered OTP with that od the database
	@PostMapping("/forgotPasswordOtp")
	public ResponseEntity<?> matchOTP(@RequestBody OTPContent otpContent )
	{
		
		String email = otpContent.getEmail();
		String otp = otpContent.getOtp();
		
		// match the OTP corresponding to the user of that email;
				//Find user by email:
		Admin user = adminService.findByEmail(email);
		if(user.getAdminOTP().equals(otp))
		{
			return Response.success("Correct OTP entered");
		}
		else
		{ 
			// incorrect OTP
			return Response.error("Invalid OTP");
			
		}
	
	}
	
	
	
//	 Controller to Reset the password 
	@PutMapping("/resetPassword")
	public ResponseEntity<?> resetPassword(@RequestBody Credential cred)
	{
		String email = cred.getEmail();
		String newPassword = cred.getPassword();
		System.out.println("************************!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(email);
		System.out.println(newPassword);
		
		 int i =  adminService.resetPassword(newPassword, email);
		return  Response.success("Password updated successfully!!");
		
		
	}
	
	//api to send list of non approved doctors:
	@GetMapping("/nonApprovedDoctor")
	public ResponseEntity<?> getNonApporvedDoctor()
	{
		 List<RecentDoctor> listOfNonApprovedDoctors =  adminService.nonApprovedDoctors();
		 return Response.success(listOfNonApprovedDoctors);
	}
	
	
	// api to approve the  doctor:
	@PutMapping("/approveDoctor/{id}")
	public ResponseEntity<?>updateDoctorStatus(@PathVariable ("id") int id )
	{
		int result = adminService.updateDoctorStatus(id);
		
		return Response.success("Update successfully , No of rows effected : " +  result);
	}
	
	
	
	// API to reject the doctor's approval
	@DeleteMapping("/rejectDoctor/{id}")
	public ResponseEntity<?>rejectDoctor(@PathVariable("id") int id)
	{
		int result =  doctorService.rejectDoctor(id);
		return Response.success("Deleted  successfully ,  Status is : (1/ok , 0/error) -->" +  result);
	}
	
	
	//api to get  list of all approved doctors:
	@GetMapping("/approvedDoctor")
	public ResponseEntity<?> getApporvedDoctor()
	{
		 List<RecentDoctor> listOfApprovedDoctors =  adminService.approvedDoctors();
		 return Response.success(listOfApprovedDoctors);
	}
	
	
	
	
	
	
	
	

}
