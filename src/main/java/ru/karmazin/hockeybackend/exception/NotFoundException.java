package ru.karmazin.hockeybackend.exception;

/**
 * @author Vladislav Karmazin
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String msg){
        super(msg);
    }
}
