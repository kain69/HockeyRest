package ru.karmazin.hockeybackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.karmazin.hockeybackend.dto.team.TeamCreateUpdateDto;
import ru.karmazin.hockeybackend.dto.team.SimpleTeamDto;
import ru.karmazin.hockeybackend.exception.NotFoundException;
import ru.karmazin.hockeybackend.mapper.TeamMapper;
import ru.karmazin.hockeybackend.model.Team;
import ru.karmazin.hockeybackend.repository.TeamRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Vladislav Karmazin
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public List<SimpleTeamDto> findAll() {
        return teamMapper.toSimpleTeamDtos(teamRepository.findAll());
    }

    public SimpleTeamDto findOne(int id) {
        return teamMapper.toSimpleTeamDto(this.getTeam(id));
    }

    @Transactional
    public void save(TeamCreateUpdateDto teamDto) {
        teamRepository.save(teamMapper.toTeam(teamDto));
    }

    @Transactional
    public void update(TeamCreateUpdateDto teamUpdateDto, int id) {
        Team team = this.getTeam(id);
        teamMapper.update(team, teamUpdateDto);
        teamRepository.save(team);
    }

    @Transactional
    public void delete(int id) {
        teamRepository.delete(this.getTeam(id));
    }

    public Team getTeam(int id) {
        Optional<Team> foundTeam = teamRepository.findById(id);
        return foundTeam.orElseThrow(
                () -> new NotFoundException("Team with this id wasn`t found!")
        );
    }
}
