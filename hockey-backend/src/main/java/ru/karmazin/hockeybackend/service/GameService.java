package ru.karmazin.hockeybackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.karmazin.hockeybackend.dto.game.GameCreateUpdateDto;
import ru.karmazin.hockeybackend.dto.game.GameDto;
import ru.karmazin.hockeybackend.exception.NotFoundException;
import ru.karmazin.hockeybackend.mapper.GameMapper;
import ru.karmazin.hockeybackend.model.Game;
import ru.karmazin.hockeybackend.repository.GameRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Vlad Karmazin
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    public List<GameDto> findAllByTeam(int team_id) {
        return gameMapper.toGameDtos(gameRepository.findAllByTeam_Id(team_id));
    }

    public GameDto findOne(int id) {
        return gameMapper.toGameDto(this.getGame(id));
    }

    @Transactional
    public void save(GameCreateUpdateDto gameCreateDto, int team_id) {
        Game game = gameMapper.toGame(gameCreateDto, team_id);
        gameRepository.save(game);
    }

    @Transactional
    public void update(GameCreateUpdateDto gameUpdateDto, int id) {
        Game game = this.getGame(id);
        gameMapper.update(game, gameUpdateDto);
        gameRepository.save(game);
    }

    @Transactional
    public void delete(int id) {
        gameRepository.delete(this.getGame(id));
    }

    public Game getGame(int id) {
        Optional<Game> foundGame = gameRepository.findById(id);
        return foundGame.orElseThrow(
                () -> new NotFoundException("Game with this id wasn`t found!")
        );
    }
}
