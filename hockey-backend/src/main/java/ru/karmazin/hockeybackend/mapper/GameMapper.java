package ru.karmazin.hockeybackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.karmazin.hockeybackend.dto.game.GameCreateUpdateDto;
import ru.karmazin.hockeybackend.dto.game.GameDto;
import ru.karmazin.hockeybackend.model.Game;
import ru.karmazin.hockeybackend.service.TeamService;

import java.util.List;

/**
 * @author Vlad Karmazin
 */
@Mapper(componentModel = "spring", uses = {TeamService.class})
public interface GameMapper {

    List<GameDto> toGameDtos(List<Game> games);

    @Mapping(target = "team", source = "game.team.name")
    @Mapping(target = "place", source = "game.place.name")
    GameDto toGameDto(Game game);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "team", source = "team_id")
    @Mapping(target = "place", ignore = true)
    @Mapping(target = "lines", ignore = true)
    @Mapping(target = "approvedPlayers", ignore = true)
    Game toGame(GameCreateUpdateDto gameCreateDto, int team_id);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "team", ignore = true)
    @Mapping(target = "place", ignore = true)
    @Mapping(target = "lines", ignore = true)
    @Mapping(target = "approvedPlayers", ignore = true)
    void update(@MappingTarget Game game, GameCreateUpdateDto gameUpdateDto);
}
