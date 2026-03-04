package com.kshitij189.fitnesstrackingapp;

import com.kshitij189.fitnesstrackingapp.dto.RegisterRequest;
import com.kshitij189.fitnesstrackingapp.entity.Role;
import com.kshitij189.fitnesstrackingapp.entity.User;
import com.kshitij189.fitnesstrackingapp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

import static com.kshitij189.fitnesstrackingapp.entity.Role.ADMIN;

@SpringBootApplication
public class FitnessTrackingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitnessTrackingAppApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(PasswordEncoder passwordEncoder, UserRepository userRepository) {
//		return args -> {
//
//			var admin = User.builder()
//					.firstname("admin")
//					.lastname("admin")
//					.email("admin@mail.com")
//					.password(passwordEncoder.encode("admin"))
//					.role(ADMIN)
//					.build();
//
//			userRepository.save(admin);
//
//		};
//	}
}
