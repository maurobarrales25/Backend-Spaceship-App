package com.example.demo.services;

import com.example.demo.dto.GameSessionDTO;
import com.example.demo.mappers.GameSessionMapper;
import com.example.demo.model.GameSession;
import com.example.demo.repositories.GameSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public  class GameSessionService {

    @Autowired
    private GameSessionRepository gameSessionRepository;

    private GameSessionMapper gameSessionMapper = GameSessionMapper.INSTANCE;

    public GameSessionDTO getGameSessionById(int id) {
        GameSession gameSession = gameSessionRepository.findById (id).orElseThrow(() -> new RuntimeException("GameSession not found"));
        return gameSessionMapper.idToGameSessionDto(gameSession);
    }

    public List<GameSessionDTO> getAllGameSessions() {
        List<GameSession> gameSessions = gameSessionRepository.findAll();
        return gameSessions.stream().map(gameSessionMapper::gameSessionToGameSessionDto).collect(Collectors.toList());
    }

    public GameSessionDTO createGameSession(GameSessionDTO gameSessionDTO) {
        GameSession gameSession = gameSessionMapper.gameSessionDtoToGameSession(gameSessionDTO);
        GameSession newGameSession = gameSessionRepository.save(gameSession);
        return gameSessionMapper.gameSessionToGameSessionDto(newGameSession);
    }

    public void deleteGameSessionById(int id) {
        gameSessionRepository.deleteById(id);
    }
}
