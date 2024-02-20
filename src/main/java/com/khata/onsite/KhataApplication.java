package com.khata.onsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.khata.onsite.security","com.khata.onsite.configs","com.khata.onsite.controllers","com.khata.onsite.services", "com.khata.onsite.interfaces","com.khata.onsite.entities","com.khata.onsite.repositories"})
public class KhataApplication {

	public static void main(String[] args) {
		SpringApplication.run(KhataApplication.class, args);
		
		 
		
	}
	
	/*
	 * @Bean public FilterRegistrationBean<HttpLoggingFilter> dawsonApiFilter() {
	 * FilterRegistrationBean<HttpLoggingFilter> registration = new
	 * FilterRegistrationBean<HttpLoggingFilter>(); registration.setFilter(new
	 * HttpLoggingFilter());
	 * 
	 * // In case you want the filter to apply to specific URL patterns only
	 * //registration.addUrlPatterns("/dawson/*"); return registration; }
	 */

}


//com.khata.onsite.