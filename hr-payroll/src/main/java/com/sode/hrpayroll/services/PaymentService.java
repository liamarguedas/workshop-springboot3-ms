package com.sode.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.sode.hrpayroll.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(long workerId, int days) {
		
		// CHAMAR SERVIÇO DE WORKER //
		
		return new Payment("Nome Test",  100.0, days);
		
	}

}
