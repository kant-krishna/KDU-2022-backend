package com.flightManagement.service;

import com.flightManagement.dto.FlightDto;
import com.flightManagement.dto.RouteDto;
import com.flightManagement.mapper.FlightMapper;
import com.flightManagement.mapper.RouteMapper;
import com.flightManagement.mapper.UserMapper;
import com.flightManagement.repository.FlightRepository;
import com.flightManagement.repository.RouteRepository;
import com.flightManagement.repository.UserRepository;
import com.flightManagement.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    FlightMapper flightMapper;


    @Override
    public List<FlightDto> getFlightFromTo(String departureCityCode, String destinationCityCode) {
        return flightRepository.findAll()
                .stream().map(flightMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
