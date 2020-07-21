package hu.zerotohero.verseny.crud.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity handleException(ResponseStatusException e) {
        return ResponseEntity.status(e.getStatus()).body(e.getReason());
    }
}
