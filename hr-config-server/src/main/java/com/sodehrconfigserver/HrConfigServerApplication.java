package com.sodehrconfigserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class HrConfigServerApplication implements CommandLineRunner {
	
	
	@Value("${spring.cloud.config.server.git.username}")
	private String username;

	@Value("${spring.cloud.config.server.git.password}")
	private String pass;


	public static void main(String[] args) {
		SpringApplication.run(HrConfigServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("USERNAME = " + pass);
	}

}
