package com.flightManagement.mapper;

import com.flightManagement.dto.AirportDto;
import com.flightManagement.entity.Airport;
import org.springframework.stereotype.Component;

@Component

public class AirportMapper {

    public AirportDto fromEntity(Airport airport){
        AirportDto airportDto= new AirportDto();
        airportDto.setAirportCode(airport.getAirportCode());
        airportDto.setAirportName(airport.getAirportName());
        airportDto.setCountryCode(airport.getCountry().getCountryCode());
        airportDto.setCityCode(airport.getCity().getCityCode());
        return airportDto;
    }
}
