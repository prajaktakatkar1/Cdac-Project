package com.sunbeam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dtos.Credential;
import com.sunbeam.dtos.DoctorDTO;
import com.sunbeam.dtos.Response;
import com.sunbeam.dtos.UserDTO;

import com.sunbeam.service.DoctorServiceImpl;
@CrossOrigin(origins = "*")
@RequestMapping("/doctor")
@RestController
public class DoctorController {

	@Autowired
	private DoctorServiceImpl doctorService;

	@PostMapping("/signin")
	public ResponseEntity<?> signIn(@RequestBody Credential cred) {
		DoctorDTO userDTO = doctorService.findByDoctorEmailAndPassword(cred);

		if (userDTO == null) {
			return Response.error("user not found");
		} else {
			return Response.success(userDTO);

		}

	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody DoctorDTO user)
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(user.getDepartmentId());
		DoctorDTO userDTO = doctorService.saveDoctor(user);
		
		if(userDTO!= null)
		{
			return Response.success(userDTO);
		}
		else {
			return Response.error("User not saved");
		}
		
		 
	}

}
