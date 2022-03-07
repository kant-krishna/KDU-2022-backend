package com.flightManagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "airports")
@Entity
public class Airport {
    //table column//
    @Id
    @GeneratedValue
    @Column(name = "Code")
    private String airportCode;

    @Column(name = "Name")
    private String airportName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_code",referencedColumnName = "Code")
    private City city;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_code", referencedColumnName = "Code")
    private Country country;
    //till here//

    @OneToMany(mappedBy = "departureAirport")
    private List<Route> depRoutes;

    @OneToMany(mappedBy = "arrivalAirport")
    private List<Route> arrRoutes;

}
