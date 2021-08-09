package com.github.josiaslopes.citiesapi.service;


import com.github.josiaslopes.citiesapi.entity.Country;
import com.github.josiaslopes.citiesapi.exception.CountryNotFoundException;
import com.github.josiaslopes.citiesapi.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private final CountryRepository countryRepo;

    @Autowired  //faz a injeção od PersonRepository é como se ele fizesse um construtor
    public CountryService(CountryRepository countryRepo){
        this.countryRepo = countryRepo;
    }

    public List<Country> listAll() {
        List<Country> paises = countryRepo.findAll();
        return paises;
    }

    public Page<Country> listAll(Pageable page) {
        return countryRepo.findAll(page);

    }
    public Country getById(Long id) throws CountryNotFoundException {
        Country pais = countryIsExists(id);
        return pais;
    }

    public ResponseEntity getOne(Long id){
        Optional<Country> opt = this.countryRepo.findById(id);
        if(opt.isPresent()){
            return ResponseEntity.ok().body(opt.get());
        }else{
            //return ResponseEntity.notFound().build();
            return ResponseEntity.ok().body("Registro do pais "+id+" não encontrado");
        }

    }

    public Country countryIsExists(Long id) throws CountryNotFoundException {
        Country pais= this.countryRepo.findById(id).orElseThrow(()->new CountryNotFoundException(id));
        return pais;
    }
}
