package ru.karmazin.hockeybackend.dto.person;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vladislav Karmazin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Информация о человеке")
public class SimplePersonDto {
    @Schema(description = "Идентификатор")
    private int id;
    @Schema(description = "Имя")
    private String name;
    @Schema(description = "Кармазин")
    private String surname;
    @Schema(description = "Рейтинг")
    private Integer rating;
}
