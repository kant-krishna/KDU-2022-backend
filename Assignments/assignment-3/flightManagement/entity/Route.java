package com.flightManagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "routes")
@Entity
public class Route {

    //Table Columns//
    @Id
    @Column(name = "route_id")
    private Long routeId;

    @ManyToMany
    @JoinTable(
            name = "route_airline",
            joinColumns = @JoinColumn(name = "airline_code"),
            inverseJoinColumns = @JoinColumn(name = "Code")
    )
    private List<Airline> airline;

    @ManyToOne
    @JoinColumn(name = "departure_airport_code",referencedColumnName = "Code")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_code",referencedColumnName = "Code")
    private Airport arrivalAirport;
}
