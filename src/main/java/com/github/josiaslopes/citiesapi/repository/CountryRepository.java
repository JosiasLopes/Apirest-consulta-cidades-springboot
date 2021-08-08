package com.github.josiaslopes.citiesapi.repository;

import com.github.josiaslopes.citiesapi.entity.Country;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
