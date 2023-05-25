package com.customer.management.Customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private long orderId;
    private Date orderDate;
    private long orderTotal;
    private long customerId;
    private List<Long> productId = new ArrayList<Long>();
    private List<Product> orderedProducts = new ArrayList<>();
}
