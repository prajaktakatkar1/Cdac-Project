package com.sunbeam;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sunbeam.dao.BillDao;
import com.sunbeam.entities.Bill;


@SpringBootTest
@Transactional
class HospitalManagementApplicationTests {

@Autowired
private BillDao billDao;
	
	@Test
	void findById()
	{
	Bill b =	billDao.findByBillId(3);
	System.out.println(b);
	}
	
	
	

}
