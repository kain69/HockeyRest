package ru.karmazin.hockeybackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.karmazin.hockeybackend.dto.approvedPlayer.ApprovedPlayerDto;
import ru.karmazin.hockeybackend.exception.NotFoundException;
import ru.karmazin.hockeybackend.mapper.ApprovedPlayerMapper;
import ru.karmazin.hockeybackend.model.ApprovedPlayer;
import ru.karmazin.hockeybackend.repository.ApprovedPlayerRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Vlad Karmazin
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApprovedPlayerService {
    private final ApprovedPlayerRepository approvedPlayerRepository;
    private final PlayerService playerService;
    private final ApprovedPlayerMapper approvedPlayerMapper;

    public List<ApprovedPlayerDto> findAllByGame(int game_id) {
        return approvedPlayerMapper.toApprovedPlayerDtos(approvedPlayerRepository.findAllByGame_Id(game_id));
    }

    @Transactional
    public void create(int team_id) {
        List<ApprovedPlayer> approvedPlayers = approvedPlayerMapper.toApprovedPlayer(playerService.findAllByTeamId(team_id));
        approvedPlayerRepository.saveAll(approvedPlayers);
    }

    @Transactional
    public void save(List<ApprovedPlayerDto> approvedPlayerDtos, int game_id) {
        List<ApprovedPlayer> approvedPlayers = approvedPlayerMapper.toApprovedPlayers(approvedPlayerDtos, game_id);
        approvedPlayerRepository.saveAll(approvedPlayers);
    }

    @Transactional
    public void update(List<ApprovedPlayerDto> approvedPlayerDtos, int game_id) {
        List<ApprovedPlayer> approvedPlayers = approvedPlayerRepository.findAllByGame_Id(game_id);
        approvedPlayerMapper.update(approvedPlayers, approvedPlayerDtos);
        approvedPlayerRepository.saveAll(approvedPlayers);
    }

    public ApprovedPlayer getApprovedPlayer(int id) {
        Optional<ApprovedPlayer> foundApprovedPlayer = approvedPlayerRepository.findById(id);
        return foundApprovedPlayer.orElseThrow(
                () -> new NotFoundException("ApprovedPlayer with this id wasn`t found!")
        );
    }
}
