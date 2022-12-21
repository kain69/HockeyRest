package ru.karmazin.hockeybackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.karmazin.hockeybackend.model.Place;

/**
 * @author Vlad Karmazin
 */
@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {
}
