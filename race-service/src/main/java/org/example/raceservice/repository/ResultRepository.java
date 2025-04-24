package org.example.raceservice.repository;

import org.example.raceservice.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Long> {}
