package ru.karmazin.hockeybackend.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.karmazin.hockeybackend.dto.PlayerDTO;
import ru.karmazin.hockeybackend.entity.Player;
import ru.karmazin.hockeybackend.exception.NotCreatedException;
import ru.karmazin.hockeybackend.exception.NotFoundException;
import ru.karmazin.hockeybackend.service.PlayerService;
import ru.karmazin.hockeybackend.util.ErrorResponse;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vladislav Karmazin
 */
@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;
    private final ModelMapper modelMapper;

    public PlayerController(PlayerService playerService, ModelMapper modelMapper) {
        this.playerService = playerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<PlayerDTO> getPlayers() {
        return playerService.findAll().stream().map(this::convertToPlayerDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public PlayerDTO getPlayer(@PathVariable int id) {
        return convertToPlayerDTO(playerService.findOne(id));
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid PlayerDTO playerDTO,
                                             BindingResult bindingResult) {
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

        playerService.save(convertToPlayer(playerDTO));

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(NotFoundException e) {
        ErrorResponse response = new ErrorResponse(
                "Player with this id wasn`t found!",
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(NotCreatedException e) {
        ErrorResponse response = new ErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private Player convertToPlayer(PlayerDTO playerDTO) {
        return modelMapper.map(playerDTO, Player.class);
    }

    private PlayerDTO convertToPlayerDTO(Player player) {
        return modelMapper.map(player, PlayerDTO.class);
    }
}
