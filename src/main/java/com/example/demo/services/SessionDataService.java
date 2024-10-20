package com.example.demo.services;

import com.example.demo.dto.MaxScoreDTO;
import com.example.demo.dto.SessionDataDTO;
import com.example.demo.mappers.SessionDataMapper;
import com.example.demo.model.LearningSessionData;
import com.example.demo.model.MemorySessionData;
import com.example.demo.model.MusicalSessionData;
import com.example.demo.model.SessionData;
import com.example.demo.repositories.LearningSessionDataRepository;
import com.example.demo.repositories.MemorySessionDataRepository;
import com.example.demo.repositories.MusicalSessionDataRepository;
import com.example.demo.repositories.SessionDataRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SessionDataService {

    private final SessionDataRepository sessionDataRepository;
    private final LearningSessionDataRepository learningSessionDataRepository;
    private final MemorySessionDataRepository memorySessionDataRepository;
    private final MusicalSessionDataRepository musicalSessionDataRepository;
    private static final SessionDataMapper sessionDataMapper = SessionDataMapper.INSTANCE;

    public SessionDataService(SessionDataRepository sessionDataRepository, MusicalSessionDataRepository musicalSessionDataRepository, LearningSessionDataRepository learningSessionDataRepository, MemorySessionDataRepository memorySessionDataRepository) {
        this.sessionDataRepository = sessionDataRepository;
        this.musicalSessionDataRepository = musicalSessionDataRepository;
        this.learningSessionDataRepository = learningSessionDataRepository;
        this.memorySessionDataRepository = memorySessionDataRepository;
    }

    public SessionDataDTO getSessionDataByID(int id){
        SessionData sessionData = sessionDataRepository.findById(id).orElseThrow(()->new RuntimeException("SessionData not found"));
        return sessionDataMapper.sessionDataToSessionDataDto(sessionData);
    }

    public List<SessionDataDTO> getAllSessionData(){
        List<SessionData> sessionDataList = sessionDataRepository.findAll();
        return sessionDataList.stream().map(sessionDataMapper::sessionDataToSessionDataDto).toList();
    }

    public SessionDataDTO createSessionData(SessionDataDTO sessionDataDTO){
        SessionData sessionData = sessionDataMapper.sessionDataDtoToSessionData(sessionDataDTO);
        sessionDataRepository.save(sessionData);
        return sessionDataMapper.sessionDataToSessionDataDto(sessionData);
    }

    public void deleteSession(Integer sessionDataId){
        boolean exists = sessionDataRepository.existsById(sessionDataId);
        if(!exists){
            throw new IllegalStateException("SessionData not found");
        }
        sessionDataRepository.deleteById(sessionDataId);
    }

    public List<SessionDataDTO> getSessionDataByUser(int userId) {
        List<SessionData> sessionDataList = sessionDataRepository.findByUserId(userId);
        return sessionDataList.stream().map(sessionDataMapper::sessionDataToSessionDataDto).toList();
    }

    public List<SessionDataDTO> getMusicalSessionDataByUserId(int userId) {
        List<MusicalSessionData> musicalSessionData = musicalSessionDataRepository.findMusicalSessionDataByUserId(userId);
        return musicalSessionData.stream().map(sessionDataMapper::sessionDataToSessionDataDto).toList();
    }

    public List<SessionDataDTO> getMemorySessionDataByUserId(int userId) {
        List<MemorySessionData> memorySessionData = memorySessionDataRepository.findMemorySessionDataByUserId(userId);
        return memorySessionData.stream().map(sessionDataMapper::sessionDataToSessionDataDto).toList();
    }

    public List<SessionDataDTO> getLearningSessionDataByUserId(int userId) {
        List<LearningSessionData> learningSessionData = learningSessionDataRepository.findLearningSessionDataByUserId(userId);
        return learningSessionData.stream().map(sessionDataMapper::sessionDataToSessionDataDto).toList();
    }

    public List<MaxScoreDTO> getLearningMaxScoresWithUsernames() {
        List<Object[]> resultsFromRepository = learningSessionDataRepository.getLearningMaxScoreWithUsername();
        List<MaxScoreDTO> maxScores = new ArrayList<>();

        for (Object[] object : resultsFromRepository) {
            int maxScore = (int) object[0];
            String username = (String) object[1];
            maxScores.add(new MaxScoreDTO(maxScore, username));
        }
        return maxScores;
    }

    public List<MaxScoreDTO> getMemoryMaxScoresWithUsernames() {
        List<Object[]> resultsFromRepository = memorySessionDataRepository.getMemoryMaxScoreWithUsername();
        List<MaxScoreDTO> maxScores = new ArrayList<>();

        for (Object[] object : resultsFromRepository) {
            int maxScore = (int) object[0];
            String username = (String) object[1];
            maxScores.add(new MaxScoreDTO(maxScore, username));
        }
        return maxScores;
    }

    public List<MaxScoreDTO> getMusicalMaxScoresWithUsernames() {
        List<Object[]> resultsFromRepository = musicalSessionDataRepository.getMusicalMaxScoreWithUsername();
        List<MaxScoreDTO> maxScores = new ArrayList<>();

        for (Object[] object : resultsFromRepository) {
            int maxScore = (int) object[0];
            String username = (String) object[1];
            maxScores.add(new MaxScoreDTO(maxScore, username));
        }
        return maxScores;
    }


}
