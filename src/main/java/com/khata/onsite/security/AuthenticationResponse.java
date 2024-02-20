package com.khata.onsite.security;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AuthenticationResponse {

	private String token;
	public AuthenticationResponse(String generatedToken)
	{
		this.token = generatedToken;
	}
	
}
