package ru.karmazin.hockeybackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.karmazin.hockeybackend.entity.Team;

/**
 * @author Vladislav Karmazin
 */
@Repository
public interface TeamRepository extends JpaRepository<Team,Integer> {

}
