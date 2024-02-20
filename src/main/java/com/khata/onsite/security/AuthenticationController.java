package com.khata.onsite.security;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
public class AuthenticationController {

	private final AuthenticationService authService;

	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody UsersEntity request) {

		return ResponseEntity.ok(authService.register(request));
	}

	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> login(@RequestBody UsersEntity request) {

		return ResponseEntity.ok(authService.authenticate(request));
	}
	
	@GetMapping("userAndAdminAccess")
	public ResponseEntity<String> userRolePath() {
		return ResponseEntity.ok("Its valid for both user and admin token.");
	}
	
	@GetMapping("adminAccessOnly")
	public ResponseEntity<String> adminAccessOnly() {
		return ResponseEntity.ok("Its valid for admin token only.");
	}

}
