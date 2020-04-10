package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.entity.Employee;
import com.test.repository.EmployeeRepository;

@Controller
public class EmployeeController {
	
	 @Autowired
	 private EmployeeRepository repository;
	
	@RequestMapping("/home")
	public String welcomeBack() {
		return "home";
	}
	@RequestMapping(value="/addEmployee",method=RequestMethod.GET)
	public String addEmployee(Model model) {
		model.addAttribute("message", "");
		return "addEmployee";
	}
	@RequestMapping(value="/viewEmployee",method=RequestMethod.GET)
	public String viewEmployee(Model model) {
		Iterable<Employee> employees=repository.findAll();
		model.addAttribute("employeeList", employees);
		return "viewEmployee";
	}
	
	@RequestMapping(value="/addEmployee",method=RequestMethod.POST)
	public String addEmployeeToDB(Model model,@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName ,@RequestParam("email") String email) {
		repository.save(new Employee(firstName,lastName,email));
		model.addAttribute("message", "Employee saved successfully");
		return "addEmployee";
	}
}
