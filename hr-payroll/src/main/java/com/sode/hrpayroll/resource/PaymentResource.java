package com.sode.hrpayroll.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sode.hrpayroll.HrPayrollApplication;
import com.sode.hrpayroll.entities.Payment;
import com.sode.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value="/payments")
public class PaymentResource {

    private final HrPayrollApplication hrPayrollApplication;
	
	
	@Autowired
	private PaymentService service;


    PaymentResource(HrPayrollApplication hrPayrollApplication) {
        this.hrPayrollApplication = hrPayrollApplication;
    }
	
	
	@GetMapping(value="/{id}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable long id, @PathVariable int days){
		
		Payment p = service.getPayment(id, days);
		
		return ResponseEntity.ok().body(p);
		
		
	}

}
