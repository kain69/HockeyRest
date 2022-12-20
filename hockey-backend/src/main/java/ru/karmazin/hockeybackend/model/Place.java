package ru.karmazin.hockeybackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private String name;

    public Place(String name){
        this.name = name;
    }
}
