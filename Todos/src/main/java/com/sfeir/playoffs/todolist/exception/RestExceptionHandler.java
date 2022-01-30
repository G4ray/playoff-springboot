package com.sfeir.playoffs.todolist.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BeanNotFound.class)
    public ResponseEntity<Object> handleEntityNotFound(
            BeanNotFound ex) {
        return new ResponseEntity<>(ex.getMessage(), NOT_FOUND);
    }
}
