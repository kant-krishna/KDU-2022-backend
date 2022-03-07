package com.flightManagement.service;

import com.flightManagement.dto.FlightDto;

import java.util.List;

public interface FlightService {
    List<FlightDto> getByRouteID(Long routeID);

    FlightDto addFlight(FlightDto flightDto);
}
