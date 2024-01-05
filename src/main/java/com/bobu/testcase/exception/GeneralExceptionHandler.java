package com.bobu.testcase.exception;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;


import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        Map<String, Object> errors = new HashMap<>();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        if (ex instanceof MethodArgumentNotValidException) {

            ((MethodArgumentNotValidException) ex).getAllErrors().forEach(err ->  errors.put("message" ,err.getDefaultMessage()));

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
            errors.put("message", "Internal Server Error");
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
