package com.kshitij189.fitnesstrackingapp.repository;

import com.kshitij189.fitnesstrackingapp.entity.PerformanceMetrics;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PerformanceMetricsRepository extends MongoRepository<PerformanceMetrics, String> {
}
