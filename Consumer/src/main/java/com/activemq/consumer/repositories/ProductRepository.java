package com.activemq.consumer.repositories;

import com.activemq.consumer.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
