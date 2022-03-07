package com.flightManagement.service;

import com.flightManagement.dto.RouteDto;
import com.flightManagement.mapper.RouteMapper;
import com.flightManagement.repository.RouteRepository;
import com.flightManagement.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RouteServiceImpl implements RouteService {

    @Autowired
    RouteRepository routeRepository;

    @Autowired
    RouteMapper routeMapper;

    @Override
    public List<RouteDto> getAllRoute() {
        return routeRepository.findAll()
                .stream().map(routeMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<RouteDto> getRoutesBetween(String dept, String arrival) {
       return routeRepository.findBetweenArrivalAndDeparture(dept,arrival)
               .stream().map(routeMapper::fromEntity)
               .collect(Collectors.toList());
    }
}
