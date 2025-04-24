package org.example.teamservice.repository;

import org.example.teamservice.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {}
