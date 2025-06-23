package com.havi.busbooking.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.havi.busbooking.model.Payment;
import com.havi.busbooking.service.PaymentService;

@RestController
@RequestMapping("/v1/payment")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<?> savePayment(@RequestBody Payment payment){
      Payment savePayment=  paymentService.savePayment(payment);

       if(savePayment.getId() != null){
           return ResponseEntity.ok(savePayment);
       }
       return ResponseEntity.noContent().build();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<?> findByUserId(@PathVariable Integer id){
        Payment payment = paymentService.findByUserId(id);
        if(payment != null){
            return ResponseEntity.ok(payment);
        }
        return ResponseEntity.noContent().build();
    }

}
