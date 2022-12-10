package ru.karmazin.hockeybackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vladislav Karmazin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private String birthday;
    private Integer rating;
}
