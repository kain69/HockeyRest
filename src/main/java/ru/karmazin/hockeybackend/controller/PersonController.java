package ru.karmazin.hockeybackend.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.karmazin.hockeybackend.dto.PersonDto;
import ru.karmazin.hockeybackend.dto.SimplePersonDto;
import ru.karmazin.hockeybackend.exception.NotCreatedException;
import ru.karmazin.hockeybackend.service.PersonService;

import java.util.List;

/**
 * @author Vladislav Karmazin
 */
@RestController
@RequestMapping("/api/people")
@RequiredArgsConstructor
@Tag(name = "Человек", description = "Методы для работы с сущностью человека")
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public List<SimplePersonDto> getPeople() {
        return personService.findAll();
    }

    @GetMapping("{id}")
    public PersonDto getPerson(@PathVariable int id) {
        return personService.findOne(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createPerson(@RequestBody @Valid PersonDto personDto,
                                                   BindingResult bindingResult) {
        validationPerson(bindingResult);

        personService.save(personDto);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("{id}")
    public ResponseEntity<HttpStatus> editPerson(@PathVariable("id") int id,
                             @RequestBody @Valid PersonDto personDto,
                             BindingResult bindingResult) {

        validationPerson(bindingResult);

        personService.update(personDto, id);

        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable("id") int id) {
        personService.delete(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    private static void validationPerson(BindingResult bindingResult) {
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
