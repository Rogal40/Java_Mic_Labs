package org.example.driverservice.controller;

import org.example.driverservice.model.Driver;
import org.example.driverservice.repository.DriverRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    private final DriverRepository driverRepository;

    public DriverController(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @GetMapping
    public List<Driver> getAll() {
        return driverRepository.findAll();
    }

    @PostMapping
    public Driver create(@RequestBody Driver driver) {
        return driverRepository.save(driver);
    }

    @GetMapping("/{id}")
    public Driver getById(@PathVariable Long id) {
        return driverRepository.findById(id).orElse(null);
    }
}
