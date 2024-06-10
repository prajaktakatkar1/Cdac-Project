package com.sunbeam.OTPGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {
	
	@Autowired
	JavaMailSender javamailSender;
	
	public void sendEmail(String email , String otp)
	{
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("springboot1619@gmail.com");
		message.setTo(email);
		message.setSubject("OTP for Password reset");
		message.setText("Your One Time Password (OTP) is   :" + otp);
		
		javamailSender.send(message);
		
	}
	
	
	public void sendRejectEmail(String email , String name)
	{
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("springboot1619@gmail.com");
		message.setTo(email);
		message.setSubject("Regarding request for registering in Hospital Management System "  );
		message.setText("Dear,  " + name + " This is to inform that your registration request in Hospital Management System is cancelled . \n For more details please contact the  hospital administration. "  );
	
		
		javamailSender.send(message);
	}
	

}
