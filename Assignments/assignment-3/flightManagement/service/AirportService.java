package com.flightManagement.service;

import com.flightManagement.dto.AirportDto;

import java.util.List;

public interface AirportService {
    List<AirportDto> getAirportByCityId(String cityId);

    List<AirportDto> getAllAirport();
}
