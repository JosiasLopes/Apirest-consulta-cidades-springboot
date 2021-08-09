package com.github.josiaslopes.citiesapi.service;

import com.github.josiaslopes.citiesapi.entity.City;
import com.github.josiaslopes.citiesapi.exception.CityNotFoundException;
import com.github.josiaslopes.citiesapi.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class CityService {

    private final CityRepository CityRepo;

    @Autowired  //faz a injeção od PersonRepository é como se ele fizesse um construtor
    public CityService(CityRepository CityRepo){
        this.CityRepo = CityRepo;
    }

    public List<City> listAll() {
        List<City> paises = CityRepo.findAll();
        return paises;
    }

    public Page<City> listAll(Pageable page) {
        return CityRepo.findAll(page);

    }
    public City getById(Long id) throws CityNotFoundException {
        City pais = CityIsExists(id);
        return pais;
    }

    public ResponseEntity getOne(Long id){
        Optional<City> opt = this.CityRepo.findById(id);
        if(opt.isPresent()){
            return ResponseEntity.ok().body(opt.get());
        }else{
            //return ResponseEntity.notFound().build();
            return ResponseEntity.ok().body("Registro do pais "+id+" não encontrado");
        }

    }

    public City CityIsExists(Long id) throws CityNotFoundException {
        City pais= this.CityRepo.findById(id).orElseThrow(()->new CityNotFoundException(id));
        return pais;
    }
}
