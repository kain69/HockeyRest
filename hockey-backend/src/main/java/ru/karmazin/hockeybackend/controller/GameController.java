package ru.karmazin.hockeybackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.karmazin.hockeybackend.dto.game.GameCreateUpdateDto;
import ru.karmazin.hockeybackend.dto.game.GameDto;
import ru.karmazin.hockeybackend.service.GameService;

import java.util.List;

/**
 * @author Vlad Karmazin
 */
@RestController
@RequestMapping("/api/teams/{team_id}/games")
@RequiredArgsConstructor
@Tag(name = "Игра", description = "Методы для работы с играми")
public class GameController {
    private final GameService gameService;

    @GetMapping
    @Operation(summary = "Получение списка всех игр конкретной команды")
    public List<GameDto> getGames(@PathVariable int team_id) {
        return gameService.findAllByTeam(team_id);
    }

    @GetMapping("{id}")
    @Operation(summary = "Получение информации о игре")
    public GameDto getGame(@PathVariable("id") int id) {
        return gameService.findOne(id);
    }

    @PostMapping
    @Operation(summary = "Создание новой игры")
    public ResponseEntity<HttpStatus> createGame(@PathVariable int team_id,
                                                 @RequestBody @Valid GameCreateUpdateDto gameDto) {
        gameService.save(gameDto, team_id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("{id}")
    @Operation(summary = "Редактирование игры")
    public ResponseEntity<HttpStatus> editGame(@PathVariable("id") int id,
                                               @RequestBody @Valid GameCreateUpdateDto gameUpdateDto) {
        gameService.update(gameUpdateDto, id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Удаление игры")
    public ResponseEntity<HttpStatus> deleteGame(@PathVariable("id") int id) {
        gameService.delete(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
