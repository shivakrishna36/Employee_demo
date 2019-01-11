package com.capgemini.app.employee.controller;

import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.capgemini.app.employee.pojo.Employee;
import com.capgemini.app.employee.service.EmployeeService;
import com.capgemini.app.employee.validation.EmployeeValidator;



@Controller
@RequestMapping("/employee")
@SessionAttributes("employee")
public class EmployeeController {
	
	private static Logger logger = Logger.getLogger(EmployeeController.class.getName());
	@Autowired
	EmployeeValidator validator;
	
	@Autowired
	EmployeeService service;
	
	@RequestMapping(value="/save",method=RequestMethod.GET)
	public String askDetails(Map map)
	{
		map.put("employee", new Employee());
		return "input";
	}
	
	/*@RequestMapping("/save")
	public String save(@RequestParam("id") int id,@RequestParam("name") String name,@RequestParam("salary") double salary,Model model)
	{
		Employee employee = new Employee(id,name,salary);
		model.addAttribute("employee",employee);
		return "show";
	}*/
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@ModelAttribute("employee") Employee employee,BindingResult result)
	{
		validator.validate(employee, result);
		if(result.hasErrors())
		{
			return "input";
		}
		
		String outcome = service.addNewEmployee(employee);
		logger.info(outcome);
		return "redirect:afterSave";
	}
	
	@RequestMapping(value="/afterSave",method=RequestMethod.GET)
	public String save(SessionStatus status)
	{
		status.setComplete();
		return "show";
	}
}
