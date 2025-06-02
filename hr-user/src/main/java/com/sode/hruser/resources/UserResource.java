package com.sode.hruser.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sode.hruser.entities.User;
import com.sode.hruser.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		
		User u = service.findById(id);
		return ResponseEntity.ok().body(u);
		
	}

	@GetMapping("/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email){
		
		User u = service.findByEmail(email);
		
		return ResponseEntity.ok().body(u);
		
	}

	
}
