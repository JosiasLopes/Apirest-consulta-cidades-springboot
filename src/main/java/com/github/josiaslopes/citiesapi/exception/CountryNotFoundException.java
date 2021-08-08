package com.github.josiaslopes.citiesapi.exception;

public class CountryNotFoundException extends Exception{

    String message;

    public CountryNotFoundException(Long id) {
        this.message = "País "+id+" não encontrado";
    }
}
