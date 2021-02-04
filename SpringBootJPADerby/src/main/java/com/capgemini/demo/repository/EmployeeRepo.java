package com.capgemini.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.demo.beans.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,String> {

}
