package com.sode.hrworker.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sode.hrworker.entities.Worker;
import com.sode.hrworker.repository.WorkerRepository;

@Configuration
public class DataLoad implements CommandLineRunner{
	
	@Autowired
	private WorkerRepository workerRepository;

	@Override
	public void run(String... args) throws Exception {
		
		workerRepository.deleteAll();
		
		Worker w1 = new Worker(null, "Bob", 200.0);
		Worker w2 = new Worker(null, "Maria", 300.0);
		Worker w3 = new Worker(null, "Alex", 250.0);
		
		workerRepository.saveAll(Arrays.asList(w1,w2,w3));
	
	}
	
	

}
