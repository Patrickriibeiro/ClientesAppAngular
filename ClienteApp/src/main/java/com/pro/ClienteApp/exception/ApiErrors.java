package com.pro.ClienteApp.exception;

import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public class ApiErrors {
	
	private List<String> errors;
	
	public ApiErrors(List<String> errors) {
		this.errors = errors;
	} 
	
	public ApiErrors(String message) {
		this.errors = Arrays.asList(message);
	}

}
