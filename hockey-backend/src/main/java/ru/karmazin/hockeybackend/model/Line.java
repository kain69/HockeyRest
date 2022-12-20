package ru.karmazin.hockeybackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Vlad Karmazin
 */
@Entity
@Table(name = "line")
@Data
@NoArgsConstructor
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToMany(mappedBy = "lines")
    private List<Game> games;

    @OneToMany(mappedBy = "line", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlayerLine> playerLines;


    public Line(String name, Team team) {
        this.name = name;
        this.team = team;
    }
}
