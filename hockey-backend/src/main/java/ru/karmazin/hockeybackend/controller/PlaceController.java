package ru.karmazin.hockeybackend.controller;

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
public class PlaceController {
    private final PlaceService placeService;

    @GetMapping
    public List<PlaceDto> getPlaces() {
        return placeService.findAll();
    }

    @GetMapping("{id}")
    public PlaceDto getPlace(@PathVariable("id") int id) {
        return placeService.findOne(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createPlace(@RequestBody @Valid PlaceCreateUpdateDto placeDto) {
        placeService.save(placeDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("{id}")
    public ResponseEntity<HttpStatus> editPlace(@PathVariable("id") int id,
                                                @RequestBody @Valid PlaceCreateUpdateDto placeUpdateDto) {
        placeService.update(placeUpdateDto, id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletePlace(@PathVariable("id") int id) {
        placeService.delete(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
