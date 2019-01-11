package com.capgemini.app.employee.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.capgemini.app.employee.pojo.Employee;

@Component
public class EmployeeValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employee employee = (Employee)target;
		
		if(employee.getName().length()<2)
		{
			errors.rejectValue("name", "name.length", "Employee Name Must Have More than 2 characters");
		}
		
		if(employee.getSalary()<100000)
		{
			errors.rejectValue("salary", "salarylength", "Employee salary Must be more than 100000");
		}
		
	}

}
