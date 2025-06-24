package com.havi.busbooking.service;


<<<<<<< HEAD
import java.time.LocalDateTime;

=======
>>>>>>> 25e017cedb7c893c4c4de5571df215836756b255
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
<<<<<<< HEAD
        payment.setPaymentDate(LocalDateTime.now());
=======
>>>>>>> 25e017cedb7c893c4c4de5571df215836756b255
        return paymentRepository.save(payment);
    }

    public Payment findByUserId(Integer userId){
        return paymentRepository.findById(userId).get();
    }
}
