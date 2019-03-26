package com.hcbs.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Task {

	private String name;
	
	private LocalDateTime date;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getDate() {
		return  date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	
}
