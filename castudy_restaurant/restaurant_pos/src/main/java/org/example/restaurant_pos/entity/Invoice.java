package org.example.restaurant_pos.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "invoices")
@Data
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private Integer voucherId;

    private BigDecimal totalAmount;

    @OneToOne(mappedBy = "invoice", cascade = CascadeType.ALL)
    private Payment payment;
}
