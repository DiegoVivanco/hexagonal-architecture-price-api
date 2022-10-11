package com.dlvivanco.price.api.domain.exception;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@ControllerAdvice
public class CustomerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(PriceNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.getReasonPhrase(), List.of(ex.getLocalizedMessage()));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConversionFailedException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(RuntimeException ex) {
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), List.of(ex.getLocalizedMessage()));
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(NoSuchElementException.class )
    public ResponseEntity<ErrorResponse> handleNoSuchElement(RuntimeException ex) {
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), List.of(ex.getLocalizedMessage()));
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        String name = ex.getName();
        String type = Objects.requireNonNull(ex.getRequiredType()).getSimpleName();
        Object value = ex.getValue();
        String message = String.format("'%s' should be a valid '%s' and '%s' isn't",
                name, type, value);
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), List.of(message));
        return ResponseEntity.badRequest().body(error);
    }
}
