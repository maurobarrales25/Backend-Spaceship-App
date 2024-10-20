package com.example.demo.services;

import com.example.demo.dto.MaxScoreDTO;
import com.example.demo.dto.MemorySessionDataDTO;
import com.example.demo.mappers.MemorySessionDataMapper;
import com.example.demo.model.MemorySessionData;
import com.example.demo.repositories.MemorySessionDataRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemorySessionDataService {

    private final MemorySessionDataRepository memorySessionDataRepository;

    public MemorySessionDataService(MemorySessionDataRepository memorySessionDataRepository) {
        this.memorySessionDataRepository = memorySessionDataRepository;
    }

    public MemorySessionDataDTO createMemorySession(MemorySessionDataDTO sessionDataDTO) {
        MemorySessionData memorySessionData = MemorySessionDataMapper.INSTANCE.dtoToMemory(sessionDataDTO);
        memorySessionData = memorySessionDataRepository.save(memorySessionData);
        return MemorySessionDataMapper.INSTANCE.memoryToDTO(memorySessionData);
    }

    public void deleteSession(Integer sessionDataId) {
        boolean exists = memorySessionDataRepository.existsById(sessionDataId);
        if (!exists) {
            throw new IllegalStateException("MemorySessionData not found");
        }
        memorySessionDataRepository.deleteById(sessionDataId);
    }

    public List<MemorySessionDataDTO> getAllSessionData() {
        List<MemorySessionData> sessionDataList = memorySessionDataRepository.findAll();
        return sessionDataList.stream().map(MemorySessionDataMapper.INSTANCE::memoryToDTO).toList();
    }

    public List<MemorySessionDataDTO> getSessionsDataByUser(int userId) {
        List<MemorySessionData> sessionDataList = memorySessionDataRepository.findByUserId(userId);
        return sessionDataList.stream().map(MemorySessionDataMapper.INSTANCE::memoryToDTO).toList();
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
}
