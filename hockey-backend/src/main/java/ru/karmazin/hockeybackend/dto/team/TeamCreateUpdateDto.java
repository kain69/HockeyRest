package ru.karmazin.hockeybackend.dto.team;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Команда")
public class TeamCreateUpdateDto {
    @Schema(description = "Название")
    private String name;
}
