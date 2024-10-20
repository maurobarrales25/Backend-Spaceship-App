package com.example.demo.controllers;

import com.example.demo.dto.MaxScoreDTO;
import com.example.demo.dto.SessionDataDTO;
import com.example.demo.services.SessionDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/sessionData")
public class SessionDataController {

    private final SessionDataService sessionDataService;

    public SessionDataController(SessionDataService sessionDataService) {
        this.sessionDataService = sessionDataService;
    }

    @GetMapping("/getAllSessionData")
    public ResponseEntity<List<SessionDataDTO>> getAllSessionData(){
        List<SessionDataDTO> sessions = sessionDataService.getAllSessionData();
        return ResponseEntity.ok(sessions);
    }

    @PostMapping("/createSessionData")
    public ResponseEntity<SessionDataDTO> createSessionData(@RequestBody SessionDataDTO sessionDataDTO){
        SessionDataDTO createdSession = sessionDataService.createSessionData(sessionDataDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSession);
    }

    @GetMapping("/getSessionData/{id}")
    public ResponseEntity<SessionDataDTO> getSessionDataById(@PathVariable int id) {
        SessionDataDTO sessionData = sessionDataService.getSessionDataByID(id);
        return ResponseEntity.ok(sessionData);
    }

    @DeleteMapping("/deleteSessionData/{id}")
    public ResponseEntity<Void> deleteSessionData(@PathVariable int id) {
        sessionDataService.deleteSession(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getSessionDataByUser/{userId}")
    public ResponseEntity<List<SessionDataDTO>> getSessionDataByUser(@PathVariable int userId) {
        List<SessionDataDTO> sessions = sessionDataService.getSessionDataByUser(userId);
        return ResponseEntity.ok(sessions);
    }

    @GetMapping("/getMusicalSessionDataByUserId/{userId}")
    public ResponseEntity<List<SessionDataDTO>> getMusicalSessionDataByUserId(@PathVariable int userId) {
        List<SessionDataDTO> sessions = sessionDataService.getMusicalSessionDataByUserId(userId);
        return ResponseEntity.ok(sessions);
    }

    @GetMapping("/getMemorySessionDataByUserId/{userId}")
    public ResponseEntity<List<SessionDataDTO>> getMemorySessionDataByUserId(@PathVariable int userId) {
        List<SessionDataDTO> sessions = sessionDataService.getMemorySessionDataByUserId(userId);
        return ResponseEntity.ok(sessions);
    }

    @GetMapping("/getLearningSessionDataByUserId/{userId}")
    public ResponseEntity<List<SessionDataDTO>> getLearningSessionDataByUserId(@PathVariable int userId) {
        List<SessionDataDTO> sessions = sessionDataService.getLearningSessionDataByUserId(userId);
        return ResponseEntity.ok(sessions);
    }

    @GetMapping("/learning-max-scores")
    public ResponseEntity<List<MaxScoreDTO>> getLearningMaxScoresWithUsernames() {
        List<MaxScoreDTO> maxScores = sessionDataService.getLearningMaxScoresWithUsernames();
        return ResponseEntity.ok(maxScores);
    }

    @GetMapping("/memory-max-scores")
    public ResponseEntity<List<MaxScoreDTO>> getMemoryMaxScoresWithUsernames() {
        List<MaxScoreDTO> maxScores = sessionDataService.getMemoryMaxScoresWithUsernames();
        return ResponseEntity.ok(maxScores);
    }

    @GetMapping("/musical-max-scores")
    public ResponseEntity<List<MaxScoreDTO>> getMusicalMaxScoresWithUsernames() {
        List<MaxScoreDTO> maxScores = sessionDataService.getMusicalMaxScoresWithUsernames();
        return ResponseEntity.ok(maxScores);
    }
}
