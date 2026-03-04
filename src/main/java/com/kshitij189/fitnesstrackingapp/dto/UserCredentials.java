package com.kshitij189.fitnesstrackingapp.dto;

import java.time.LocalDate;

public record UserCredentials(
        String firstname,
        String lastname,
        String email,
        LocalDate dateOfBirth
) {
}
