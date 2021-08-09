package com.github.josiaslopes.citiesapi.exception;

public class CityNotFoundException extends Exception{

    String message;

    public CityNotFoundException(Long id) {
        this.message = "Cidade "+id+" não encontrada";
    }
}
