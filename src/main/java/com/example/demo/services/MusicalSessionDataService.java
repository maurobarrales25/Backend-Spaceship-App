package com.example.demo.services;

import com.example.demo.dto.MaxScoreDTO;
import com.example.demo.dto.MusicalSessionDataDTO;
import com.example.demo.mappers.MusicalSessionDataMapper;
import com.example.demo.model.MusicalSessionData;
import com.example.demo.repositories.MusicalSessionDataRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicalSessionDataService {

    private final MusicalSessionDataRepository musicalSessionDataRepository;

    public MusicalSessionDataService(MusicalSessionDataRepository musicalSessionDataRepository) {
        this.musicalSessionDataRepository = musicalSessionDataRepository;
    }

    public MusicalSessionDataDTO createMusicalSession(MusicalSessionDataDTO sessionDataDTO) {
        MusicalSessionData musicalSessionData = MusicalSessionDataMapper.INSTANCE.dtoToMusical(sessionDataDTO);
        musicalSessionData = musicalSessionDataRepository.save(musicalSessionData);
        return MusicalSessionDataMapper.INSTANCE.musicalToDTO(musicalSessionData);
    }

    public void deleteSession(Integer sessionDataId) {
        boolean exists = musicalSessionDataRepository.existsById(sessionDataId);
        if (!exists) {
            throw new IllegalStateException("MusicalSessionData not found");
        }
        musicalSessionDataRepository.deleteById(sessionDataId);
    }

    public List<MusicalSessionDataDTO> getAllSessionData() {
        List<MusicalSessionData> sessionDataList = musicalSessionDataRepository.findAll();
        return sessionDataList.stream().map(MusicalSessionDataMapper.INSTANCE::musicalToDTO).toList();
    }

    public List<MusicalSessionDataDTO> getSessionsDataByUser(int userId) {
        List<MusicalSessionData> sessionDataList = musicalSessionDataRepository.findByUserId(userId);
        return sessionDataList.stream().map(MusicalSessionDataMapper.INSTANCE::musicalToDTO).toList();
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
