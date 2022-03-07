package com.flightManagement.dto;

import com.flightManagement.dto.CountryDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class CityDto implements Serializable {
    private  String cityCode;
    private  String cityName;
    private  String countryCode;
}
