package ru.karmazin.hockeybackend.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.karmazin.hockeybackend.dto.PlayerDto;
import ru.karmazin.hockeybackend.exception.NotCreatedException;
import ru.karmazin.hockeybackend.service.PlayerService;

import java.util.List;

/**
 * @author Vladislav Karmazin
 */
@RestController
@RequestMapping("/api/teams/{team_id}/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<PlayerDto> getPlayers(@PathVariable("team_id") int team_id) {
        return playerService.findAllByTeamId(team_id);
    }

    @GetMapping("{id}")
    public PlayerDto getPlayer(@PathVariable("id") int id) {
        return playerService.findOne(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createPlayer(@PathVariable("team_id") int team_id,
                                                   @RequestBody @Valid PlayerDto playerDto,
                                                   BindingResult bindingResult) {
        validationPlayer(bindingResult);

        playerService.save(playerDto, team_id);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("{id}")
    public ResponseEntity<HttpStatus> editPlayer(@PathVariable("id") int id,
                                                 @RequestBody @Valid PlayerDto playerDto,
                                                 BindingResult bindingResult) {

        validationPlayer(bindingResult);

        playerService.update(playerDto, id);

        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletePlayer(@PathVariable("id") int id) {
        playerService.delete(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    private static void validationPlayer(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                errorMsg.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append(";");
            }

            throw new NotCreatedException(errorMsg.toString());
        }
    }
}
