package com.flightManagement.controller;

import com.flightManagement.dto.AirplaneDto;
import com.flightManagement.service.AirplaneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/airplane")
public class AirplaneController {
    @Autowired
    AirplaneService airplaneService;

    @GetMapping("/")
    ResponseEntity<List<AirplaneDto>> getAllAirplane(){
        return  new ResponseEntity<>(airplaneService.getAllAirplane(), HttpStatus.OK);

    }
}
