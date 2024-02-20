package com.khata.onsite.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersEntity, Long>{
	
	Optional<UsersEntity> findByUsername(String username);

}
