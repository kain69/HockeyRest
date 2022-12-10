package ru.karmazin.hockeybackend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.karmazin.hockeybackend.dto.SimpleTeamDto;
import ru.karmazin.hockeybackend.dto.TeamDto;
import ru.karmazin.hockeybackend.exception.NotCreatedException;
import ru.karmazin.hockeybackend.service.TeamService;

import java.util.List;

/**
 * @author Vladislav Karmazin
 */
@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @GetMapping
    public List<SimpleTeamDto> getTeams() {
        return teamService.findAll();
    }

    @GetMapping("{id}")
    public TeamDto getTeam(@PathVariable int id) {
        return teamService.findOne(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid SimpleTeamDto simpleTeamDto,
                                             BindingResult bindingResult) {
        validationTeam(bindingResult);

        teamService.save(simpleTeamDto);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("{id}")
    public ResponseEntity<HttpStatus> editTeam(@PathVariable("id") int id,
                                               @RequestBody @Valid SimpleTeamDto simpleTeamDto,
                                               BindingResult bindingResult) {

        validationTeam(bindingResult);

        teamService.update(simpleTeamDto, id);

        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteTeam(@PathVariable("id") int id) {
        teamService.delete(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    private static void validationTeam(BindingResult bindingResult) {
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
