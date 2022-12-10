package ru.karmazin.hockeybackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.karmazin.hockeybackend.dto.SimpleTeamDto;
import ru.karmazin.hockeybackend.dto.TeamDto;
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

    public TeamDto findOne(int id) {
        return teamMapper.toTeamDto(this.getTeam(id));
    }

    @Transactional
    public void save(SimpleTeamDto simpleTeamDto) {
        teamRepository.save(teamMapper.toTeam(simpleTeamDto));
    }

    @Transactional
    public void update(SimpleTeamDto updatedTeamDto, int id) {
        Team updatedTeam = teamMapper.toTeam(updatedTeamDto);
        updatedTeam.setPlayers(this.getTeam(id).getPlayers());
        teamRepository.save(updatedTeam);
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
