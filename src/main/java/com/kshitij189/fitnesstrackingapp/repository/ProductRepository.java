package com.kshitij189.fitnesstrackingapp.repository;

import com.kshitij189.fitnesstrackingapp.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    Optional<Product> findByCode(Integer code);
}
