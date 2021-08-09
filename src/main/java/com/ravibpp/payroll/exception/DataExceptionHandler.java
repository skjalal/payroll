package com.ravibpp.payroll.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Log4j2
@ControllerAdvice
public class DataExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Throwable> getException(Throwable ex) {
        log.error("Failed to process", ex);
        return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
