package ru.karmazin.hockeybackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.karmazin.hockeybackend.model.ApprovedPlayer;

import java.util.List;

/**
 * @author Vlad Karmazin
 */
@Repository
public interface ApprovedPlayerRepository extends JpaRepository<ApprovedPlayer, Integer> {
    List<ApprovedPlayer> findAllByGame_Id(int game_id);
}
