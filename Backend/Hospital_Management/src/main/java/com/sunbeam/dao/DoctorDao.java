package com.sunbeam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.entities.Doctor;

public interface DoctorDao extends JpaRepository<Doctor, Integer>{
	
	public Doctor findByDoctorEmail(String email);
	

}
