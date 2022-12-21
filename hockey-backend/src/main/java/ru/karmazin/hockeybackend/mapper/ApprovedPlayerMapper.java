package ru.karmazin.hockeybackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.karmazin.hockeybackend.dto.approvedPlayer.ApprovedPlayerDto;
import ru.karmazin.hockeybackend.dto.player.PlayerDto;
import ru.karmazin.hockeybackend.model.ApprovedPlayer;
import ru.karmazin.hockeybackend.service.GameService;
import ru.karmazin.hockeybackend.service.PlayerService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vlad Karmazin
 */
@Mapper(componentModel = "spring", uses = {PlayerService.class, GameService.class})
public interface ApprovedPlayerMapper {

    @Mapping(target = "id", source = "approvedPlayerDto.id")
    @Mapping(target = "player", source = "approvedPlayerDto.player_id")
    @Mapping(target = "game", source = "game_id")
    ApprovedPlayer toApprovedPlayer(ApprovedPlayerDto approvedPlayerDto, int game_id);

    List<ApprovedPlayerDto> toApprovedPlayerDtos(List<ApprovedPlayer> approvedPlayers);

    ArrayList<ApprovedPlayer> toApprovedPlayers(List<ApprovedPlayerDto> approvedPlayerDtos, int gameId);

    void update(@MappingTarget List<ApprovedPlayer> approvedPlayers, List<ApprovedPlayerDto> approvedPlayerDtos);

    List<ApprovedPlayer> toApprovedPlayer(List<PlayerDto> playerDtos);
}
