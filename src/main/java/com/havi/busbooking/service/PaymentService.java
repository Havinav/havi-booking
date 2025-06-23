package com.havi.busbooking.service;


import org.springframework.stereotype.Service;

import com.havi.busbooking.model.Payment;
import com.havi.busbooking.repository.PaymentRepository;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment savePayment(Payment payment){
        payment.setPaymentStatus("SUCCESS");
        return paymentRepository.save(payment);
    }

    public Payment findByUserId(Integer userId){
        return paymentRepository.findById(userId).get();
    }
}
