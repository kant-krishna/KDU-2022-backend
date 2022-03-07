package com.flightManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "airplane")
@Entity
public class Airplane {
    //Table columns//
    @Id
    @GeneratedValue
    @Column(name = "Code")
    private String airplaneCode;

    @Column(name = "Name")
    private String airplaneName;

    @Column(name = "Bseats")
    private Long bSeats;

    @Column(name = "Eseats")
    private Long eSeats;

    @Column(name = "Fseats")
    private Long fSeats;

    //Mapping Key
    @JsonIgnore
    @OneToMany(mappedBy="airplane")
    private List<RoutePlane> routePlanes;

    @JsonIgnore
    @OneToMany(mappedBy = "airplane")
    private List<FlightInstance> fightInstances;
}
