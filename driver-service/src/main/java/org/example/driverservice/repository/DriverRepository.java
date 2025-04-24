package org.example.driverservice.repository;

import org.example.driverservice.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {}
