package ru.karmazin.hockeybackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.karmazin.hockeybackend.dto.PlayerDto;
import ru.karmazin.hockeybackend.dto.SimplePersonDto;
import ru.karmazin.hockeybackend.model.Player;

import java.util.List;

/**
 * @author Vladislav Karmazin
 */
@Mapper(componentModel = "spring", uses = {SimplePersonDto.class})
public interface PlayerMapper {
    @Mapping(target = "person", source = "person")
    PlayerDto toPlayerDto(Player player);
    List<PlayerDto> toPlayerDtos(List<Player> player);

    @Mapping(target = "team", ignore = true)
    @Mapping(target = "person", source = "person")
    Player toPlayer(PlayerDto playerDto);
}
