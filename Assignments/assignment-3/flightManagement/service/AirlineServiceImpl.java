package com.flightManagement.service;

import com.flightManagement.dto.AirlineDto;
import com.flightManagement.mapper.AirlineMapper;
import com.flightManagement.repository.AirlineRepository;
import com.flightManagement.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AirlineServiceImpl implements AirlineService {

    @Autowired
    AirlineRepository airlineRepository;

    @Autowired
    AirlineMapper airlineMapper;

    @Override
    public List<AirlineDto> getAllAirline() {
        return airlineRepository.findAll()
                .stream()
                .map(airlineMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AirlineDto> getAirlineById(String id) {
        return airlineRepository.findById(id)
                .map(airlineMapper::fromEntity);
    }
}
