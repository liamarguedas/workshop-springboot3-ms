package com.sode.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sode.hroauth.entities.User;
import com.sode.hroauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService {
	
	Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findByEmail(String username) {
		
		User u = userFeignClient.findByEmail(username).getBody();
		
		if ( u == null ) {
			logger.error("Email not found: " + username);
			throw new IllegalArgumentException("Email not found");
		}
		
		logger.info("Email found: " + username);

		return u;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User u = userFeignClient.findByEmail(username).getBody();
		if ( u == null ) {
			logger.error("Email not found: " + username);
			throw new UsernameNotFoundException("Email not found");
		}

		logger.info("Email found: " + username);
		return u;
	
	}
}
