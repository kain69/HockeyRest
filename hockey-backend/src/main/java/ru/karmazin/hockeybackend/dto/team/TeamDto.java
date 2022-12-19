package ru.karmazin.hockeybackend.dto.team;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vladislav Karmazin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Команда")
public class TeamDto {
    @Schema(description = "Идентификатор")
    private int id;
    @Schema(description = "Название")
    private String name;
}
