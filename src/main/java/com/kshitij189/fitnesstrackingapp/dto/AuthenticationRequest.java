package com.kshitij189.fitnesstrackingapp.dto;

public record AuthenticationRequest(
        String email,
        String password
) {
}
