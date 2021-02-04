package com.capgemini.demo.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.demo.beans.Employee;

public interface EmployeeService {
	  public List<Employee> getAllEmployee();

	  public Employee addEmployee(Employee employee);
	
	  public Optional<Employee> getEmployeeById(String empId);

	  public void updateEmployee(String empId,Employee employee);

	  public void deleteEmployee(String empId);

}
