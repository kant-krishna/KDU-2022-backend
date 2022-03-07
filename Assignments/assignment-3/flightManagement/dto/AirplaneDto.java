package com.flightManagement.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AirplaneDto implements Serializable {
    private  String airplaneCode;
    private  String airplaneName;
    private  Long bSeats;
    private  Long eSeats;
    private  Long fSeats;
}
