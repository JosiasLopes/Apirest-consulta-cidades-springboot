package com.github.josiaslopes.citiesapi.controller.advice;

import com.github.josiaslopes.citiesapi.exception.CityNotFoundException;
import com.github.josiaslopes.citiesapi.exception.CountryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CityNotFoundException.class)
    public void notFound(){

    }
}
