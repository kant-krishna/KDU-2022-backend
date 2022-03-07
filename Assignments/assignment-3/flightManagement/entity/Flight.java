package com.flightManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "instances")
@Data
public class Flight {

    //Table Columns
    @Id
    @GeneratedValue
    @Column(name = "instance_id")
    private Long instanceId;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    @ManyToOne
    @JoinColumn(name = "plane_id", referencedColumnName = "Code")
    private Airplane airplane;

    @Column(name = "eseats")
    private int eSeats;

    @Column(name = "bseats")
    private int bSeats;

    @Column(name = "fseats")
    private int fSeats;

    @Column(name = "eCost")
    private Double eCost;

    @Column(name = "bCost")
    private Double bCost;

    @Column(name = "fCost")
    private Double fCost;

    @Column(name = "departure")
    private String departureTime;

    @Column(name = "arrival")
    private String arrivalTime;

    //Mapping Key
    @JsonIgnore
    @OneToMany(mappedBy = "flightInstance")
    private List<Passenger> passengers;

}
