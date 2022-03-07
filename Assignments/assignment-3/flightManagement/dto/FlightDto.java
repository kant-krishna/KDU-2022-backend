package com.flightManagement.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class FlightDto implements Serializable {
    private  Long instanceId;
    private  Long routeId;
    private  String airplaneCode;
    private  int eSeats;
    private  int bSeats;
    private  int fSeats;
    private  Double eCost;
    private  Double bCost;
    private  Double fCost;
    private  String departureTime;
    private  String arrivalTime;
}
