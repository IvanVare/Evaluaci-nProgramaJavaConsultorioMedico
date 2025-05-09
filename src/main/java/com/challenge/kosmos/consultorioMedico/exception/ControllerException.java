package com.challenge.kosmos.consultorioMedico.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class ControllerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ServiceException.class)
    public ResponseEntity<?>  serviceExceptionHandler(ServiceException serviceException){
        ErrorDTO errorDTO = ErrorDTO.builder()
                .status(serviceException.getHttpStatus().toString())
                .message(serviceException.getMessage())
                .build();
        return new ResponseEntity<>(errorDTO,serviceException.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, Object> stringObjectMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            stringObjectMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(stringObjectMap);
    }
}
