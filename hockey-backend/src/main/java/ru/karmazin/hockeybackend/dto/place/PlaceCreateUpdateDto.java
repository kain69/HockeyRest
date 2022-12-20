package ru.karmazin.hockeybackend.dto.place;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vlad Karmazin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceCreateUpdateDto {
    private String name;
}
