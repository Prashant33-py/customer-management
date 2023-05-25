package com.customer.management.Customer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    private Long customerId;
    private String customerName;
    private String customerEmail;
    private String customerContactNumber;
    private String customerAddress;
    @Transient
    private List<Order> customerOrders = new ArrayList<Order>();

}
