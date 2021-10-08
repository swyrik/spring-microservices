package com.rtc.compservice.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

	long id;
	String name;
	String address;
	List<Employee> employees;
	
}
