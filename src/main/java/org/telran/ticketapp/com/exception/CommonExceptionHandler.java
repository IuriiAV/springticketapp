package org.telran.ticketapp.com.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler({TravelTicketNotFoundException.class,
            UserNotFoundException.class})
    public ResponseEntity handleNotFoundException(
            Exception exception, WebRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(NoUniqueUserEmailException.class)
    public ResponseEntity handleNoUniqueEmailException(Exception exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
