package com.example.demo.mappers;

import com.example.demo.dto.MemorySessionDataDTO;
import com.example.demo.model.MemorySessionData;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface MemorySessionDataMapper {
    MemorySessionDataMapper INSTANCE = Mappers.getMapper(MemorySessionDataMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "capacity", target = "capacity")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "addedDate", target = "addedDate")
    MemorySessionDataDTO memoryToDTO(MemorySessionData memorySessionData);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "capacity", target = "capacity")
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "addedDate", target = "addedDate")
    MemorySessionData dtoToMemory(MemorySessionDataDTO memorySessionDataDTO);
}
