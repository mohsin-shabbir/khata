package com.khata.onsite.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khata.onsite.security.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{
	
	Optional<Users> findByUsername(String username);

}
