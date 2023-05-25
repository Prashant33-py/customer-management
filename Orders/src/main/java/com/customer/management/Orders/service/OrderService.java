package com.customer.management.Orders.service;


import com.customer.management.Orders.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrders();
    Order addOrder(Order order);
    Order getOrderById(Long orderId);
    Double getOrderTotal(List<Double> prices);

    Order getOrderedProductsAndPrices(Order order);

}
