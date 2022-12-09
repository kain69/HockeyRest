package ru.karmazin.hockeybackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.karmazin.hockeybackend.exception.NotFoundException;
import ru.karmazin.hockeybackend.model.Player;
import ru.karmazin.hockeybackend.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Vladislav Karmazin
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final TeamService teamService;
    private final PersonService personService;

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
        player.setTeam(teamService.findOne(team_id));

        playerRepository.save(player);
    }

    @Transactional
    public void update(Player updatedPlayer, int id) {
        updatedPlayer.setId(id);
        updatedPlayer.setTeam(this.findOne(id).getTeam());
        updatedPlayer.setPerson(this.findOne(id).getPerson());
        playerRepository.save(updatedPlayer);
    }

    @Transactional
    public void delete(int id) {
        playerRepository.delete(this.findOne(id));
    }
}
