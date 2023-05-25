package com.customer.management.Customer.service;


import com.customer.management.Customer.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer addCustomer(Customer customer);
    Customer getCustomerById(Long customerId);
}
