package ru.karmazin.hockeybackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.karmazin.hockeybackend.dto.PlayerDto;
import ru.karmazin.hockeybackend.exception.NotFoundException;
import ru.karmazin.hockeybackend.mapper.PlayerMapper;
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
    private final PlayerMapper playerMapper;

    public List<PlayerDto> findAllByTeamId(int team_id) {
        return playerMapper.toPlayerDtos(
                playerRepository.findAllByTeam_Id(team_id)
        );
    }


    public PlayerDto findOne(int id) {
        return playerMapper.toPlayerDto(this.getPlayer(id));
    }

    @Transactional
    public void save(PlayerDto playerDto, int team_id) {
        Player player = playerMapper.toPlayer(playerDto);
        player.setTeam(teamService.getTeam(team_id));
        player.setPerson(personService.getPerson(player.getPerson().getId()));

        playerRepository.save(player);
    }

    @Transactional
    public void update(PlayerDto updatedPlayer, int id) {
        Player player = playerMapper.toPlayer(updatedPlayer);
        player.setTeam(this.getPlayer(id).getTeam());
        player.setPerson(this.getPlayer(id).getPerson());

        playerRepository.save(player);
    }

    @Transactional
    public void delete(int id) {
        playerRepository.delete(this.getPlayer(id));
    }

    private Player getPlayer(int id) {
        Optional<Player> foundPlayer = playerRepository.findById(id);
        return foundPlayer.orElseThrow(
                () -> new NotFoundException("Player with this id wasn`t found!")
        );
    }
}
