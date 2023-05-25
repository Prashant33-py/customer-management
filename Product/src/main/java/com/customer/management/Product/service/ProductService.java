package com.customer.management.Product.service;

import com.customer.management.Product.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    List<Product> addProducts(List<Product> products);

    Product getProductById(Long productId);
}
