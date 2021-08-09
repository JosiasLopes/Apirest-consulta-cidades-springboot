package com.github.josiaslopes.citiesapi.controller;


import com.github.josiaslopes.citiesapi.entity.State;
import com.github.josiaslopes.citiesapi.service.StateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/states")
public class ControllerState {

    private StateService stateService;
    @GetMapping
    public List<State> listAll(){
        return this.stateService.listAll();
    }

    @GetMapping("/")    //verbo get no browser
    public String test(){
        return "123...testando";
    }

    /*
    @GetMapping("/{id}")
    public State getById(@PathVariable Long id) throws StateNotFoundException {
        return this.stateService.getById(id);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id) {
        return this.stateService.getOne(id);
    }

    //a abordagem de page permite usar queryStrings para personalizar a resposta exemplo:
    //pagecountries?page=0&size=10&sort=name.asc
    @GetMapping("/pagedStates")
    public Page<State> states(Pageable page){
        return this.stateService.listAll(page);
    }
}
