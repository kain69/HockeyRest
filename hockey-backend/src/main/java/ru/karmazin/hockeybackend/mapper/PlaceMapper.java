package ru.karmazin.hockeybackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.karmazin.hockeybackend.dto.place.PlaceCreateUpdateDto;
import ru.karmazin.hockeybackend.dto.place.PlaceDto;
import ru.karmazin.hockeybackend.model.Place;

import java.util.List;

/**
 * @author Vlad Karmazin
 */
@Mapper(componentModel = "spring")
public interface PlaceMapper {
    PlaceDto toPlaceDto(Place place);
    List<PlaceDto> toPlaceDtos(List<Place> places);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "game", ignore = true)
    Place toPlace(PlaceCreateUpdateDto placeDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "game", ignore = true)
    void update(@MappingTarget Place place, PlaceCreateUpdateDto placeCreateUpdateDto);
}
