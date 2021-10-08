package com.rtc.compservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rtc.compservice.model.Company;

import lombok.Getter;
import lombok.Setter;

@Service
public class CompanyService {
	
	@Getter @Setter
	List<Company> list;

}
