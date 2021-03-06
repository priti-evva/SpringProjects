package com.capgemini.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.demo.beans.Employee;
import com.capgemini.demo.service.EmployeeServiceImp;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeServiceImp employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee()
	{
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/employee/{empId}")
	public Optional<Employee> getEmployeeById(@PathVariable String empId)
	{
		return employeeService.getEmployeeById(empId);
	}
	
	@PostMapping("/employee")
	public void addEmployee(@RequestBody Employee employee)
	{
		employeeService.addEmployee(employee);
	}
	
	@PutMapping("/employee/{empId}")
	public void updateEmployee(@RequestBody Employee employee,@PathVariable String empId)
	{
		employeeService.updateEmployee(empId, employee);
	}
	
	@DeleteMapping("/employee/{empId}")
	public void deleteEmployee(@PathVariable String empId)
	{
		employeeService.deleteEmployee(empId);
	}

}
