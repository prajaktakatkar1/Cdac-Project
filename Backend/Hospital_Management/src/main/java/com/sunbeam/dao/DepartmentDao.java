package com.sunbeam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer>{

}
