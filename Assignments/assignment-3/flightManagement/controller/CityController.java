package com.flightManagement.controller;

import com.flightManagement.dto.CityDto;
import com.flightManagement.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    CityService cityService;

    @PostMapping()
    CityDto addCity(@RequestBody CityDto city){
        return cityService.addCity(city);
    }
    @GetMapping("/all")
    ResponseEntity<List<CityDto>> getAllCity(){
        return new ResponseEntity<>(cityService.getAllCity(),
                HttpStatus.OK);
    }

}
