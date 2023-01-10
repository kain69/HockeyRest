package ru.karmazin.hockeybackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.karmazin.hockeybackend.dto.place.PlaceCreateUpdateDto;
import ru.karmazin.hockeybackend.dto.place.PlaceDto;
import ru.karmazin.hockeybackend.service.PlaceService;

import java.util.List;

/**
 * @author Vlad Karmazin
 */
@RestController
@RequestMapping("/api/places")
@RequiredArgsConstructor
@Tag(name = "Стадион", description = "Методы для работы со стадионами")
public class PlaceController {
    private final PlaceService placeService;

    @GetMapping
    @Operation(summary = "Получение списка всех стадионов")
    public List<PlaceDto> getPlaces() {
        return placeService.findAll();
    }

    @GetMapping("{id}")
    @Operation(summary = "Получение информации о стадионе")
    public PlaceDto getPlace(@PathVariable("id") int id) {
        return placeService.findOne(id);
    }

    @PostMapping
    @Operation(summary = "Создание нового стадиона")
    public ResponseEntity<HttpStatus> createPlace(@RequestBody @Valid PlaceCreateUpdateDto placeDto) {
        placeService.save(placeDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("{id}")
    @Operation(summary = "Редактирование стадиона")
    public ResponseEntity<HttpStatus> editPlace(@PathVariable("id") int id,
                                                @RequestBody @Valid PlaceCreateUpdateDto placeUpdateDto) {
        placeService.update(placeUpdateDto, id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Удаление стадиона")
    public ResponseEntity<HttpStatus> deletePlace(@PathVariable("id") int id) {
        placeService.delete(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
