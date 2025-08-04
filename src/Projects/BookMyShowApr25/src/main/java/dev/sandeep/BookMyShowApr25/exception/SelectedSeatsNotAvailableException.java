package dev.sandeep.BookMyShowApr25.exception;

public class SelectedSeatsNotAvailableException extends RuntimeException {
    public SelectedSeatsNotAvailableException() {
    }

    public SelectedSeatsNotAvailableException(String message) {
        super(message);
    }
}
