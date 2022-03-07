package com.flightManagement.dto;

import com.flightManagement.dto.AirlineDto;
import com.flightManagement.dto.AirportDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class RouteDto implements Serializable {
    private  long routeId;
    private  String airlineCode;
    private  String departureAirport;
    private  String arrivalAirport;
}
