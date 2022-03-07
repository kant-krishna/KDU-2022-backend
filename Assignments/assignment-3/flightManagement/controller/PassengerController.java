package com.flightManagement.controller;

import com.flightManagement.service.PassengerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping("/api/passenger")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @Value("${spring.application.name}")
    private static String applicationName;

    private final Logger logger = LoggerFactory.getLogger(PassengerController.class);

    @GetMapping("/")
    ResponseEntity getAllPassenger(){
        logger.info("Received a Get all passenger!");
        return Optional.of(new ResponseEntity(passengerService
                .getAllPassenger(), HttpStatus.OK))
                .orElse(new ResponseEntity(null,HttpStatus.NOT_FOUND));
    }
    @GetMapping("/by")
    ResponseEntity getPassengerByFlightId(@PathParam("flightID") Long flightID){
        logger.info("Received a Get request for FlightID:{} ",flightID);
        return Optional.of(new ResponseEntity(passengerService
                .getAllPassengerByFlight(flightID),HttpStatus.OK
        )).orElse(new ResponseEntity(null,HttpStatus.NOT_FOUND));
    }
}
