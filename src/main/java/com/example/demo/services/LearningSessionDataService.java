package com.example.demo.services;

import com.example.demo.dto.LearningSessionDataDTO;
import com.example.demo.dto.MaxScoreDTO;
import com.example.demo.mappers.LearningSessionDataMapper;
import com.example.demo.model.LearningSessionData;
import com.example.demo.repositories.LearningSessionDataRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LearningSessionDataService {

    private final LearningSessionDataRepository learningSessionDataRepository;


    public LearningSessionDataService(LearningSessionDataRepository learningSessionDataRepository) {
        this.learningSessionDataRepository = learningSessionDataRepository;
    }

    public LearningSessionDataDTO createLearningSession(LearningSessionDataDTO sessionDataDTO) {
        LearningSessionData learningSessionData = LearningSessionDataMapper.INSTANCE.dtoToLearning(sessionDataDTO);
        learningSessionData = learningSessionDataRepository.save(learningSessionData);
        return LearningSessionDataMapper.INSTANCE.learningToDTO(learningSessionData);
    }

    public void deleteSession(Integer sessionDataId) {
        boolean exists = learningSessionDataRepository.existsById(sessionDataId);
        if (!exists) {
            throw new IllegalStateException("SessionData not found");
        }
        learningSessionDataRepository.deleteById(sessionDataId);
    }

    public List<LearningSessionDataDTO> getAllSessionData(){
        List<LearningSessionData> sessionDataList = learningSessionDataRepository.findAll();
        return sessionDataList.stream().map(LearningSessionDataMapper.INSTANCE::learningToDTO).toList();
    }

    public List<LearningSessionDataDTO> getSessionsDataByUser(int userId) {
        List<LearningSessionData> sessionDataList = learningSessionDataRepository.findByUserId(userId);
        return sessionDataList.stream().map(LearningSessionDataMapper.INSTANCE::learningToDTO).toList();
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
}