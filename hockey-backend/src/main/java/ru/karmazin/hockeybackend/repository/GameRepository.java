package ru.karmazin.hockeybackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.karmazin.hockeybackend.model.Game;

import java.util.List;

/**
 * @author Vlad Karmazin
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    List<Game> findAllByTeam_Id(int team_id);
}
