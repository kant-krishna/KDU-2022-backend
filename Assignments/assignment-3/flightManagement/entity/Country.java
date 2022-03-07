package com.flightManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "country")
@Data
public class Country {
    //table column //
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Code")
    private String countryCode;

    @Column(name = "Name")
    private String countryName;

    //Mapping of primary key to other//
    @JsonIgnore
    @OneToMany(mappedBy="country")
    private List<City> cities;
    @JsonIgnore
    @OneToMany(mappedBy = "country")
    private List<Airport> airports;


    public List<City> getCities(){ return Optional.ofNullable(cities).orElse(Collections.emptyList());
    }

}
