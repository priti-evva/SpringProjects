package com.capgemini.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.demo.beans.Employee;
import com.capgemini.demo.repository.EmployeeRepo;

@Service
public class EmployeeServiceImp implements EmployeeService{
	
	      @Autowired
          EmployeeRepo employeeRepo;
		
		

		
		
		  public List<Employee> getAllEmployee()
		  {
			  return employeeRepo.findAll();
		  }
		  
		  public Optional<Employee> getEmployeeById(String empId)
		  {
			  return employeeRepo.findById(empId);
			  
		  }
		  
		  public Employee addEmployee(Employee employee)
		  {
			  employeeRepo.save(employee);
			  return employee;
		  }
		  
		  public void updateEmployee(String empId,Employee employee)
		  {
			  employeeRepo.save(employee);
			  
		  }
		  
		  
		  public void deleteEmployee(String empId)
		  {
			  employeeRepo.deleteById(empId);
		  }

}
