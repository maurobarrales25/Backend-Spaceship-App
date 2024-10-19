package com.example.demo.services;


import com.example.demo.dto.ReflexSessionDataDTO;
import com.example.demo.mappers.ReflexSessionDataMapper;
import com.example.demo.model.ReflexSessionData;
import com.example.demo.repositories.ReflexSessionDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReflexSessionDataService {

    @Autowired
    private ReflexSessionDataRepository reflexSessionDataRepository;

    private ReflexSessionDataMapper mapper = ReflexSessionDataMapper.INSTANCE;

    public ReflexSessionDataDTO createReflexSessionData(ReflexSessionDataDTO dto) {
        ReflexSessionData sessionData = mapper.dtoToReflexSessionData(dto);
        reflexSessionDataRepository.save(sessionData);
        return mapper.reflexSessionDataToDto(sessionData);
    }

    public List<ReflexSessionDataDTO> getAllReflexSessionData() {
        return reflexSessionDataRepository.findAll()
                .stream()
                .map(mapper::reflexSessionDataToDto)
                .collect(Collectors.toList());
    }

    public ReflexSessionDataDTO getReflexSessionDataById(int id) {
        ReflexSessionData sessionData = reflexSessionDataRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Session data not found"));
        return mapper.reflexSessionDataToDto(sessionData);
    }

    public void deleteReflexSessionData(int id) {
        if (!reflexSessionDataRepository.existsById(id)) {
            throw new IllegalStateException("Session data not found");
        }
        reflexSessionDataRepository.deleteById(id);
    }

    public List<ReflexSessionDataDTO> getReflexSessionsByUserId(int userId) {
        List<ReflexSessionData> reflexSessions = reflexSessionDataRepository.findReflexSessionsByUserId(userId);
        return reflexSessions.stream().map(mapper::reflexSessionDataToDto).collect(Collectors.toList());
    }


}
