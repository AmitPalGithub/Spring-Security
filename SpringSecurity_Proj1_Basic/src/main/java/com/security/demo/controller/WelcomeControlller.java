package com.security.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeControlller {
	
	
	@GetMapping("/welcome")
	public String wecome() {
		return "welcome security";
	}

}
