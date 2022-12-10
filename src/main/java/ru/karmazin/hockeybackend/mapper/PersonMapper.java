package ru.karmazin.hockeybackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.karmazin.hockeybackend.dto.PersonDto;
import ru.karmazin.hockeybackend.dto.SimplePersonDto;
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
    default LocalDate birthdayToString(PersonDto personDto) {
        return LocalDate.parse(personDto.getBirthday(),
                DATE_TIME_FORMATTER
        );
    }

    SimplePersonDto toSimplePersonDto(Person person);

    List<SimplePersonDto> toSimplePersonDtos(List<Person> person);

    @Mapping(target = "players", ignore = true)
    @Mapping(target = "birthday", expression = "java(birthdayToString(person))")
    Person toPerson(PersonDto person);
    @Mapping(target = "patronymic", ignore = true)
    @Mapping(target = "birthday", ignore = true)
    @Mapping(target = "players", ignore = true)
    Person toPerson(SimplePersonDto simplePersonDto);
}
