package com.flightManagement.service;

import com.flightManagement.dto.RouteDto;
import com.flightManagement.entity.Route;

import java.util.List;

public interface RouteService {
    List<RouteDto> getAllRoute();
    List<RouteDto> getRoutesBetween(String deptAirport, String arrivalAirport);
}
