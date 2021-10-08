package com.rtc.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rtc.employee.model.Employee;

import lombok.Getter;
import lombok.Setter;

@Service
public class EmployeeService {

	@Getter @Setter
	List<Employee> empList;
	
	
}
