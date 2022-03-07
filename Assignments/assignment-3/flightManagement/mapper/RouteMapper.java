package com.flightManagement.mapper;

import com.flightManagement.dto.RouteDto;
import com.flightManagement.entity.Route;
import org.springframework.stereotype.Component;

@Component
public class RouteMapper {

    public RouteDto fromEntity(Route route){
        RouteDto routeDto= new RouteDto();
        routeDto.setRouteId(route.getRouteId());
        routeDto.setArrivalAirport(route.getArrivalAirport().getAirportCode());
        routeDto.setDepartureAirport(route.getDepartureAirport().getAirportCode());
        return routeDto;
    }
}
