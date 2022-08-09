package com.greatLearning.employee.gradedAssignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatLearning.employee.gradedAssignment.entity.EmployeeDetails;
import com.greatLearning.employee.gradedAssignment.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/api/employees")
	public ResponseEntity<List<EmployeeDetails>> getAllEmployees() {
		try {
			List<EmployeeDetails> list = employeeService.getAllEmployees();
			if (list.isEmpty()) {
				return new ResponseEntity<List<EmployeeDetails>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<EmployeeDetails>>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Get Employee by Id
	@GetMapping("/api/employees/{id}")
	public ResponseEntity<EmployeeDetails> findEmployeeById(@PathVariable Integer id) {
		EmployeeDetails employee = employeeService.findEmployeeByID(id);
		if (employee != null) {
			return new ResponseEntity<EmployeeDetails>(employee, HttpStatus.OK);
		}
		return new ResponseEntity<EmployeeDetails>(HttpStatus.NOT_FOUND);

	}

	// Get employees by First Name
	@GetMapping("/api/employees/search/{firstName}")
	public ResponseEntity<List<EmployeeDetails>> findEmployeesByName(@PathVariable String firstName) {
		try {
			List<EmployeeDetails> list = employeeService.findEmployeeByName(firstName);
			if (list.isEmpty()) {
				return new ResponseEntity<List<EmployeeDetails>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<EmployeeDetails>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Get all employees sorted by First Name
	@GetMapping("/api/employees/sort")
	public ResponseEntity<List<EmployeeDetails>> OrderByName(@RequestParam("order") String sortDirection) {
		try {
			List<EmployeeDetails> list = employeeService.OrderByName(sortDirection);
			if (list.isEmpty()) {
				return new ResponseEntity<List<EmployeeDetails>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<EmployeeDetails>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// ADD employee
	@PostMapping("/api/employees/add")
	public ResponseEntity<EmployeeDetails> AddEmployee(@RequestBody EmployeeDetails employee) {
		try {
			employeeService.addEmployee(employee);
			return new ResponseEntity<EmployeeDetails>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Update employee
	@PutMapping("/api/employees/update")
	public ResponseEntity<EmployeeDetails> UpdateEmployee(@RequestBody EmployeeDetails employee) {
		try {
			employeeService.updateEmployee(employee);
			return new ResponseEntity<EmployeeDetails>(employee, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Delete employee
	@DeleteMapping("/api/employees/delete/{id}")
	public ResponseEntity<String> DeleteEmployee(@PathVariable Integer id) {
		try {
			employeeService.deleteEmployee(id);
			return new ResponseEntity<String>("Deleted Employee with ID-" + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
}
