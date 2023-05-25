package com.customer.management.Orders.service.impl;

import com.customer.management.Orders.model.Order;
import com.customer.management.Orders.model.Product;
import com.customer.management.Orders.repository.OrderRepository;
import com.customer.management.Orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RestTemplate restTemplate;
    private final String productUrl = "http://PRODUCT-SERVICE/products";


    @Override
    public List<Order> getOrders() {
        List<Order> orders = orderRepository.findAll();
        orders.forEach(this::getOrderedProductsAndPrices);
        return orders;
    }

    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long orderId) {
        Order order = orderRepository.findByOrderId(orderId);
        getOrderedProductsAndPrices(order);
        return order;
    }

    @Override
    public Double getOrderTotal(List<Double> prices) {
        double orderTotal = 0;
        for (Double price : prices) {
            orderTotal += price;
        }
        return orderTotal;
    }

    @Override
    public Order getOrderedProductsAndPrices(Order order) {
        List<Long> orderedProductIds =  order.getProductId();
        List<Product> orderedProducts = order.getOrderedProducts();
        List<Double> productPrices = new ArrayList<>();
        orderedProductIds.forEach(productId -> {
            Product product = restTemplate.getForObject(productUrl+"/"+productId, Product.class);
            productPrices.add(product.getProductPrice());
            orderedProducts.add(product);
        });
        BigDecimal bd = BigDecimal.valueOf(getOrderTotal(productPrices)).setScale(2, RoundingMode.CEILING);
        order.setOrderTotal(bd.doubleValue());
        order.setOrderedProducts(orderedProducts);
        return order;
    }
}
