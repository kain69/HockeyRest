package ru.karmazin.hockeybackend.dto.person;

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
@Schema(description = "Информация о человеке")
public class PersonCreateUpdateDto {
    @Schema(description = "Имя")
    private String name;
    @Schema(description = "Фамилия")
    private String surname;
    @Schema(description = "Отчество")
    private String patronymic;
    @Schema(description = "Дата рождения")
    private String birthday;
    @Schema(description = "Рейтинг")
    private Integer rating;
}
