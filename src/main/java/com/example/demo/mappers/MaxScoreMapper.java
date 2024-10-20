package com.example.demo.mappers;

import com.example.demo.dto.MaxScoreDTO;
import com.example.demo.model.SessionData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MaxScoreMapper {

    MaxScoreMapper INSTANCE = Mappers.getMapper(MaxScoreMapper.class);

    @Mapping(target = "maxScore", source = "score")
    @Mapping(target = "username", source = "user.username")

    MaxScoreDTO sessionDataToMaxScoreDTO(SessionData sessionData);

}
