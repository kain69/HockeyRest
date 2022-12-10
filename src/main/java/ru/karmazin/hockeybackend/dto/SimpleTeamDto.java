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
public class SimpleTeamDto {
    private int id;
    private String name;
}
