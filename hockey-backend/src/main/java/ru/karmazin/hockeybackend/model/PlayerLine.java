package ru.karmazin.hockeybackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vlad Karmazin
 */
@Entity
@Table(name = "player_line")
@Data
@NoArgsConstructor
public class PlayerLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int position;
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
    @ManyToOne
    @JoinColumn(name = "line_id")
    private Line line;
}
