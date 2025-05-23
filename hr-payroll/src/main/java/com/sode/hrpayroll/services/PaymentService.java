package com.sode.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sode.hrpayroll.entities.Payment;
import com.sode.hrpayroll.entities.Worker;
import com.sode.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeignClient;
	

	public Payment getPayment(long workerId, int days) {
		
		Worker w = workerFeignClient.findById(workerId).getBody();
		return new Payment(w.getName(), w.getDailyIncome(), days);
		
	}

}
