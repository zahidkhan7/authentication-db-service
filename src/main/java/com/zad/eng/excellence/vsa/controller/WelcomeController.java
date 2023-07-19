package com.zad.eng.excellence.vsa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

	@GetMapping
	public String getWelcomeMessage(){
		
		return "Welcome To My Application";
	}
}
