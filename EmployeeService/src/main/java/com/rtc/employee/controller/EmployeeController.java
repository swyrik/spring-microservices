package com.rtc.employee.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rtc.employee.model.Employee;
import com.rtc.employee.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/emp")
@Slf4j
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	@Autowired
    private DiscoveryClient discoveryClient;
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
	Environment environment;
	
	@GetMapping("/list")
	public ResponseEntity<List<Employee>> getEmployees(HttpServletRequest request){
		log.info("get employees started "+ environment.getProperty("server.port"));
		log.info("###########################################");
		log.info("###########################################");
		log.info(request.getHeader("authorization"));
		log.info("###########################################");
		log.info("###########################################");
		
		return ResponseEntity.status(HttpStatus.OK).body(this.empService.getEmpList());
	}
	
	@PreAuthorize("hasAuthority('SCOPE_DASH')")
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmpBasedOnId(@PathVariable("id") int id, HttpServletRequest request){
		log.info("get employee based on id started "+ environment.getProperty("server.port"));		
		log.info("###########################################");
		log.info("###########################################");
		log.info(request.getHeader("authorization"));
		log.info("###########################################");
		log.info("###########################################");
		return ResponseEntity.status(HttpStatus.OK).body(this.empService.getEmpList().get((int) id));
	}
	
	@GetMapping("/null")
	public ResponseEntity<Exception> failOver(){
		log.info("get employee based on id started "+ environment.getProperty("server.port"));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new NullPointerException());
	}
	
//	@PreAuthorize("hasAuthority('SCOPE_TEST')")
	@GetMapping("/ping")
	public ResponseEntity<String> ping(@RequestHeader("authorization") String token) {
		List<ServiceInstance> instances = discoveryClient.getInstances("COMPANY-SERVICE");
		log.info(token);
		 HttpHeaders headers = new HttpHeaders() {{
	            set("Authorization", token); 
	        }};
		Optional<ServiceInstance> findFirst = instances.stream().findFirst();
		log.error("http://localhost:"+findFirst.get().getPort()+"/cmp/info");
		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		if(findFirst.isPresent()) {
			entity = this.restTemplate.exchange("http://localhost:"+findFirst.get().getPort()+"/cmp/info", org.springframework.http.HttpMethod.GET, entity, String.class);
		}
		return ResponseEntity.status(HttpStatus.OK).body(entity.getBody());
	}
	
}
