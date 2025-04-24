package org.example.raceservice.repository;

import org.example.raceservice.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceRepository extends JpaRepository<Race, Long> {}
