package dev.sandeep.BookMyShowApr25.exception;

public class ShowSeatNotFoundException extends RuntimeException {
    public ShowSeatNotFoundException() {
    }

    public ShowSeatNotFoundException(String message) {
        super(message);
    }
}
