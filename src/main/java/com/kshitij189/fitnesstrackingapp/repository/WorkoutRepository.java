package com.kshitij189.fitnesstrackingapp.repository;

import com.kshitij189.fitnesstrackingapp.entity.Workout;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface WorkoutRepository extends MongoRepository<Workout, String> {

    Optional<Workout> findByworkoutDate(LocalDate date);
}
