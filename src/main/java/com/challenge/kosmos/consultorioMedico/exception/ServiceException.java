package com.challenge.kosmos.consultorioMedico.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ServiceException extends RuntimeException{
    private HttpStatus httpStatus;

    public ServiceException(HttpStatus httpStatus, String message){
        super(message);
        this.httpStatus=httpStatus;
    }
}
