package com.activemq.consumer.service;

import com.activemq.consumer.models.Product;
import com.activemq.consumer.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public void saveProduct(Product product) {
        repo.save(product);
    }

    public Product getProduct(Integer id) {
        return repo.findById(id).get();
    }

    public List<Product> getAllProduct() {
        return repo.findAll();
    }
}
