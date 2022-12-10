package ru.karmazin.hockeybackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.karmazin.hockeybackend.dto.SimpleTeamDto;
import ru.karmazin.hockeybackend.dto.TeamDto;
import ru.karmazin.hockeybackend.model.Team;

import java.util.List;

/**
 * @author Vladislav Karmazin
 */
@Mapper(componentModel = "spring")
public interface TeamMapper {

    SimpleTeamDto toSimpleTeamDto(Team team);
    List<SimpleTeamDto> toSimpleTeamDtos(List<Team> teams);
    TeamDto toTeamDto(Team team);
    @Mapping(target = "players", ignore = true)
    Team toTeam(SimpleTeamDto dto);
}
