package ru.karmazin.hockeybackend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.karmazin.hockeybackend.exception.NotFoundException;
import ru.karmazin.hockeybackend.model.Team;
import ru.karmazin.hockeybackend.repository.TeamRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Vladislav Karmazin
 */
@Service
@Transactional(readOnly = true)
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    public Team findOne(int id) {
        Optional<Team> foundTeam = teamRepository.findById(id);
        return foundTeam.orElseThrow(
                () -> new NotFoundException("Team with this id wasn`t found!")
        );
    }

    @Transactional
    public void save(Team team) {
        teamRepository.save(team);
    }

    @Transactional
    public void update(Team updatedTeam, int id) {
        updatedTeam.setPlayers(this.findOne(id).getPlayers());
        updatedTeam.setId(id);
        teamRepository.save(updatedTeam);
    }

    @Transactional
    public void delete(int id) {
        Team team = this.findOne(id);
        teamRepository.delete(team);
    }
}
