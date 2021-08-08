package com.github.josiaslopes.citiesapi.service;


import com.github.josiaslopes.citiesapi.entity.Country;
import com.github.josiaslopes.citiesapi.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

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
}
