package com.sunbeam.OTPGenerator;

import java.text.DecimalFormat;
import java.util.Random;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class OTPGenerator {
	
public String generateOTP()
{
	Random random = new Random();
	String otp = new DecimalFormat("00000").format(random.nextInt(99999));
	
	return otp;

}
}