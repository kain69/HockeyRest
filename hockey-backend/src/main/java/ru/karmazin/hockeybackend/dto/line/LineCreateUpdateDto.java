package ru.karmazin.hockeybackend.dto.line;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vlad Karmazin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineCreateUpdateDto {
    private String name;
    private int team_id;
}
