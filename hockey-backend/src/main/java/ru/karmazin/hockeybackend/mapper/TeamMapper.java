package ru.karmazin.hockeybackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.karmazin.hockeybackend.dto.team.TeamCreateUpdateDto;
import ru.karmazin.hockeybackend.dto.team.SimpleTeamDto;
import ru.karmazin.hockeybackend.model.Team;

import java.util.List;

/**
 * @author Vladislav Karmazin
 */
@Mapper(componentModel = "spring")
public interface TeamMapper {

    SimpleTeamDto toSimpleTeamDto(Team team);

    List<SimpleTeamDto> toSimpleTeamDtos(List<Team> teams);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "players", ignore = true)
    @Mapping(target = "lines", ignore = true)
    @Mapping(target = "games", ignore = true)
    Team toTeam(TeamCreateUpdateDto teamDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "players", ignore = true)
    @Mapping(target = "lines", ignore = true)
    @Mapping(target = "games", ignore = true)
    void update(@MappingTarget Team team, TeamCreateUpdateDto teamUpdateDto);
}
