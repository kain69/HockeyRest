package ru.karmazin.hockeybackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vlad Karmazin
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "approved_player")
public class ApprovedPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    private boolean isReady;
}
