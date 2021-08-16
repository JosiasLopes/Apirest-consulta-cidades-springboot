package com.github.josiaslopes.citiesapi.controller;

import com.github.josiaslopes.citiesapi.entity.City;
import com.github.josiaslopes.citiesapi.exception.CityNotFoundException;
import com.github.josiaslopes.citiesapi.service.CityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/cities")
public class ControllerCity {

    private final CityService cityService;

    public ControllerCity(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<City> listAll(){
        return this.cityService.listAll();
    }




    @GetMapping("/city/{id}")
    public ResponseEntity<City> getById(@PathVariable Long id)  {

        try{
            return this.cityService.getById(id);
        } catch (CityNotFoundException e) {
           // return ResponseEntity.ok().body( e.getMessage());
            return ResponseEntity.notFound().build();
        }

    }

    //testando o exceptionhandler
    @GetMapping("/test/{id}")
    public ResponseEntity<City> getById2(@PathVariable Long id)  {
            return this.cityService.getCityById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getOne(@PathVariable Long id) {
        return this.cityService.getOne(id);
    }

    //a abordagem de page permite usar queryStrings para personalizar a resposta exemplo:
    //pagecountries?page=0&size=10&sort=name.asc
    @GetMapping("/pagedcities")
    public Page<City> countries(Pageable page){
        return this.cityService.listAll(page);
    }
}
