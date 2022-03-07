package com.flightManagement.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AirportDto implements Serializable {
    private  String airportCode;
    private  String airportName;
    private  String cityCode;
    private  String countryCode;
}
