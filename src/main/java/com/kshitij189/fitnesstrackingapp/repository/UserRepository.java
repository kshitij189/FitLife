package com.kshitij189.fitnesstrackingapp.repository;

import com.kshitij189.fitnesstrackingapp.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String > {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
