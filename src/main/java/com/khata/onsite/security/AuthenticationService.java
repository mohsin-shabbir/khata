package com.khata.onsite.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.khata.onsite.security.impl.JWTService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

	private final UsersRepository usersRepository;
	
	private final JWTService jwtService;
	private final AuthenticationManager authenticationManager;
	private final PasswordEncoder passwordEncoder;

	public AuthenticationResponse register(UsersEntity user) {
		UsersEntity userModel = new UsersEntity();
		userModel.setUsername(user.getUsername());
		userModel.setFirstName(user.getFirstName());
		userModel.setLastName(user.getLastName());
		userModel.setPassword(passwordEncoder.encode(user.getPassword()));
		userModel.setRole(user.getRole());
		usersRepository.save(userModel);

		String token = jwtService.generateToken(user);
		return new AuthenticationResponse(token);

	}

	public AuthenticationResponse authenticate(UsersEntity request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		UsersEntity user = usersRepository.findByUsername(request.getUsername()).orElseThrow();
		String token = jwtService.generateToken(user);
		return new AuthenticationResponse(token);
	}

}
