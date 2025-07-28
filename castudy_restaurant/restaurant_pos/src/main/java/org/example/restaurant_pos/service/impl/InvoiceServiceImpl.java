package org.example.restaurant_pos.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.restaurant_pos.entity.Invoice;
import org.example.restaurant_pos.repository.IInvoiceRepository;
import org.example.restaurant_pos.service.IInvoiceService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements IInvoiceService {

    private final IInvoiceRepository invoiceRepository;

    @Override
    public Invoice findById(Integer id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
    }

    @Override
    public Invoice findByOrderId(Integer orderId) {
        return invoiceRepository.findByOrderId(orderId)
                .orElseThrow(() -> new RuntimeException("Invoice not found by order"));
    }
}
