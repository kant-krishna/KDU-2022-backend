package com.flightManagement.service;

import com.flightManagement.dto.AirlineDto;

import java.util.List;
import java.util.Optional;

public interface AirlineService {
    List<AirlineDto> getAllAirline();

    Optional<AirlineDto> getAirlineById(String id);

}
