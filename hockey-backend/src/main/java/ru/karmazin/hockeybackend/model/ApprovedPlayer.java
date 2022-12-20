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
public class ApprovedPlayer {
    @Id
    private int id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id")
    @MapsId
    private Player player;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    private boolean isReady;
}
