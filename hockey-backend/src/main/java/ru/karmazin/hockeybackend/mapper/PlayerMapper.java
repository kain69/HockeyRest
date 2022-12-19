package ru.karmazin.hockeybackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.karmazin.hockeybackend.dto.person.SimplePersonDto;
import ru.karmazin.hockeybackend.dto.player.PlayerCreateUpdateDto;
import ru.karmazin.hockeybackend.dto.player.PlayerDto;
import ru.karmazin.hockeybackend.model.Player;
import ru.karmazin.hockeybackend.service.PersonService;
import ru.karmazin.hockeybackend.service.TeamService;

import java.util.List;

/**
 * @author Vladislav Karmazin
 */
@Mapper(componentModel = "spring", uses = {SimplePersonDto.class, TeamService.class, PersonService.class})
public interface PlayerMapper {

    @Mapping(target = "person", source = "person")
    PlayerDto toPlayerDto(Player player);
    List<PlayerDto> toPlayerDtos(List<Player> player);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "team", source = "team_id")
    @Mapping(target = "person", source = "playerDto.personId")
    Player toPlayer(PlayerCreateUpdateDto playerDto, int team_id);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "team", source = "team_id")
    @Mapping(target = "person", source = "playerUpdateDto.personId")
    void update(@MappingTarget Player player, PlayerCreateUpdateDto playerUpdateDto, int team_id);
}
