package com.flightManagement.mapper;

import com.flightManagement.dto.FlightDto;
import com.flightManagement.entity.Airplane;
import com.flightManagement.entity.Flight;
import com.flightManagement.entity.Route;
import org.springframework.stereotype.Component;

@Component

public class FlightMapper {

    public FlightDto fromEntity(Flight flight){
        FlightDto flightDto= new FlightDto();
        flightDto.setInstanceId(flight.getInstanceId());
        flightDto.setAirplaneCode(flight.getAirplane().getAirplaneCode());
        flightDto.setArrivalTime(flight.getArrivalTime());
        flightDto.setDepartureTime(flight.getDepartureTime());
        flightDto.setBCost(flight.getBCost());
        flightDto.setECost(flight.getECost());
        flightDto.setFCost(flight.getFCost());
        flightDto.setBSeats(flight.getBSeats());
        flightDto.setECost(flight.getECost());
        flightDto.setFCost(flight.getFCost());
        flightDto.setRouteId(flight.getRoute().getRouteId());
        return flightDto;
    }

    public  Flight toEntity(
            FlightDto flightDto,
            Airplane airplane,
            Route route
    ){
        Flight flight= new Flight();
        flight.setInstanceId(flightDto.getInstanceId());
        flight.setAirplane(airplane);
        flight.setRoute(route);
        flight.setArrivalTime(flightDto.getArrivalTime());
        flight.setDepartureTime(flightDto.getDepartureTime());
        flight.setBCost(flightDto.getBCost());
        flight.setECost(flightDto.getECost());
        flight.setFCost(flightDto.getFCost());
        flight.setBSeats(flightDto.getBSeats());
        flight.setECost(flightDto.getECost());
        flight.setFCost(flightDto.getFCost());
        return flight;


    }
}
