package com.capgemini.app.employee.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.app.employee.pojo.Employee;
import com.capgemini.app.employee.queries.SQLQueries;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	JdbcTemplate template;

	@Override
	public String createNewAccount(Employee employee) {
		
		
		template.update(SQLQueries.getInstance().insertQuery(),new Object[] {employee.getId(),employee.getName(),employee.getSalary()});
		
		return "success";
	}
			
}

