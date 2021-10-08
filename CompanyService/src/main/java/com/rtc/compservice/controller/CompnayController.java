package com.rtc.compservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rtc.compservice.model.Company;
import com.rtc.compservice.service.CompanyService;

@RestController
@RequestMapping("/cmp")
public class CompnayController {
	
	@Autowired
	CompanyService compService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Company>> getCompList(){
		return ResponseEntity.status(HttpStatus.OK).body(this.compService.getList());
	}
	
	@GetMapping("/info")
	public ResponseEntity<String> getCompInfo(){
		return ResponseEntity.status(HttpStatus.OK).body("Company Service");
	}

}
