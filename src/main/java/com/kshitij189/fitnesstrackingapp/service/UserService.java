package com.kshitij189.fitnesstrackingapp.service;

import com.kshitij189.fitnesstrackingapp.dto.ProductResponse;
import com.kshitij189.fitnesstrackingapp.dto.UserCredentials;
import com.kshitij189.fitnesstrackingapp.dto.UserResponse;
import com.kshitij189.fitnesstrackingapp.entity.User;
import com.kshitij189.fitnesstrackingapp.repository.ProductRepository;
import com.kshitij189.fitnesstrackingapp.repository.UserRepository;
import com.kshitij189.fitnesstrackingapp.util.Convertor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class UserService {

    private final Convertor convertor;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;


    public UserResponse getUserInfo(Authentication authentication) {

        var user = (User) authentication.getPrincipal();

        var retrievedUser = userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return convertor.userToResponseDto(retrievedUser);
    }


    public UserCredentials getUserCredentialsOnly(Authentication authentication) {

        var user = (User) authentication.getPrincipal();

        var retrievedUser = userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return convertor.userCredentialsToDto(retrievedUser);
    }

    public List<ProductResponse> getUsersProducts(Authentication authentication) {

        var user = (User) authentication.getPrincipal();

        var retrievedUser = userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return convertor.productMapper(retrievedUser.getProducts());
    }

    public ResponseEntity<?> addProduct(Authentication authentication, Integer code) {

        var user = (User) authentication.getPrincipal();

        var retrievedUser = userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        var product = productRepository.findByCode(code)
                .orElseThrow(() -> new NoSuchElementException("Product does not exist"));

        retrievedUser.setProducts(List.of(product));

        userRepository.save(retrievedUser);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
