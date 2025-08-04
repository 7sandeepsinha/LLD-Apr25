package dev.sandeep.BookMyShowApr25.exception;

public class TheatreNotFoundException extends RuntimeException {
    public TheatreNotFoundException() {
    }

    public TheatreNotFoundException(String message) {
        super(message);
    }
}
