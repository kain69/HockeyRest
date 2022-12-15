package ru.karmazin.hockeybackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.karmazin.hockeybackend.dto.person.PersonCreateUpdateDto;
import ru.karmazin.hockeybackend.dto.person.PersonDto;
import ru.karmazin.hockeybackend.dto.person.SimplePersonDto;
import ru.karmazin.hockeybackend.model.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author Vladislav Karmazin
 */
@Mapper(componentModel = "spring")
public interface PersonMapper {

    DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Mapping(target = "birthday", expression = "java(birthdayToString(person))")
    PersonDto toPersonDto(Person person);
    default String birthdayToString(Person person) {
        return person.getBirthday().format(DATE_TIME_FORMATTER);
    }
    default LocalDate stringToBirthday(PersonCreateUpdateDto personDto) {
        return LocalDate.parse(personDto.getBirthday(),
                DATE_TIME_FORMATTER
        );
    }

    List<SimplePersonDto> toSimplePersonDtos(List<Person> person);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "players", ignore = true)
    @Mapping(target = "birthday", expression = "java(stringToBirthday(personDto))")
    Person toPerson(PersonCreateUpdateDto personDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "players", ignore = true)
    @Mapping(target = "birthday", expression = "java(stringToBirthday(personUpdateDto))")
    void update(@MappingTarget Person person, PersonCreateUpdateDto personUpdateDto);
}
