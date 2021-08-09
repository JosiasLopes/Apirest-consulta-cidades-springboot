package com.github.josiaslopes.citiesapi.service;

import com.github.josiaslopes.citiesapi.entity.State;
import com.github.josiaslopes.citiesapi.exception.StateNotFoundException;
import com.github.josiaslopes.citiesapi.repository.StateRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    private final StateRepository stateRepo;

    public StateService(StateRepository stateRepo){
        this.stateRepo = stateRepo;
    }
    
    public List<State> listAll() {
        java.util.List<com.github.josiaslopes.citiesapi.entity.State> paises = stateRepo.findAll();
        return paises;
    }

    public Page<State> listAll(Pageable page) {
        return stateRepo.findAll(page);

    }
    public State getById(Long id) throws StateNotFoundException {
        State pais = StateIsExists(id);
        return pais;
    }

    public ResponseEntity getOne(Long id){
        Optional<State> opt = this.stateRepo.findById(id);
        if(opt.isPresent()){
            return ResponseEntity.ok().body(opt.get());
        }else{
            //return ResponseEntity.notFound().build();
            return ResponseEntity.ok().body("Registro do pais "+id+" não encontrado");
        }

    }

    public State StateIsExists(Long id) throws StateNotFoundException {
        State pais= this.stateRepo.findById(id).orElseThrow(()->new StateNotFoundException(id));
        return pais;
    }

}
