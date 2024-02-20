package com.khata.onsite.security.impl;

import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.khata.onsite.security.UsersEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
	
	//Need a secret key to generate token HS256 key
	private final String  SECRECT_KEY= "4bb6d1dfbafb64a681139d1586b6f1160d18159afd57c8c79136d7490630407c";
	
	//Now create a method to generate token	
	public String generateToken(UsersEntity user)
	{
		String token = Jwts
				.builder()
				.subject(user.getUsername()) // will be the unique parameter from users data
				.issuedAt(new Date(System.currentTimeMillis())) // The datatime when token is being issued
				.expiration(new Date(System.currentTimeMillis() + 24*60*60*1000)) // The datetime when token will be expired
				.signWith(geSigninKey()) //Signature key atau salt key
				.compact();		
		return token;		
	}	
	
	//Extract claims based on token i.e what type of token it is what permission is granted to this token	
	private Claims extractAllClaims(String token)
	{
		return Jwts
				.parser()
				.verifyWith(geSigninKey())
				.build()
				.parseSignedClaims(token)
				.getPayload();
	}
	
	//To Get the specific claim, this method will be helpful in next step
	public <T> T extractClaim(String token , Function<Claims, T> resolver)
	{
		//the `resolver` function is a functional interface that takes a `Claims` object as input and returns a result of type `T`
		Claims claims = extractAllClaims(token);
		return resolver.apply(claims);	
	}
	
	//To Extract a specific parameter like user name
	public String getUsername(String token)
	{
		return extractClaim(token, Claims::getSubject); // As we set user name in subject during token generation.
	}
	// :: use to call a method by its class name.
	
	
	//Lets validate the token either its belongs to same user or different
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
		//GET he base64 encoded key
		byte[] keyBytes = Decoders.BASE64URL.decode(SECRECT_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
