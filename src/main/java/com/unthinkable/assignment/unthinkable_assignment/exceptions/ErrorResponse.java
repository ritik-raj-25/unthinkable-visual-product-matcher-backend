package com.unthinkable.assignment.unthinkable_assignment.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
	private Integer status;
	private Boolean success;
	private String message;
	private LocalDateTime timestamp;
	
	public ErrorResponse() {
		success = false;
		timestamp = LocalDateTime.now();
	}
}
