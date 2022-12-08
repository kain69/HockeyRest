package ru.karmazin.hockeybackend.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.karmazin.hockeybackend.entity.Team;
import ru.karmazin.hockeybackend.exception.NotCreatedException;
import ru.karmazin.hockeybackend.exception.NotFoundException;
import ru.karmazin.hockeybackend.service.TeamService;
import ru.karmazin.hockeybackend.util.ErrorResponse;

import java.util.List;

/**
 * @author Vladislav Karmazin
 */
@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<Team> getTeams() {
        return teamService.findAll();
    }

    @GetMapping("{id}")
    public Team getTeam(@PathVariable int id) {
        return teamService.findOne(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid Team team,
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

        teamService.save(team);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(NotFoundException e) {
        ErrorResponse response = new ErrorResponse(
                "Team with this id wasn`t found!",
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
}
