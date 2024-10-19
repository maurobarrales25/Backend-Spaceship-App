package com.example.demo.mappers;

import com.example.demo.dto.SessionDataDTO;
import com.example.demo.model.SessionData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SessionDataMapper {

    SessionDataMapper INSTANCE = Mappers.getMapper(SessionDataMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "score", target = "score")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "sessionDate", target = "sessionDate")
    SessionDataDTO sessionDataToSessionDataDto(SessionData sessionData);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "score", target = "score")
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "sessionDate", target = "sessionDate")
    SessionData sessionDataDtoToSessionData(SessionDataDTO sessionDataDTO);
}
