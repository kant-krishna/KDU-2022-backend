package com.flightManagement.service;

import com.flightManagement.dto.PassengerDto;

import java.util.List;

public interface PassengerService {
    PassengerDto addPassenger(PassengerDto passengerDto);
    List<PassengerDto> getAllPassenger();
    List<PassengerDto> getAllPassengerByFlight(Long flightId);
}
