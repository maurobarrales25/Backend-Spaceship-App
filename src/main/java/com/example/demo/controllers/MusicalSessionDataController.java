package com.example.demo.controllers;

import com.example.demo.dto.MusicalSessionDataDTO;
import com.example.demo.dto.MaxScoreDTO;
import com.example.demo.services.MusicalSessionDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Musical")
public class MusicalSessionDataController {

    private final MusicalSessionDataService musicalSessionDataService;

    public MusicalSessionDataController(MusicalSessionDataService musicalSessionDataService) {
        this.musicalSessionDataService = musicalSessionDataService;
    }

    @PostMapping("/createMusicalSessionData")
    public ResponseEntity<MusicalSessionDataDTO> createMusicalSessionData(@RequestBody MusicalSessionDataDTO sessionDataDTO) {
        MusicalSessionDataDTO newMusicalSession = musicalSessionDataService.createMusicalSession(sessionDataDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMusicalSession);
    }

    @DeleteMapping("/deleteSessionData/{id}")
    public ResponseEntity<Void> deleteSessionData(@PathVariable int id) {
        musicalSessionDataService.deleteSession(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAllSessionData")
    public ResponseEntity<List<MusicalSessionDataDTO>> getAllSessionData() {
        List<MusicalSessionDataDTO> sessions = musicalSessionDataService.getAllSessionData();
        return ResponseEntity.ok(sessions);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<MusicalSessionDataDTO>> getSessionsByUser(@PathVariable int userId) {
        List<MusicalSessionDataDTO> sessions = musicalSessionDataService.getSessionsDataByUser(userId);
        return ResponseEntity.ok(sessions);
    }

    @GetMapping("/musical-max-scores-username")
    public ResponseEntity<List<MaxScoreDTO>> getMusicalMaxScoresWithUsernames() {
        List<MaxScoreDTO> maxScores = musicalSessionDataService.getMusicalMaxScoresWithUsernames();
        return ResponseEntity.ok(maxScores);
    }
}
