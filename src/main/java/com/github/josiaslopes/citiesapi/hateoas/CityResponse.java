package com.github.josiaslopes.citiesapi.hateoas;

import com.github.josiaslopes.citiesapi.entity.City;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.transaction.support.ResourceHolderSupport;

//herdaria de ResourceSupport mas ele esta deprecated então usamos
//representation model
public class CityResponse extends RepresentationModel<CityResponse> {

    private String name;
    private Integer uf;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUf() {
        return uf;
    }

    public void setUf(Integer uf) {
        this.uf = uf;
    }
}
