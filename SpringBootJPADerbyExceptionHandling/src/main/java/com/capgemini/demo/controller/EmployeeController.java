package com.capgemini.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.demo.beans.Employee;
import com.capgemini.demo.exception.ResourceNotFoundException;
import com.capgemini.demo.service.EmployeeServiceImp;

@RestController
//@RestControllerAdvice
public class EmployeeController {
	@Autowired
	EmployeeServiceImp employeeService;
	
	@GetMapping("/employees")
	public  ResponseEntity<List<Employee>> getAllEmployee()
	{
		try {
			  
		      return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		
		
	}
	
	@GetMapping("/employee/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable String empId)
	{
		Employee employeeData =employeeService.getEmployeeById(empId).orElseThrow(() -> new ResourceNotFoundException("Not found Employee with id = " + empId));

			    return new ResponseEntity<>(employeeData, HttpStatus.OK);	
	}
	
	@PostMapping("/employee")
	public void addEmployee(@RequestBody Employee employee)
	{
		employeeService.addEmployee(employee);
	}
	
	@PutMapping("/employee/{empId}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable String empId)
	{
		Employee  employeeData =employeeService.getEmployeeById(empId).orElseThrow(() -> new ResourceNotFoundException("Not found Employee with id = " + empId));
		return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK);

	}
	
	@DeleteMapping("/employee/{empId}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable String empId)
	{
		
			employeeService.deleteEmployee(empId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

