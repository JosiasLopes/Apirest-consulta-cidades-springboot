package com.github.josiaslopes.citiesapi.controller;


import com.github.josiaslopes.citiesapi.entity.Country;
import com.github.josiaslopes.citiesapi.exception.CountryNotFoundException;
import com.github.josiaslopes.citiesapi.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("api/v1/countries")

public class ControllerCountry {

    @Autowired
    private CountryService countryService;

   // @Autowired  //faz a injeção do service que interage com o repository
    public ControllerCountry(CountryService countryService){
     this.countryService = countryService;
    }

    @GetMapping
    public List<Country> listAll(){
        return this.countryService.listAll();
    }

    @GetMapping("/")    //verbo get no browser
    public String test(){
        return "123...testando";
    }

    /*
    @GetMapping("/{id}")
    public Country getById(@PathVariable Long id) throws CountryNotFoundException {
        return this.countryService.getById(id);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id) {
        return this.countryService.getOne(id);
    }

    //a abordagem de page permite usar queryStrings para personalizar a resposta exemplo:
    //pagecountries?page=0&size=10&sort=name.asc
    @GetMapping("/pagedcountries")
    public Page<Country> countries(Pageable page){
        return this.countryService.listAll(page);
    }



}
