package com.example.demo.controllers;

import com.example.demo.dto.MaxScoreDTO;
import com.example.demo.dto.ReflexSessionDataDTO;
import com.example.demo.services.ReflexSessionDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reflexSessionData")
public class ReflexSessionDataController {

    private final ReflexSessionDataService reflexSessionDataService;

    public ReflexSessionDataController(ReflexSessionDataService reflexSessionDataService) {
        this.reflexSessionDataService = reflexSessionDataService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ReflexSessionDataDTO>> getAllReflexSessionData() {
        List<ReflexSessionDataDTO> sessions = reflexSessionDataService.getAllReflexSessionData();
        return ResponseEntity.ok(sessions);
    }

    @PostMapping("/create")
    public ResponseEntity<ReflexSessionDataDTO> createReflexSessionData(@RequestBody ReflexSessionDataDTO reflexSessionDataDTO) {
        ReflexSessionDataDTO createdSession = reflexSessionDataService.createReflexSessionData(reflexSessionDataDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSession);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ReflexSessionDataDTO> getReflexSessionDataById(@PathVariable int id) {
        ReflexSessionDataDTO sessionData = reflexSessionDataService.getReflexSessionDataById(id);
        return ResponseEntity.ok(sessionData);
    }

    @GetMapping("/getReflexSessionsByUserId/{userId}")
    public ResponseEntity<List<ReflexSessionDataDTO>> getReflexSessionsByUserId(@PathVariable int userId) {
        List<ReflexSessionDataDTO> sessionData = reflexSessionDataService.getReflexSessionsByUserId(userId);
        return ResponseEntity.ok(sessionData);
    }


    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteReflexSessionData(@PathVariable int id) {
        reflexSessionDataService.deleteReflexSessionData(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/countByUserId/{userId}")
    public ResponseEntity<Long> countReflexSessionsByUserId(@PathVariable int userId) {
        long count = reflexSessionDataService.countReflexSessionsByUserId(userId);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/bestScore")
    public ResponseEntity<Integer> getBestGlobalScore() {
        Integer bestScore = reflexSessionDataService.getBestScore();
        return ResponseEntity.ok(bestScore);
    }

    @GetMapping("/bestScoreByUserId/{userId}")
    public ResponseEntity<Integer> getBestScoreByUserId(@PathVariable int userId) {
        Integer bestScore = reflexSessionDataService.getBestScoreByUserId(userId);
        return ResponseEntity.ok(bestScore);
    }

    @GetMapping("/reflex-max-scores-username")
    public ResponseEntity<List<MaxScoreDTO>> getReflexMaxScoresWithUsernames() {
        List<MaxScoreDTO> maxScores = reflexSessionDataService.getReflexMaxScoresWithUsernames();
        return ResponseEntity.ok(maxScores);
    }


}
