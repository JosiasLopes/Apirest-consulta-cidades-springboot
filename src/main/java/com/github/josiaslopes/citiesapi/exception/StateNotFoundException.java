package com.github.josiaslopes.citiesapi.exception;

public class StateNotFoundException extends Exception{


    String message;

    public StateNotFoundException(Long id) {
        this.message = "Estado "+id+" não encontrado";
    }
}
