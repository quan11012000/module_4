package org.example.restaurant_pos.service;

import org.example.restaurant_pos.entity.Payment;

public interface IPaymentService {
    Payment save(Payment payment);
    Payment findByInvoiceId(Integer invoiceId);
}
