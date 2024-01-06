package com.bobu.testcase.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        Map<String, Object> errors = new HashMap<>();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        if (ex instanceof MethodArgumentNotValidException) {

            ((MethodArgumentNotValidException) ex).getAllErrors().forEach(err ->  errors.put("message" ,err.getDefaultMessage()));
            System.out.println(ex);
        } else if (ex instanceof AlreadyExistException) {
            status = HttpStatus.CONFLICT;
            errors.put("message", ex.getMessage());
        } else if (ex instanceof NotFoundException) {
            status = HttpStatus.NOT_FOUND;
            errors.put("message", ex.getMessage());
        } else if (ex instanceof TokenNotValidException) {
            status = HttpStatus.BAD_REQUEST;
            errors.put("message", ex.getMessage());
        } else {
            errors.put("message", ex.getMessage());
        }

        return new ResponseEntity<>(errors, status);
    }
    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<?> alreadyExistExceptionHandler(AlreadyExistException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundExceptionHandler(NotFoundException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(TokenNotValidException.class)
    public ResponseEntity<?> tokenNotValidExceptionHandler(TokenNotValidException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
