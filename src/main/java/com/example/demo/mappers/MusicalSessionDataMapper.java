package com.example.demo.mappers;

import com.example.demo.dto.MusicalSessionDataDTO;
import com.example.demo.model.MusicalSessionData;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface MusicalSessionDataMapper {
    MusicalSessionDataMapper INSTANCE = Mappers.getMapper(MusicalSessionDataMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "capacity", target = "capacity")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "addedDate", target = "addedDate")
    MusicalSessionDataDTO musicalToDTO(MusicalSessionData musicalSessionData);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "capacity", target = "capacity")
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "addedDate", target = "addedDate")
    MusicalSessionData dtoToMusical(MusicalSessionDataDTO musicalSessionDataDTO);
}
