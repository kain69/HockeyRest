package ru.karmazin.hockeybackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.karmazin.hockeybackend.entity.Player;

/**
 * @author Vladislav Karmazin
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
