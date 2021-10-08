package com.rtc.compservice;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rtc.compservice.model.Company;
import com.rtc.compservice.service.CompanyService;

@Component
public class CompanyCommandLineRunner implements CommandLineRunner{

	@Autowired
	CompanyService compService;
	
	@Override
	public void run(String... args) throws Exception {
		LinkedList<Company> compList = new LinkedList<Company>();
		compList.add(new Company(1, "accenture", "hyderabad", null));
		compList.add(new Company(2, "legato", "hyderabad", null));
		compList.add(new Company(3, "wipro", "hyderabad", null));
		compList.add(new Company(4, "tcs", "hyderabad", null));
		compList.add(new Company(5, "opentext", "Banglore", null));
		compList.add(new Company(6, "amadeus", "Banglore", null));
		compList.add(new Company(7, "socgen", "Banglore", null));
		compService.setList(compList);
	}

}
