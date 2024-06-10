package com.sunbeam.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Table(name = "department")
@Entity
public class Department {

	
	@Id
	@Column(name="dept_id")
	private int departmentId;
	
	@Column(name="dept_name")
	private String departmentName;
	
	
	@OneToMany(mappedBy = "doctorDepartment")
	private List<Doctor> doctorList;


	public Department() {
		super();
	}


	public Department(int departmentId, String departmentName, List<Doctor> doctorList) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.doctorList = doctorList;
	}


	public int getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public List<Doctor> getDoctorList() {
		return doctorList;
	}


	public void setDoctorList(List<Doctor> doctorList) {
		this.doctorList = doctorList;
	}


	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", doctorList="
				+ doctorList + "]";
	}
	
	
	
	
	
	
	

}
