package com.kshitij189.fitnesstrackingapp.dto;

public record PerformanceMetricsResponse(
        Double duration,
        Integer caloriesBurned,
        Integer intensity
) {
}
