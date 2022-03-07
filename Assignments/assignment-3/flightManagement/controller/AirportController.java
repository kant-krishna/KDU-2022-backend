package com.flightManagement.controller;


import com.flightManagement.dto.AirportDto;
import com.flightManagement.service.AirportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/airport")
public class AirportController {

    @Autowired
    AirportService airportService;

    @GetMapping("/")
    ResponseEntity<List<AirportDto>> getAllAirport(){
        return new ResponseEntity<>(airportService.getAllAirport(),
                HttpStatus.OK);
    }

    @GetMapping("/{cityId}")
    ResponseEntity<List<AirportDto>> getAirportByCity(@PathVariable String cityId){
        return new ResponseEntity<>(airportService.getAirportByCityId(cityId),
               HttpStatus.OK );
    }

}
