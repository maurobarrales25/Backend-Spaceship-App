package com.example.demo.services;

import com.example.demo.dto.SessionDataDTO;
import com.example.demo.mappers.SessionDataMapper;
import com.example.demo.model.LearningSessionData;
import com.example.demo.model.MemorySessionData;
import com.example.demo.model.MusicalSessionData;
import com.example.demo.model.SessionData;
import com.example.demo.repositories.SessionDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessionDataService {

    @Autowired
    private SessionDataRepository sessionDataRepository;

    private SessionDataMapper sessionDataMapper = SessionDataMapper.INSTANCE;

    public SessionDataDTO getSessionDataByID(int id){
        SessionData sessionData = sessionDataRepository.findById(id).orElseThrow(()->new RuntimeException("SessionData not found"));
        return sessionDataMapper.sessionDataToSessionDataDto(sessionData);
    }

    public List<SessionDataDTO> getAllSessionData(){
        List<SessionData> sessionDataList = sessionDataRepository.findAll();
        return sessionDataList.stream().map(sessionDataMapper::sessionDataToSessionDataDto).collect(Collectors.toList());
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
        return sessionDataList.stream().map(sessionDataMapper::sessionDataToSessionDataDto).collect(Collectors.toList());
    }

    public List<SessionDataDTO> getMusicalSessionDataByUserId(int userId) {
        List<MusicalSessionData> musicalSessionData = sessionDataRepository.findMusicalSessionDataByUserId(userId);
        return musicalSessionData.stream().map(sessionDataMapper::sessionDataToSessionDataDto).collect(Collectors.toList());
    }

    public List<SessionDataDTO> getMemorySessionDataByUserId(int userId) {
        List<MemorySessionData> memorySessionData = sessionDataRepository.findMemorySessionDataByUserId(userId);
        return memorySessionData.stream().map(sessionDataMapper::sessionDataToSessionDataDto).collect(Collectors.toList());
    }

    public List<SessionDataDTO> getLearningSessionDataByUserId(int userId) {
        List<LearningSessionData> learningSessionData = sessionDataRepository.findLearningSessionDataByUserId(userId);
        return learningSessionData.stream().map(sessionDataMapper::sessionDataToSessionDataDto).collect(Collectors.toList());
    }
}
