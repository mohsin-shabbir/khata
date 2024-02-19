package com.khata.onsite.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class IndexController {
	
	@GetMapping("/")
	public String  Greeting()
	{
		return "Hello World";
	}

}
