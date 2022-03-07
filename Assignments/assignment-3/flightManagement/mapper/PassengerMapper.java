package com.flightManagement.mapper;

import com.flightManagement.dto.PassengerDto;
import com.flightManagement.entity.Flight;
import com.flightManagement.entity.Passenger;
import com.flightManagement.entity.User;
import org.springframework.stereotype.Component;

@Component
public class PassengerMapper {

    public PassengerDto fromEntity(Passenger passenger){
        PassengerDto passengerDto= new PassengerDto();
        passengerDto.setPassengerID(passenger.getPassengerID());
        passengerDto.setPassengerName(passenger.getPassengerName());
        passengerDto.setAge(passenger.getAge());
        passengerDto.setCancelled(passenger.getCancelled());
        passengerDto.setConfirmed(passenger.getConfirmed());
        passengerDto.setFlightID(passenger.getFlight().getInstanceId());
        passengerDto.setEmail(passenger.getEmail());
        passengerDto.setPhone(passenger.getPhone());
        passengerDto.setUserId(passenger.getUser().getUserId());
        passengerDto.setSex(passenger.getSex());
        passengerDto.setSeatNumber(passenger.getSeatNumber());
        passengerDto.setType(passenger.getType());

        return passengerDto;
    }
    public Passenger toEntity(PassengerDto passengerDto, User user, Flight flight){
        Passenger passenger= new Passenger();
        passenger.setPassengerID(passengerDto.getPassengerID());
        passenger.setPassengerName(passengerDto.getPassengerName());
        passenger.setAge(passengerDto.getAge());
        passenger.setCancelled(passengerDto.getCancelled());
        passenger.setConfirmed(passengerDto.getConfirmed());
        passenger.setFlight(flight);
        passenger.setEmail(passengerDto.getEmail());
        passenger.setPhone(passengerDto.getPhone());
        passenger.setUser(user);
        passenger.setSex(passengerDto.getSex());
        passenger.setSeatNumber(passengerDto.getSeatNumber());
        passenger.setType(passengerDto.getType());
        return passenger;

    }
}
