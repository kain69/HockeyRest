package ru.karmazin.hockeybackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.karmazin.hockeybackend.dto.PersonDto;
import ru.karmazin.hockeybackend.dto.SimplePersonDto;
import ru.karmazin.hockeybackend.mapper.PersonMapper;
import ru.karmazin.hockeybackend.model.Person;
import ru.karmazin.hockeybackend.exception.NotFoundException;
import ru.karmazin.hockeybackend.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Vladislav Karmazin
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public List<SimplePersonDto> findAll() {
        return personMapper.toSimplePersonDtos(personRepository.findAll());
    }

    public PersonDto findOne(int id) {
        return personMapper.toPersonDto(this.getPerson(id));
    }

    @Transactional
    public void save(PersonDto personDto) {
        Person person = personMapper.toPerson(personDto);
        personRepository.save(person);
    }

    @Transactional
    public void update(PersonDto updatedPersonDto, int id) {
        Person updatedPerson = personMapper.toPerson(updatedPersonDto);
        updatedPerson.setPlayers(this.getPerson(id).getPlayers());
        personRepository.save(updatedPerson);
    }

    @Transactional
    public void delete(int id) {
        personRepository.delete(this.getPerson(id));
    }

    public Person getPerson(int id) {
        Optional<Person> foundPerson = personRepository.findById(id);
        return foundPerson.orElseThrow(
                () -> new NotFoundException("Person with this id wasn`t found!")
        );
    }
}
