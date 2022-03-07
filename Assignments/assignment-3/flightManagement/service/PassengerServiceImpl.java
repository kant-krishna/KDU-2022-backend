package com.flightManagement.service;

import com.flightManagement.dto.PassengerDto;
import com.flightManagement.entity.Flight;
import com.flightManagement.entity.Passenger;
import com.flightManagement.entity.User;
import com.flightManagement.mapper.PassengerMapper;
import com.flightManagement.repository.FlightRepository;
import com.flightManagement.repository.PassengerRepository;
import com.flightManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerMapper passengerMapper;

    @Override
    public PassengerDto addPassenger(PassengerDto passengerDto) {

        User user= userRepository.getById(passengerDto.getUserId());
        Flight flight= flightRepository.getById(passengerDto.getFlightID());
        Passenger passenger= passengerMapper.toEntity(passengerDto,user,flight);
        passengerRepository.save(passenger);
        return passengerDto;

    }

    @Override
    public List<PassengerDto> getAllPassenger() {
        return passengerRepository.findAll()
                .stream()
                .map(passengerMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<PassengerDto> getAllPassengerByFlight(Long flightId) {
        return passengerRepository.findByFlightId(flightId)
                .stream()
                .map(passengerMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
