package com.zad.eng.excellence.vsa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

	@GetMapping
	public String getWelcomeMessage(){
		
		return "Welcome To My Application";
	}
}
