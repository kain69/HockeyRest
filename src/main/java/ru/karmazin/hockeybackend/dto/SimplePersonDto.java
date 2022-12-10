package ru.karmazin.hockeybackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vladislav Karmazin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimplePersonDto {
    private int id;
    private String name;
    private String surname;
    private Integer rating;
}
