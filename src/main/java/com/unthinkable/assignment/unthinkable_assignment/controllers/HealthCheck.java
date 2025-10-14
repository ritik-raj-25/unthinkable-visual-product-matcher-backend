package com.unthinkable.assignment.unthinkable_assignment.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
	
	@GetMapping("/")
	public String healthCheck() {
		return "Application is running";
	}
}
