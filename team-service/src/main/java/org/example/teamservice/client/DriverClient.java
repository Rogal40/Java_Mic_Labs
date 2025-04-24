package org.example.teamservice.client;

import org.example.teamservice.model.DriverDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "driver-service")
public interface DriverClient {
    @GetMapping("/drivers")
    List<DriverDTO> getAllDrivers();
}
