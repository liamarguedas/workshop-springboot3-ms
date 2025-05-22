package com.sode.hrworker.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sode.hrworker.entities.Worker;
import com.sode.hrworker.service.WorkerService;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	@Autowired
	private WorkerService service;
	
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){

		List<Worker> w = service.findAll();
		
		return ResponseEntity.ok().body(w);
	} 
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		Worker w = service.findById(id);
		return ResponseEntity.ok().body(w);
	}


}
