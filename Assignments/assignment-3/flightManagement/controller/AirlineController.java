package com.flightManagement.controller;

import com.flightManagement.dto.AirlineDto;
import com.flightManagement.service.AirlineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/airline")
public class AirlineController {
    @Autowired
    AirlineService airlineService;

    @GetMapping("/{id}")
    public Optional<AirlineDto> getAirlineById(@PathVariable String id){
        return airlineService.getAirlineById(id);
    }
}
