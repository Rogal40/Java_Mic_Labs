package org.example.raceservice.controller;

import org.example.raceservice.model.Race;
import org.example.raceservice.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/races")
public class RaceController {

    private final RaceRepository raceRepository;

    @Autowired
    public RaceController(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @PostMapping
    public Race create(@RequestBody Race race) {
        return raceRepository.save(race);
    }

    @GetMapping("/{id}")
    public Race getRace(@PathVariable Long id) {
        return raceRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<Race> getAll() {
        return raceRepository.findAll();
    }

    @GetMapping("/winner")
    public String getLastWinner() {
        return raceRepository.findAll().stream()
                .sorted((r1, r2) -> r2.getDate().compareTo(r1.getDate()))
                .findFirst()
                .flatMap(r -> r.getResults().stream()
                        .filter(res -> res.getPosition() == 1)
                        .findFirst()
                        .map(res -> res.getDriverName()))
                .orElse("No winner yet");
    }
}
