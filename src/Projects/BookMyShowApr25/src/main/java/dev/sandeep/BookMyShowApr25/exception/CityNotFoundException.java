package dev.sandeep.BookMyShowApr25.exception;

public class CityNotFoundException extends RuntimeException {
    public CityNotFoundException() {
    }

    public CityNotFoundException(String message) {
        super(message);
    }

    public CityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
