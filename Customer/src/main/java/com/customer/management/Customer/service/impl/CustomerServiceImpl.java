package com.customer.management.Customer.service.impl;

import com.customer.management.Customer.model.Customer;
import com.customer.management.Customer.model.Order;
import com.customer.management.Customer.repository.CustomerRepository;
import com.customer.management.Customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RestTemplate restTemplate;

    private String ordersUrl = "http://ORDER-SERVICE/orders";
    private String productsUrl = "http://PRODUCT-SERVICE/orders";
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        Customer customer = customerRepository.findByCustomerId(customerId);
        Order[] customerOrders = restTemplate.getForObject(ordersUrl, Order[].class);
        List<Order> ordersList = Arrays.stream(customerOrders).toList();
        List<Order> customerOrdersList = customer.getCustomerOrders();

        ordersList.forEach(order -> {
            if (order.getCustomerId() == customer.getCustomerId()) {
                customerOrdersList.add(order);
            }
        });

        customer.setCustomerOrders(customerOrdersList);
        return customer;

    }
}
