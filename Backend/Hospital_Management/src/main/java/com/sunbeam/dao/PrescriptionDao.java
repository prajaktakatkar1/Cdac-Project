package com.sunbeam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Prescription;

public interface PrescriptionDao  extends JpaRepository<Prescription, Integer>{

}
