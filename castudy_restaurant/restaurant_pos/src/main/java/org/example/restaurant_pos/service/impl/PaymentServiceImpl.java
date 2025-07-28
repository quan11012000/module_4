package org.example.restaurant_pos.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.restaurant_pos.entity.Payment;
import org.example.restaurant_pos.repository.IPaymentRepository;
import org.example.restaurant_pos.service.IPaymentService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements IPaymentService {

    private final IPaymentRepository paymentRepository;

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment findByInvoiceId(Integer invoiceId) {
        return paymentRepository.findByInvoiceId(invoiceId)
                .orElseThrow(() -> new RuntimeException("Payment not found by invoice"));
    }
}
