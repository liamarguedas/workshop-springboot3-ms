package com.sode.hruser.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sode.hruser.repository.RoleRepository;
import com.sode.hruser.repository.UserRepository;

@Configuration
@Profile("dataloader")
public class Loader implements CommandLineRunner {
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public void run(String... args) throws Exception {
		

	}

}
