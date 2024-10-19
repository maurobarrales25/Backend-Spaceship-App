package com.example.demo.controllers;

import com.example.demo.dto.GameSessionDTO;
import com.example.demo.services.GameSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/gameSession")
public  class GameSessionController {

    @Autowired
    private GameSessionService gameSessionService;

    @GetMapping("/getAllGameSessions")
    public ResponseEntity<List<GameSessionDTO>> getAllGameSession() {
        List<GameSessionDTO> gameSessions = gameSessionService.getAllGameSessions();
        return ResponseEntity.ok(gameSessions);
    }

    @GetMapping("/getGameSessionById/{id}")
    public ResponseEntity<GameSessionDTO> getGameSessionById(@PathVariable("id") int id) {
        GameSessionDTO session = gameSessionService.getGameSessionById(id);
        return ResponseEntity.ok(session);
    }

    @GetMapping("/getGameSessionsByUserId/{userId}")
    public ResponseEntity<List<GameSessionDTO>> getGameSessionsByUserId(@PathVariable("userId") int userId) {
        List<GameSessionDTO> sessions = gameSessionService.getGameSessionsByUserId(userId);
        return ResponseEntity.ok(sessions);
    }

    @PostMapping("/createGameSession")
    public ResponseEntity<GameSessionDTO> createGameSession(@RequestBody GameSessionDTO gameSessionDTO){
        GameSessionDTO gameSession = gameSessionService.createGameSession(gameSessionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(gameSession);
    }

    @DeleteMapping("/deleteGameSession/{id}")
    public ResponseEntity<Void> deleteGameSession(@PathVariable("id") Integer gameSessionId){
        gameSessionService.deleteGameSessionById(gameSessionId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getReflexSessions")
    public ResponseEntity<List<GameSessionDTO>> getReflexSessions() {
        List<GameSessionDTO> sessions = gameSessionService.getReflexSessions();
        return ResponseEntity.ok(sessions);
    }

    @GetMapping("/getMemorySessions")
    public ResponseEntity<List<GameSessionDTO>> getMemorySessions() {
        List<GameSessionDTO> sessions = gameSessionService.getMemorySessions();
        return ResponseEntity.ok(sessions);
    }

    @GetMapping("/getLearningSessions")
    public ResponseEntity<List<GameSessionDTO>> getLearningSessions() {
        List<GameSessionDTO> sessions = gameSessionService.getLearningSessions();
        return ResponseEntity.ok(sessions);
    }

    @GetMapping("/getMemorySessionsByUserId/{userId}")
    public ResponseEntity<List<GameSessionDTO>> getMemorySessionsByUserId(@PathVariable("userId") int userId) {
        List<GameSessionDTO> sessions = gameSessionService.getMemorySessionsByUserId(userId);
        return ResponseEntity.ok(sessions);
    }

    @GetMapping("/getLearningSessionsByUserId/{userId}")
    public ResponseEntity<List<GameSessionDTO>> getLearningSessionsByUserId(@PathVariable("userId") int userId) {
        List<GameSessionDTO> sessions = gameSessionService.getLearningSessionsByUserId(userId);
        return ResponseEntity.ok(sessions);
    }

    @GetMapping("/getReflexSessionsByUserId/{userId}")
    public ResponseEntity<List<GameSessionDTO>> getReflexSessionsByUserId(@PathVariable("userId") int userId) {
        List<GameSessionDTO> sessions = gameSessionService.getReflexSessionsByUserId(userId);
        return ResponseEntity.ok(sessions);
    }
}
