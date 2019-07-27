package com.cdac.project.faculty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailingController {

	 @Autowired
	 private JavaMailSender javaMailSender;
	 
	 @RequestMapping(value="/api/sendEmail",method=RequestMethod.GET)
	 @ResponseStatus(value=HttpStatus.OK)
	 public void sendEmail() {
		 SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo("sonalisonmale@gmail.com");

	        msg.setSubject("Testing from Spring Boot");
	        msg.setText("Hello World \n Spring Boot Email");

	        javaMailSender.send(msg);
	 }
}
