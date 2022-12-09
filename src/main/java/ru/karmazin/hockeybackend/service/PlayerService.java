package ru.karmazin.hockeybackend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.karmazin.hockeybackend.exception.NotFoundException;
import ru.karmazin.hockeybackend.model.Player;
import ru.karmazin.hockeybackend.model.Team;
import ru.karmazin.hockeybackend.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Vladislav Karmazin
 */
@Service
@Transactional(readOnly = true)
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final TeamService teamService;
    private final PersonService personService;

    public PlayerService(PlayerRepository playerRepository, TeamService teamService, PersonService personService) {
        this.playerRepository = playerRepository;
        this.teamService = teamService;
        this.personService = personService;
    }

    public List<Player> findAllByTeamId(int team_id) {
        return playerRepository.findAllByTeam_Id(team_id);
    }


    public Player findOne(int id) {
        Optional<Player> foundPlayer = playerRepository.findById(id);
        return foundPlayer.orElseThrow(
                () -> new NotFoundException("Player with this id wasn`t found!")
        );
    }

    @Transactional
    public void save(Player player, int team_id) {
        player.setPerson(personService.findOne(player.getPerson().getId()));
        player.getPerson().getPlayers().add(player);
        Team team = teamService.findOne(team_id);
        player.setTeam(team);
        team.getPlayers().add(player);

        playerRepository.save(player);
    }
}
