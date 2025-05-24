package com.sode.hrpayroll.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sode.hrpayroll.HrPayrollApplication;
import com.sode.hrpayroll.entities.Payment;
import com.sode.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value="/payments")
public class PaymentResource {

	@Autowired
	private PaymentService service;

	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value="/{id}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable long id, @PathVariable int days){
		
		Payment p = service.getPayment(id, days);
		
		return ResponseEntity.ok().body(p);
	}
	
	public ResponseEntity<Payment> getPaymentAlternative(long id, int days){
		
		Payment p = new Payment("null", 0., days);
		
		return ResponseEntity.ok().body(p);
	}
	

}
