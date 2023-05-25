package com.customer.management.Product.service.impl;

import com.customer.management.Product.model.Product;
import com.customer.management.Product.repository.ProductRepository;
import com.customer.management.Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> addProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findByProductId(productId);
    }
}
