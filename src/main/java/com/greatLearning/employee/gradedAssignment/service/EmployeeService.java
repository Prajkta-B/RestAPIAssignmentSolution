package com.greatLearning.employee.gradedAssignment.service;

import java.util.List;

import com.greatLearning.employee.gradedAssignment.entity.EmployeeDetails;

public interface EmployeeService {

	public List<EmployeeDetails> getAllEmployees();
	public void addEmployee(EmployeeDetails employee);
	public EmployeeDetails updateEmployee(EmployeeDetails updated_employee);
	public EmployeeDetails findEmployeeByID(Integer id);
	public List<EmployeeDetails> findEmployeeByName(String firstName);
	public List<EmployeeDetails> OrderByName(String order);
	public void deleteEmployee(Integer id);
}
