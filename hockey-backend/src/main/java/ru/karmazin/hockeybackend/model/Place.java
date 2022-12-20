package ru.karmazin.hockeybackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Vlad Karmazin
 */
@Entity
@Table(name = "place")
@Data
@NoArgsConstructor
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name souldn`t be empty")
    private String name;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Game> game;

    public Place(String name){
        this.name = name;
    }
}
