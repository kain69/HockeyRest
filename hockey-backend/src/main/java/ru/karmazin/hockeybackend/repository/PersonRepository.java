package ru.karmazin.hockeybackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.karmazin.hockeybackend.model.Person;

/**
 * @author Vladislav Karmazin
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
