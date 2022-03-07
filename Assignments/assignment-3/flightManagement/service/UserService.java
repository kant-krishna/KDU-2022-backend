package com.flightManagement.service;

import com.flightManagement.dto.FlightDto;

import java.util.List;

public interface UserService {

    List<FlightDto> getFlightFromTo(String departureCityCode, String destinationCityCode);


}
