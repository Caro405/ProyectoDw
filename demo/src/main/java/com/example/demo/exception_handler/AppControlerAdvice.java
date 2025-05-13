package com.example.demo.exception_handler;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.dto.ErrorDTO;

@ControllerAdvice
public class AppControlerAdvice {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorDTO> handleNotFoundException(NoSuchElementException e) {
        return ResponseEntity // sirve para encapsular el dato de respuesta 
                .status(HttpStatus.NOT_FOUND) // status indica que el estado de lo que pasa
                .body(new ErrorDTO("Resource does not exist"));
    }

}
