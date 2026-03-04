package com.kshitij189.fitnesstrackingapp.service;

import com.kshitij189.fitnesstrackingapp.dto.RegisterRequest;
import com.kshitij189.fitnesstrackingapp.entity.Role;
import com.kshitij189.fitnesstrackingapp.entity.User;
import com.kshitij189.fitnesstrackingapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.kshitij189.fitnesstrackingapp.entity.Role.USER;

@RequiredArgsConstructor
@Service
public class RegisterService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public ResponseEntity<?> registerUser(RegisterRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        var user = User.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .dateOfBirth(request.dateOfBirth())
                .password(passwordEncoder.encode(request.password()))
                .role(USER)
                .build();

        userRepository.save(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
