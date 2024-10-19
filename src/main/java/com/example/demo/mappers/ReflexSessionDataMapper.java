package com.example.demo.mappers;

import com.example.demo.dto.ReflexSessionDataDTO;
import com.example.demo.model.ReflexSessionData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReflexSessionDataMapper {


    ReflexSessionDataMapper INSTANCE = Mappers.getMapper(ReflexSessionDataMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "score", target = "score")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "sessionDate", target = "sessionDate")
    @Mapping(source = "times", target = "times")
    ReflexSessionDataDTO reflexSessionDataToDto(ReflexSessionData reflexSessionData);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "score", target = "score")
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "sessionDate", target = "sessionDate")
    @Mapping(source = "times", target = "times")
    ReflexSessionData dtoToReflexSessionData(ReflexSessionDataDTO reflexSessionDataDTO);
}
