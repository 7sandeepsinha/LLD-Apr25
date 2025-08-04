package dev.sandeep.BookMyShowApr25.exception;

public class ShowNotFoundException extends RuntimeException {
    public ShowNotFoundException() {
    }

    public ShowNotFoundException(String message) {
        super(message);
    }
}
