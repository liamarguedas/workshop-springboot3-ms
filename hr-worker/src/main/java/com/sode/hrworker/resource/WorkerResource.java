package com.sode.hrworker.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sode.hrworker.entities.Worker;
import com.sode.hrworker.service.WorkerService;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	@Value("${test.config}")
	private String testConfig;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerService service;
	
	
	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfig() {
		
		logger.info("CONFIG FILE = " + testConfig);
		
		
		return ResponseEntity.noContent().build();
	}
	
	
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){

		List<Worker> w = service.findAll();
		
		return ResponseEntity.ok().body(w);
	} 
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
		Worker w = service.findById(id);
		return ResponseEntity.ok().body(w);
	}


}
