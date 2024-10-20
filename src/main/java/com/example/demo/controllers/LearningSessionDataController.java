package com.example.demo.controllers;

import com.example.demo.dto.LearningSessionDataDTO;
import com.example.demo.dto.MaxScoreDTO;
import com.example.demo.services.LearningSessionDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Learning")
public class LearningSessionDataController {

    private final LearningSessionDataService learningSessionDataService;

    public LearningSessionDataController(LearningSessionDataService learningSessionDataService) {
        this.learningSessionDataService = learningSessionDataService;
    }


    @PostMapping("/createLearningSessionData")
    public ResponseEntity<LearningSessionDataDTO> createLearningSessionData(@RequestBody LearningSessionDataDTO sessionDataDTO){
        LearningSessionDataDTO newLearningSession = learningSessionDataService.createLearningSession(sessionDataDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newLearningSession);
    }

    @DeleteMapping("/deleteSessionData/{id}")
    public ResponseEntity<Void> deleteSessionData(@PathVariable int id) {
        learningSessionDataService.deleteSession(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAllSessionData")
    public ResponseEntity<List<LearningSessionDataDTO>> getAllSessionData(){
        List<LearningSessionDataDTO> sessions = learningSessionDataService.getAllSessionData();
        return ResponseEntity.ok(sessions);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LearningSessionDataDTO>> getSessionsByUser(@PathVariable int userId) {
        List<LearningSessionDataDTO> sessions = learningSessionDataService.getSessionsDataByUser(userId);
        return ResponseEntity.ok(sessions);
    }

    @GetMapping("/learning-max-scores-username")
    public ResponseEntity<List<MaxScoreDTO>> getLearningMaxScoresWithUsernames() {
        List<MaxScoreDTO> maxScores = learningSessionDataService.getLearningMaxScoresWithUsernames();
        return ResponseEntity.ok(maxScores);
    }


}
