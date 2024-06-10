package com.sunbeam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Appointment;

public interface AppointmentDao extends JpaRepository<Appointment, Integer>{

}
