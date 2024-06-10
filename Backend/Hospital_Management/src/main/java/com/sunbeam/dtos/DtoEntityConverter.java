package com.sunbeam.dtos;

import org.springframework.stereotype.Component;

import com.sunbeam.entities.Appointment;
import com.sunbeam.entities.Department;
import com.sunbeam.entities.Doctor;
import com.sunbeam.entities.Patient;

@Component
public class DtoEntityConverter {
	
	public DoctorDTO toDoctorDto(Doctor doctor)
	{
		
		DoctorDTO dto = new DoctorDTO();
		
		dto.setId(doctor.getDoctorId());
		dto.setFirstName(doctor.getDoctorFirstName());
		dto.setLastName(doctor.getDoctorLastName());
		dto.setEmail(doctor.getDoctorEmail());
		dto.setContact(doctor.getDoctorContact());
		dto.setPassword(doctor.getDoctorPassword());
		dto.setDepartmentId(doctor.getDoctorDepartment().getDepartmentId());
		return dto;
	}
	
	public UserDTO toPatientDto(Patient patient)
	{
		
		UserDTO dto = new UserDTO();
		
		dto.setId(patient.getPatientId());
		dto.setFirstName(patient.getPatientFirstName());
		dto.setLastName(patient.getPatientLastName());
		dto.setEmail(patient.getPatientEmail());
		dto.setContact(patient.getPatientContact());
		dto.setPassword(patient.getPatientPassword());
		return dto;
	}
	
	public Appointment toAppointmentEntity(AppointmentDTO appointmentDetails)
	{
		Doctor doctor = new Doctor();
		Patient patient = new Patient();
		patient.setPatientId(appointmentDetails.getPatientId());
		doctor.setDoctorId(appointmentDetails.getDoctorId());
		Appointment appointment = new Appointment();
		appointment.setAppointmentDate(appointmentDetails.getAppointmentDate());
		appointment.setAppointmentTime(appointmentDetails.getAppointmentTime());
		appointment.setAppointmentReason(appointmentDetails.getAppointmentReason());
		appointment.setPatient(patient);
		appointment.setDoctor(doctor);
		
		return appointment;
	}
	
	
	public Doctor toDoctorEntity (DoctorDTO user)
	{
		
		Department dept = new Department();
		dept.setDepartmentId(user.getDepartmentId());
		Doctor doctorEntity = new Doctor();
		doctorEntity.setDoctorFirstName(user.getFirstName());
		doctorEntity.setDoctorLastName(user.getLastName());
		doctorEntity.setDoctorEmail(user.getEmail());
		doctorEntity.setDoctorContact(user.getContact());
		doctorEntity.setDoctorPassword(user.getPassword());
		doctorEntity.setDoctorDepartment(dept);
		
				
		
		return doctorEntity;	
	}
	
	public Patient toPatientEntity (UserDTO user)
	{
		Patient patientEntity = new Patient();
		patientEntity.setPatientFirstName(user.getFirstName());
		patientEntity.setPatientLastName(user.getLastName());
		patientEntity.setPatientEmail(user.getEmail());
		patientEntity.setPatientContact(user.getContact());
		patientEntity.setPatientPassword(user.getPassword());
		
		return patientEntity;
		
	}


}
