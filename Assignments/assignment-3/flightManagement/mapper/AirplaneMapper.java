package com.flightManagement.mapper;

import com.flightManagement.dto.AirplaneDto;
import com.flightManagement.entity.Airplane;
import org.springframework.stereotype.Component;

@Component
public class AirplaneMapper {

    public AirplaneDto fromEntity(Airplane airplane){
        AirplaneDto airplaneDto= new AirplaneDto();
        airplaneDto.setAirplaneCode(airplane.getAirplaneCode());
        airplaneDto.setAirplaneName(airplane.getAirplaneName());
        airplaneDto.setBSeats(airplane.getBSeats());
        airplaneDto.setESeats(airplane.getESeats());
        airplaneDto.setFSeats(airplane.getFSeats());
        return airplaneDto;
    }
}
