package org.example.restaurant_pos.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.restaurant_pos.enums.OrderStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer tableId;

    private Integer employeeId;

    private Integer reservationId;

    private LocalDateTime orderTime;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToOne(mappedBy = "order")
    private Invoice invoice;
}
