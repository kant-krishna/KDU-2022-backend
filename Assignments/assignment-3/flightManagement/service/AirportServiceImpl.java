package com.flightManagement.service;

import com.flightManagement.dto.AirportDto;
import com.flightManagement.mapper.AirportMapper;
import com.flightManagement.repository.AirportRepository;
import com.flightManagement.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AirportServiceImpl implements AirportService {
    @Autowired
    AirportRepository airportRepository;

    @Autowired
    AirportMapper airportMapper;

    @Override
    public List<AirportDto> getAirportByCityId(String cityId) {
        return airportRepository.findByCityCode(cityId)
                .stream()
                .map(airportMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<AirportDto> getAllAirport() {
        return  airportRepository.findAll()
                .stream()
                .map(airportMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
