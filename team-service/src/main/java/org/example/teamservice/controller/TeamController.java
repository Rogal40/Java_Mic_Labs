package org.example.teamservice.controller;

import org.example.teamservice.client.DriverClient;
import org.example.teamservice.model.Team;
import org.example.teamservice.repository.TeamRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamRepository teamRepository;
    private final DriverClient driverClient;

    public TeamController(TeamRepository teamRepository, DriverClient driverClient) {
        this.teamRepository = teamRepository;
        this.driverClient = driverClient;
    }

    @GetMapping
    public List<Team> getAll() {
        List<Team> teams = teamRepository.findAll();
        teams.forEach(team -> team.setDrivers(
                driverClient.getAllDrivers().stream()
                        .filter(driver -> team.getName().equals(driver.getTeam()))
                        .toList()
        ));
        return teams;
    }

    @PostMapping
    public Team create(@RequestBody Team team) {
        return teamRepository.save(team);
    }

    @GetMapping("/{id}")
    public Team getById(@PathVariable Long id) {
        return teamRepository.findById(id).map(team -> {
            team.setDrivers(
                    driverClient.getAllDrivers().stream()
                            .filter(driver -> team.getName().equals(driver.getTeam()))
                            .toList()
            );
            return team;
        }).orElse(null);
    }
}
