package ru.karmazin.hockeybackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.karmazin.hockeybackend.model.Player;

import java.util.List;

/**
 * @author Vladislav Karmazin
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findAllByTeam_Id(int team_id);
}
