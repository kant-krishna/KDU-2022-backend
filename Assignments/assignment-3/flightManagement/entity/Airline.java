package com.flightManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Table(name = "airlines")
@Entity
public class Airline {

    //Tables Column//
    @Id
    @Column(name = "Code")
    private String airlineCode;

    @Column(name = "Name")
    private String airlineName;

    //Mapping foreign key//
    @JsonIgnore
    @ManyToMany(mappedBy = "airline")
    private List<Route> routes;
}
