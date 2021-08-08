package com.github.josiaslopes.citiesapi.controller;


import com.github.josiaslopes.citiesapi.entity.Country;
import com.github.josiaslopes.citiesapi.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/countries")

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



}
