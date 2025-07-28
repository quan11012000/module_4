package org.example.restaurant_pos.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.restaurant_pos.enums.PaymentMethod;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @Enumerated(EnumType.STRING)
    private PaymentMethod method;

    private BigDecimal amount;

    private LocalDateTime paymentTime;
}


