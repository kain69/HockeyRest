package ru.karmazin.hockeybackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author Vladislav Karmazin
 */
@Entity
@Table(name = "Player")
@Setter
@Getter
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @NotEmpty(message = "Surname should not be empty")
    private String surname;
    @NotEmpty(message = "Patronymic should not be empty")
    private String patronymic;
    @NotNull(message = "Birthday should not be empty")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate birthday;
    @Min(value = 0, message = "Rating should be between 0 and 5")
    @Max(value = 5, message = "Rating should be between 0 and 5")
    @NotNull(message = "Rating should not be empty")
    private Integer rating;

    public Player(String name, String surname, String patronymic, LocalDate birthday, Integer rating) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.rating = rating;
    }
}
