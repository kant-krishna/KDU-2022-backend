package com.flightManagement.service;

import com.flightManagement.dto.FlightDto;
import com.flightManagement.entity.Airplane;
import com.flightManagement.entity.Flight;
import com.flightManagement.entity.Route;
import com.flightManagement.mapper.FlightMapper;
import com.flightManagement.repository.AirplaneRepository;
import com.flightManagement.repository.FlightRepository;
import com.flightManagement.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightMapper flightMapper;
    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Override
    public List<FlightDto> getByRouteID(Long routeID) {
        return flightRepository.findByRoute_Id(routeID).stream()
                .map(flightMapper::fromEntity).collect(Collectors.toList());
    }

    @Override
    public FlightDto addFlight(FlightDto flightDto) {
        Airplane airplane= airplaneRepository.getById(flightDto.getAirplaneCode());
        Route route= routeRepository.getById(flightDto.getRouteId());
        Flight flight=flightMapper
                .toEntity(flightDto,airplane,route);
        flightRepository.save(flight);
        return flightDto;

    }
}
