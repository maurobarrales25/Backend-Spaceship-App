package com.example.demo.mappers;

import com.example.demo.dto.LearningSessionDataDTO;
import com.example.demo.model.LearningSessionData;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface LearningSessionDataMapper {
    LearningSessionDataMapper INSTANCE = Mappers.getMapper(LearningSessionDataMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "score", target = "score")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "sessionDate", target = "sessionDate")
    LearningSessionDataDTO learningToDTO(LearningSessionData learningSessionData);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "score", target = "score")
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "sessionDate", target = "sessionDate")
    LearningSessionData dtoToLearning(LearningSessionDataDTO learningSessionDataDTO);
}
