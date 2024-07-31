package org.telran.ticketapp.com.exception;

public class NoUniqueUserEmailException extends RuntimeException {

    public NoUniqueUserEmailException(String message) {
        super(message);
    }
}
