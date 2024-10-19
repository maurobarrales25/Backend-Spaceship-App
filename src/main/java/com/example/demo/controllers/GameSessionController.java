package com.example.demo.controllers;

import com.example.demo.dto.GameSessionDTO;
import com.example.demo.services.GameSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/gamesession")
public abstract class GameSessionController {

    @Autowired
    private GameSessionService gameSessionService;

    @GetMapping("/getAllGameSessions")
    public ResponseEntity<List<GameSessionDTO>> getGameSession() {
        List<GameSessionDTO> gameSessions = gameSessionService.getAllGameSessions();
        return ResponseEntity.ok(gameSessions);
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
    public ResponseEntity<List<GameSession>> getReflexSessions() {
        List<GameSession> sessions = gameSessionService.getReflexSessions();
        return ResponseEntity.ok(sessions);
    }

    public ResponseEntity<List<GameSession>> getMemorySessions() {
        List<GameSession> sessions = gameSessionService.getMemorySessions();
        return ResponseEntity.ok(sessions);
    }

    @GetMapping("/getLearningSessions")
    public ResponseEntity<List<GameSession>> getLearningSessions() {
        List<GameSession> sessions = gameSessionService.getLearningSessions();
        return ResponseEntity.ok(sessions);
    }
}
