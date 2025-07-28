package org.example.restaurant_pos.repository;

import org.example.restaurant_pos.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer> {
    Optional<Payment> findByInvoiceId(Integer invoiceId);
}