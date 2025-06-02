package com.sode.hruser.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sode.hruser.entities.User;
import com.sode.hruser.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public User findById(Long id) {
		return repository.findById(id).get();
	}

}
