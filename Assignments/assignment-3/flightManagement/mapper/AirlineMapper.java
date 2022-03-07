package com.flightManagement.mapper;

import com.flightManagement.dto.AirlineDto;
import com.flightManagement.entity.Airline;
import org.springframework.stereotype.Component;

@Component
public class AirlineMapper {

    public AirlineDto fromEntity(Airline airline){
        AirlineDto airlineDto= new AirlineDto();
        airlineDto.setAirlinesCode(airline.getAirlineCode());
        airlineDto.setAirlinesName(airline.getAirlineName());
        return airlineDto;
    }
}
