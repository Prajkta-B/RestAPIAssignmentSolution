package com.greatLearning.employee.gradedAssignment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class EmployeeDetails {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private String email;


}
