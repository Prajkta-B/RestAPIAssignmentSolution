package com.greatLearning.employee.gradedAssignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greatLearning.employee.gradedAssignment.entity.EmployeeDetails;
import com.greatLearning.employee.gradedAssignment.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<EmployeeDetails> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public void addEmployee(EmployeeDetails employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);		
	}

	@Override
	public EmployeeDetails updateEmployee(EmployeeDetails updated_employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(updated_employee);
		return updated_employee;
	}

	@Override
	public EmployeeDetails findEmployeeByID(Integer id) {
		// TODO Auto-generated method stub
		Optional<EmployeeDetails> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		return null;
	}

	@Override
	public List<EmployeeDetails> findEmployeeByName(String firstName) {
		// TODO Auto-generated method stub
		return employeeRepository.findByFirstName(firstName);
	}

	@Override
	public List<EmployeeDetails> OrderByName(String order) {
		// TODO Auto-generated method stub
		if(order.equalsIgnoreCase("asc")) {
			return employeeRepository.findAll(Sort.by(Sort.Direction.ASC,"firstName"));
		}
		else if(order.equalsIgnoreCase("desc")) {
			return employeeRepository.findAll(Sort.by(Sort.Direction.DESC,"fistName"));
		}else
			return null;
	}

	@Override
	public void deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
		
	}

}
