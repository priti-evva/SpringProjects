package com.capgemini.demo.service;

import java.util.List;

import com.capgemini.demo.beans.Employee;

public interface EmployeeService {
	  public List<Employee> getAllEmployee();

	  public void addEmployee(Employee employee);
	
	  public Employee getEmployeeById(String empId);

	  public void updateEmployee(String empId,Employee employee);

	  public void deleteEmployee(String empId);

}
