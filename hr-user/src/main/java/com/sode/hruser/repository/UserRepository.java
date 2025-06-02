package com.sode.hruser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sode.hruser.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {
	
	User findByEmail(String email);

}
