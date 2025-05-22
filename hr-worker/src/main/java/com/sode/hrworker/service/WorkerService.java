package com.sode.hrworker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sode.hrworker.entities.Worker;
import com.sode.hrworker.repository.WorkerRepository;

@Service
public class WorkerService {
	
	
	@Autowired
	private WorkerRepository repository;
	
	
	public List<Worker> findAll(){
		return repository.findAll();
	}
	
	public Worker findById(Long id) {
		return repository.findById(id).get();
	}

}
