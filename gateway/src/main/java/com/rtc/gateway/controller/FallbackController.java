package com.rtc.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

	@GetMapping("/fallback")
	public String getFallBack() {
		return "this is a fallback method";
	}
	
}
