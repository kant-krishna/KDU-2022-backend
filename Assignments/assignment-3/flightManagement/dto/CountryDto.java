package com.flightManagement.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CountryDto implements Serializable {
    private  String countryCode;
    private  String countryName;
}
