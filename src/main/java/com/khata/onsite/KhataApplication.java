package com.khata.onsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.khata.onsite.controllers","com.khata.onsite.services", "com.khata.onsite.interfaces","com.khata.onsite.entities","com.khata.onsite.repositories"})
public class KhataApplication {

	public static void main(String[] args) {
		SpringApplication.run(KhataApplication.class, args);
	}

}


//com.khata.onsite.