package com.example.demo.services;

import com.example.demo.dto.GameSessionDTO;
import com.example.demo.mappers.GameSessionMapper;
import com.example.demo.model.GameSession;
import com.example.demo.repositories.GameSessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class GameSessionService {

    private final GameSessionRepository gameSessionRepository;
    private static final GameSessionMapper gameSessionMapper = GameSessionMapper.INSTANCE;

    public GameSessionService(GameSessionRepository gameSessionRepository) {
        this.gameSessionRepository = gameSessionRepository;
    }

    public GameSessionDTO getGameSessionById(int id) {
        GameSession gameSession = gameSessionRepository.findById (id).orElseThrow(() -> new RuntimeException("GameSession not found"));
        return gameSessionMapper.idToGameSessionDto(gameSession);
    }

    public List<GameSessionDTO> getGameSessionsByUserId(int userId) {
        List<GameSession> gameSessions = gameSessionRepository.findByUserId(userId);
        return gameSessions.stream().map(gameSessionMapper::gameSessionToGameSessionDto).toList();
    }

    public List<GameSessionDTO> getAllGameSessions() {
        List<GameSession> gameSessions = gameSessionRepository.findAll();
        return gameSessions.stream().map(gameSessionMapper::gameSessionToGameSessionDto).toList();
    }

    public GameSessionDTO createGameSession(GameSessionDTO gameSessionDTO) {
        GameSession gameSession = gameSessionMapper.gameSessionDtoToGameSession(gameSessionDTO);
        GameSession newGameSession = gameSessionRepository.save(gameSession);
        return gameSessionMapper.gameSessionToGameSessionDto(newGameSession);
    }

    public void deleteGameSessionById(int id) {
        gameSessionRepository.deleteById(id);
    }

    public List<GameSessionDTO> getReflexSessions() {
        List<GameSession> reflexSessions = gameSessionRepository.findReflexSessions();
        return reflexSessions.stream().map(gameSessionMapper::gameSessionToGameSessionDto).toList();
    }

    public List<GameSessionDTO> getMemorySessions() {
        List<GameSession> memorySessions = gameSessionRepository.findMemorySessions();
        return memorySessions.stream().map(gameSessionMapper::gameSessionToGameSessionDto).toList();
    }

    public List<GameSessionDTO> getLearningSessions() {
        List<GameSession> learningSessions = gameSessionRepository.findLearningSessions();
        return learningSessions.stream().map(gameSessionMapper::gameSessionToGameSessionDto).toList();
    }


    public List<GameSessionDTO> getMemorySessionsByUserId(int userId) {
        List<GameSession> memorySessions = gameSessionRepository.findMemorySessionsByUserId(userId);
        return memorySessions.stream().map(gameSessionMapper::gameSessionToGameSessionDto).toList();
    }

    public List<GameSessionDTO> getLearningSessionsByUserId(int userId) {
        List<GameSession> learningSessions = gameSessionRepository.findLearningSessionsByUserId(userId);
        return learningSessions.stream().map(gameSessionMapper::gameSessionToGameSessionDto).toList();
    }

    public List<GameSessionDTO> getReflexSessionsByUserId(int userId) {
        List<GameSession> reflexSessions = gameSessionRepository.findReflexSessionsByUserId(userId);
        return reflexSessions.stream().map(gameSessionMapper::gameSessionToGameSessionDto).toList();
    }

    public List<GameSessionDTO> getMusicalSessionsByUserId(int userId) {
        List<GameSession> reflexSessions = gameSessionRepository.findMusicalSessionByUserId(userId);
        return reflexSessions.stream().map(gameSessionMapper::gameSessionToGameSessionDto).toList();
    }

    public List<GameSessionDTO> getSessionsByTypeAndUserId(String type, int userId) {
        List<GameSession> sessions;
        switch (type) {
            case "reflex":
                sessions = gameSessionRepository.findReflexSessionsByUserId(userId);
                break;
            case "memory":
                sessions = gameSessionRepository.findMemorySessionsByUserId(userId);
                break;
            case "learning":
                sessions = gameSessionRepository.findLearningSessionsByUserId(userId);
                break;
            case "musical":
                sessions = gameSessionRepository.findMusicalSessionByUserId(userId);
                break;
            default:
                throw new IllegalArgumentException("Invalid session type: " + type);
        }
        return sessions.stream().map(gameSessionMapper::gameSessionToGameSessionDto).toList();
    }




}
