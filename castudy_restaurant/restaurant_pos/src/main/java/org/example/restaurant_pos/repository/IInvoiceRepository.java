package org.example.restaurant_pos.repository;

import org.example.restaurant_pos.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IInvoiceRepository extends JpaRepository<Invoice, Integer> {
    Optional<Invoice> findByOrderId(Integer orderId);
}