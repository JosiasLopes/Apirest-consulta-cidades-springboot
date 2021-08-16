package com.github.josiaslopes.citiesapi.service;

import com.github.josiaslopes.citiesapi.entity.City;
import com.github.josiaslopes.citiesapi.exception.CityNotFoundException;
import com.github.josiaslopes.citiesapi.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private final CityRepository CityRepo;

   // @Autowired  //faz a injeção od PersonRepository é como se ele fizesse um construtor
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
    //contrariando a noção de restfull ele retornou u status de ok( mas é possivel retornar um 404 ou etc)
    public ResponseEntity<City> getById(Long id) throws CityNotFoundException {

        Optional<City> opt = this.CityRepo.findById(id);
        if(opt.isPresent()){
            return ResponseEntity.ok().body(opt.get());
        }else{
             throw new CityNotFoundException(id);
            //return ResponseEntity.notFound().build(); //pode fazer isso
          // return ResponseEntity.ok().body( "Registro da cidade"+id+" não encontrada"); //ou isso
        }
    }

    //mesmo método acima porem retorna uma entidade ao inves de um responseEntity
    //dessa forma podemos criar um ExceptionHandler e passar o status da response aproprado
    public ResponseEntity<City> getCityById(Long id) {
        Optional<City> opt = this.CityRepo.findById(id);
        if(opt.isPresent()){
            return ResponseEntity.ok().body(opt.get());
        }else{
            throw new CityNotFoundException(id);
            //return ResponseEntity.notFound().build(); //pode fazer isso
            // return ResponseEntity.ok().body( "Registro da cidade"+id+" não encontrada"); //ou isso
        }
    }

    //aqui foi setado o status manualmente sem usar handler
    public ResponseEntity<City> getOne(Long id){
        Optional<City> opt = this.CityRepo.findById(id);
        if(opt.isPresent()){
            return ResponseEntity.ok().body(opt.get());
        }else{
            return ResponseEntity.notFound().build();
           // return ResponseEntity.ok().body("Registro da cidade"+id+" não encontrada");
        }

    }

    public City CityIsExists(Long id) throws CityNotFoundException {
        City cidade= this.CityRepo.findById(id).orElseThrow(()->new CityNotFoundException(id));
        return cidade;
    }
}
