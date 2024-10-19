package com.example.demo.mappers;

import com.example.demo.dto.GameSessionDTO;
import com.example.demo.model.GameSession;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GameSessionMapper {

    GameSessionMapper INSTANCE = Mappers.getMapper(GameSessionMapper.class);


    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "score", target = "score")
    @Mapping(source = "sessionDate", target = "sessionDate")
    GameSessionDTO gameSessionToGameSessionDto(GameSession gameSession);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "score", target = "score")
    @Mapping(source = "sessionDate", target = "sessionDate")
    GameSession gameSessionDtoToGameSession(GameSessionDTO gameSessionDTO);

    @Mapping(source = "id", target = "id")
    GameSessionDTO idToGameSessionDto(GameSession user);
}
