package com.github.josiaslopes.citiesapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Cidade não encontrada!!")
public class CityNotFoundException extends RuntimeException{

    String message;

    public CityNotFoundException(Long id) {
        this.message = "Cidade "+id+" não encontrada";
    }

    @Override
    public String getMessage() {
        return message = "Cidade não encontrada";
    }
}
