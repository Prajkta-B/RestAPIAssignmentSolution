package com.greatLearning.employee.gradedAssignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatLearning.employee.gradedAssignment.entity.EmployeeDetails;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Integer> {

	public List<EmployeeDetails> findByFirstName(String firstName);
}
