package com.khata.onsite.security.service;

import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.khata.onsite.security.entity.Users;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
	
	// Need a secret key to generate token	
	private final String  SECRECT_KEY= "4bb6d1dfbafb64a681139d1586b6f1160d18159afd57c8c79136d7490630407c";
	
	//Now create a method to generate token	
	public String generateToken(Users user)
	{
		String token = Jwts
				.builder()
				.subject(user.getUsername())
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 24*60*60* 1000))
				.signWith(geSigninKey())
				.compact();		
		return token;		
	}
	
	
	// Extract claims based on token i.e what type of token it is what permission is granted to this token	
	private Claims extractAllClaims(String token)
	{
		return Jwts
				.parser()
				.verifyWith(geSigninKey())
				.build()
				.parseSignedClaims(token)
				.getPayload();
	}
	
	// To Get the specific claim, this method will be helpfull in next step
	public <T> T extractClaim(String token , Function<Claims, T> resolver)
	{
		Claims claims = extractAllClaims(token);
		return resolver.apply(claims);	
	}
	
	// To Extact a specific parameter like username
	public String getUsername(String token)
	{
		return extractClaim(token, Claims::getSubject); // As we set username in subject during token generation.
	}
	
	//Let validate the token either its belongs to same user or different
	public boolean isValidToken(String token , UserDetails user)
	{
		String username = getUsername(token);
		return (username.equals(user.getUsername())) && !isTokenExpired(token);
	}
	
	private boolean isTokenExpired(String token) {
		// TODO Auto-generated method stub
		return tokenExpiration(token).before(new Date());
	}


	private Date tokenExpiration(String token) {
		
		return extractClaim(token, Claims::getExpiration);
	}


	private SecretKey geSigninKey() {
		// TODO Auto-generated method stub
		byte[] keyBytes = Decoders.BASE64URL.decode(SECRECT_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	/// to get the
}
