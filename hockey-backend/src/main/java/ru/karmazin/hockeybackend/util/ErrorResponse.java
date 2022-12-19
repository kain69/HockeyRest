package ru.karmazin.hockeybackend.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Vladislav Karmazin
 */
@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private long timestamp;
}
