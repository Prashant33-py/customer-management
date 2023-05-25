package com.customer.management.Orders.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    private Long orderId;
    private LocalDateTime orderDate = LocalDateTime.now();
    private Long customerId;
    private List<Long> productId = new ArrayList<>();
    @Transient
    private Double orderTotal;
    @Transient
    private List<Product> orderedProducts = new ArrayList<>();

}
