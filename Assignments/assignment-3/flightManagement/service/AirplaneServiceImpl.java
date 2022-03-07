package com.flightManagement.service;

import com.flightManagement.dto.AirplaneDto;
import com.flightManagement.mapper.AirplaneMapper;
import com.flightManagement.repository.AirplaneRepository;
import com.flightManagement.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AirplaneServiceImpl implements AirplaneService {

    @Autowired
    AirplaneRepository airplaneRepository;

    @Autowired
    AirplaneMapper airplaneMapper;

    @Override
    public List<AirplaneDto> getAllAirplane() {
       return airplaneRepository.findAll().stream()
               .map(airplaneMapper::fromEntity)
               .collect(Collectors.toList());
    }
}
