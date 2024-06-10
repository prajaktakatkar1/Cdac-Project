package com.sunbeam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Bill;

public interface BillDao  extends JpaRepository<Bill, Integer>{
	
public Bill findByBillId(int id );

}
