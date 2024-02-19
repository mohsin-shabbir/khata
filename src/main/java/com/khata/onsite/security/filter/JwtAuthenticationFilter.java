package com.khata.onsite.security.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.khata.onsite.security.service.JWTService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	final JWTService  jwtService;
	//final Jw

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {


		String authHeader = request.getHeader("Authorization");
		if(authHeader ==null || !authHeader.startsWith("Bearer "))
		{
			// Check if authentication header not provided.
			filterChain.doFilter(request, response);
			return;
		}
		
		//Get the token and ignore the Bearer 
		String token = authHeader.substring(7);
		// GET the username from token
		String username = jwtService.getUsername(token);
		// Check if the user is not null and not yet authenticated
		
		
	}

}
