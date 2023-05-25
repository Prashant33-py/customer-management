package com.customer.management.Orders.repository;

import com.customer.management.Orders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByOrderId(Long orderId);
}
