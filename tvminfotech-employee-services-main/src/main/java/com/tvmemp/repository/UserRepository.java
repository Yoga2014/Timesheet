package com.tvmemp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tvmemp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	/**
	 * 
	 * @param email
	 * @return
	 */
	Optional<User> findByEmail(String email);
}
