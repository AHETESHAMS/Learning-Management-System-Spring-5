package com.bridgelabz.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bridgelabz.user.model.Email;

@Service
public class EmailService {
	@Autowired
	JavaMailSender emailSender;
	public EmailService() 
	{
		
	}
	//@RabbitListener(queues = "queue")
	public void sendMail(Email email) 
	{
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(email.getTo());
		simpleMailMessage.setFrom(email.getFrom());
		simpleMailMessage.setSubject(email.getSubject());
		simpleMailMessage.setText(email.getBody());
		emailSender.send(simpleMailMessage);
	}

}
