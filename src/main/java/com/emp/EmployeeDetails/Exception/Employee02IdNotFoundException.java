package com.emp.EmployeeDetails.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class Employee02IdNotFoundException extends RuntimeException
{

	public Employee02IdNotFoundException(String message) 
	{
		super(message);
	}
	
}
