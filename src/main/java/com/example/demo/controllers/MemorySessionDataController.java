package com.example.demo.controllers;

import com.example.demo.dto.MaxScoreDTO;
import com.example.demo.dto.MemorySessionDataDTO;
import com.example.demo.services.MemorySessionDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/memory")
public class MemorySessionDataController {

    private final MemorySessionDataService memorySessionDataService;

    public MemorySessionDataController(MemorySessionDataService memorySessionDataService) {
        this.memorySessionDataService = memorySessionDataService;
    }

    @PostMapping("/createMemorySessionData")
    public ResponseEntity<MemorySessionDataDTO> createMemorySessionData(@RequestBody MemorySessionDataDTO sessionDataDTO) {
        MemorySessionDataDTO newMemorySession = memorySessionDataService.createMemorySession(sessionDataDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMemorySession);
    }

    @DeleteMapping("/deleteSessionData/{id}")
    public ResponseEntity<Void> deleteSessionData(@PathVariable int id) {
        memorySessionDataService.deleteSession(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAllSessionData")
    public ResponseEntity<List<MemorySessionDataDTO>> getAllSessionData() {
        List<MemorySessionDataDTO> sessions = memorySessionDataService.getAllSessionData();
        return ResponseEntity.ok(sessions);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<MemorySessionDataDTO>> getSessionsByUser(@PathVariable int userId) {
        List<MemorySessionDataDTO> sessions = memorySessionDataService.getSessionsDataByUser(userId);
        return ResponseEntity.ok(sessions);
    }

    @GetMapping("/memory-max-scores-username")
    public ResponseEntity<List<MaxScoreDTO>> getMemoryMaxScoresWithUsernames() {
        List<MaxScoreDTO> maxScores = memorySessionDataService.getMemoryMaxScoresWithUsernames();
        return ResponseEntity.ok(maxScores);
    }
}
