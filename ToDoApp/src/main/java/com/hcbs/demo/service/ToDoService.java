package com.hcbs.demo.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.hcbs.demo.dao.TaskRepository;
import com.hcbs.demo.model.Task;

@Service
public class ToDoService {
	@Autowired
	JavaMailSender emailSender;

	@Autowired
	TaskRepository repository;

	//this method will check for every 15 minutes if there is any task in next 15 minutes and if yes it will send mail.
	
	@Scheduled(fixedRate=900000)
	public void sendReminder() {
	    	
	    	List<Task> tasks = repository.findAll();
	    	for(Task t:tasks) {
	    		
	    		LocalDateTime now = LocalDateTime.now();
	    	    LocalDateTime after = t.getDate();
	    	    Duration duration = Duration.between(now, after);
	    	    long diff = Math.abs(duration.toMinutes());
	    	 	if(diff<=15) {
	    	 		
	    	 		SimpleMailMessage message = new SimpleMailMessage(); 
	    	        message.setTo("abc@xyz.com"); 
	    	        message.setSubject("Scheduled task in 15 minutes"); 
	    	        message.setText("You have below scheduled task "+t.getName()+"at"+t.getDate());
	    	        emailSender.send(message);
	    	 		
	    	 		
	    	 	}
	    		
	    	}
}
}