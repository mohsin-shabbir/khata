package com.khata.onsite.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.khata.onsite.security.filter.JwtAuthenticationFilter;
import com.khata.onsite.security.impl.UserDetailServiceImp;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
//@ConditionalOnProperty (name = "myproject.security.enabled", havingValue = "true", matchIfMissing = true) // to enable disable security
public class JWTSecurityConfig {
	
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	private final UserDetailServiceImp userDtailServiceImp;
	private final CustomAccessDeniedHandler customAccessDeniedHandler; 
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		return http
				.csrf(AbstractHttpConfigurer::disable)
				//.formLogin(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(	
						req-> req.requestMatchers("/login/**" , "/register/**") // To keep these requests out of authentication, other any request will be authenticated
						.permitAll()
						.requestMatchers("/adminAccessOnly/**").hasAuthority("ADMIN")
						.anyRequest()
						.authenticated()
						).userDetailsService(userDtailServiceImp) // authentication will be done using this service
				.exceptionHandling(e-> e.accessDeniedHandler(customAccessDeniedHandler) // This will be to set custom code incase of access denied by default its 403
						.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))) //Send unauthorized code incase user is unacuthorized
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) //authentication will be done using this filter
				.build();				
				
	}
	
	// To Encode Password
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception
	{
		return configuration.getAuthenticationManager();
	}
	

}
