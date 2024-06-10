package com.sunbeam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.dtos.RecentDoctor;
import com.sunbeam.dtos.RecentPatient;
import com.sunbeam.entities.Admin;
import com.sunbeam.entities.Doctor;

public interface AdminDao extends JpaRepository<Admin, Integer> {

	public Admin findByAdminEmail(String email);

	// query for getting number of all doctors

	@Query("SELECT count(d.doctorId) from Doctor d  where d.doctorStatus=1")
	public int findDoctorCount();

	// query for getting all admitted patients
	@Query("SELECT count(a.appointmentId) from Appointment a where a.patientAdmitStatus=1")
	public int findAdmittedPatients();

	// query for getting all approved appointments
	@Query("SELECT count(a.appointmentId) from Appointment a where  a.patientAppointmentStatus=1")
	public int findApprovedPatients();

	// query to find all new appointment request
	@Query("SELECT count(a.appointmentId) from Appointment a where  a.patientAppointmentStatus=0")
	public int findNewAppointmentRequest();
//	ORDER BY a.appointmentDate , appointmentTime 
	//
	// query to get the recent patients using order by
	@Query("SELECT new com.sunbeam.dtos.RecentPatient(p.patientFirstName, a.appointmentReason,  p.patientContact , p.patientAddress, a.patientAppointmentStatus) FROM Patient p INNER JOIN Appointment a ON a.patient.patientId = p.patientId ORDER BY a.appointmentDate , a.appointmentTime DESC")
	public List<RecentPatient> listOfRecentPatient();
    //
	//
	//
	//query to get the recent doctors using order by:
	@Query("SELECT new com.sunbeam.dtos.RecentDoctor(do.doctorId ,do.doctorFirstName , d.departmentName , do.doctorEmail , do.doctorContact , do.doctorStatus ) FROM Doctor do INNER JOIN  Department d ON do.doctorDepartment.departmentId = d.departmentId ORDER BY do.doctorJoinDate DESC")
	public List<RecentDoctor> listOfRecentDoctors();
	
	// method to set otp into the data base
	@Modifying
	@Query("UPDATE Admin a SET a.adminOTP = ?2 WHERE a.adminEmail = ?1")
	public int setAdminOTP(String email , String otp);
	
	// method to reset the password 
	@Modifying
	@Query("UPDATE Admin a SET a.password =?1 where a.adminEmail = ?2")
	public int resetPassword(String newPassword , String email);
	
	
	// Query to get all non approved doctor
	@Query("SELECT new com.sunbeam.dtos.RecentDoctor(do.doctorId , do.doctorFirstName , d.departmentName , do.doctorEmail , do.doctorContact , do.doctorStatus ) FROM Doctor do INNER JOIN  Department d ON do.doctorDepartment.departmentId = d.departmentId where do.doctorStatus=0")
	public List<RecentDoctor>getNonApprovedDoctors();
	
	
	
	// query to update the doctor approve status
	@Modifying
	@Query("UPDATE Doctor d SET d.doctorStatus = 1 WHERE d.doctorId = ?1")
	public int updateDoctorStatus(int id);
	
	
	// Query to get all  approved doctor
		@Query("SELECT new com.sunbeam.dtos.RecentDoctor(do.doctorId , do.doctorFirstName , d.departmentName , do.doctorEmail , do.doctorContact , do.doctorStatus ) FROM Doctor do INNER JOIN  Department d ON do.doctorDepartment.departmentId = d.departmentId where do.doctorStatus=1")
		public List<RecentDoctor>getApprovedDoctors();
}
