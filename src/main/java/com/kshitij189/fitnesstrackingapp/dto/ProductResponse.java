package com.kshitij189.fitnesstrackingapp.dto;

public record ProductResponse(
        String description,
        String name,
        Integer calories,
        Double protein,
        Double carbs,
        Double fat,
        Integer code,
        String image
) {
}
