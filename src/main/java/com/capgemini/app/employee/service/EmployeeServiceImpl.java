package com.capgemini.app.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.app.employee.dao.EmployeeDao;
import com.capgemini.app.employee.pojo.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao dao;
	
	@Override
	public String addNewEmployee(Employee employee) {

		return dao.createNewAccount(employee);
	}

}
