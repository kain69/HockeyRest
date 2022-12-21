package ru.karmazin.hockeybackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.karmazin.hockeybackend.dto.place.PlaceCreateUpdateDto;
import ru.karmazin.hockeybackend.dto.place.PlaceDto;
import ru.karmazin.hockeybackend.exception.NotFoundException;
import ru.karmazin.hockeybackend.mapper.PlaceMapper;
import ru.karmazin.hockeybackend.model.Place;
import ru.karmazin.hockeybackend.repository.PlaceRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Vlad Karmazin
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PlaceService {
    private final PlaceRepository placeRepository;
    private final PlaceMapper placeMapper;

    public List<PlaceDto> findAll() {
        return placeMapper.toPlaceDtos(placeRepository.findAll());
    }

    public PlaceDto findOne(int id) {
        return placeMapper.toPlaceDto(this.getPlace(id));
    }

    @Transactional
    public void save(PlaceCreateUpdateDto placeCreateDto) {
        Place place = placeMapper.toPlace(placeCreateDto);
        placeRepository.save(place);
    }

    @Transactional
    public void update(PlaceCreateUpdateDto placeUpdateDto, int id) {
        Place place = this.getPlace(id);
        placeMapper.update(place, placeUpdateDto);
        placeRepository.save(place);
    }

    @Transactional
    public void delete(int id) {
        placeRepository.delete(this.getPlace(id));
    }

    public Place getPlace(int id) {
        Optional<Place> foundPlace = placeRepository.findById(id);
        return foundPlace.orElseThrow(
                () -> new NotFoundException("Place with this id wasn`t found!")
        );
    }

}
