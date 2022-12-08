package ru.karmazin.hockeybackend.exception;

/**
 * @author Vladislav Karmazin
 */
public class NotCreatedException extends RuntimeException{
    public NotCreatedException(String msg) {
        super(msg);
    }
}
