package ru.karmazin.hockeybackend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.karmazin.hockeybackend.entity.Player;
import ru.karmazin.hockeybackend.exception.NotFoundException;
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

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Player findOne(int id) {
        Optional<Player> foundPerson = playerRepository.findById(id);
        return foundPerson.orElseThrow(NotFoundException::new);
    }

    @Transactional
    public void save(Player player) {
        playerRepository.save(player);
    }
}
