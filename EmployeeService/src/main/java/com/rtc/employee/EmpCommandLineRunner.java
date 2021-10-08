package com.rtc.employee;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rtc.employee.model.Employee;
import com.rtc.employee.service.EmployeeService;

@Component
public class EmpCommandLineRunner implements CommandLineRunner {

	@Autowired
	EmployeeService service;

	@Override
	public void run(String... args) throws Exception {
		List<Employee> linkedList = new LinkedList<>();
		linkedList.add(new Employee(1l, "swyrik", "thupili"));
		linkedList.add(new Employee(2l, "veera", "pola"));
		linkedList.add(new Employee(3l, "karthik", "riksha"));
		linkedList.add(new Employee(4l, "chandra", "kondla"));
		linkedList.add(new Employee(5l, "manas", "ganga"));
		service.setEmpList(linkedList);
	}

}
