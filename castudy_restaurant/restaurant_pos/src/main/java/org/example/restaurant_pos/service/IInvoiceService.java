package org.example.restaurant_pos.service;

import org.example.restaurant_pos.entity.Invoice;

public interface IInvoiceService {
    Invoice findById(Integer id);
    Invoice findByOrderId(Integer orderId);
}