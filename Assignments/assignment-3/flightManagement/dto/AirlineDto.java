package com.flightManagement.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AirlineDto implements Serializable {
    private  String airlinesCode;
    private  String airlinesName;
}
