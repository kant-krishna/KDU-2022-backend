package com.flightManagement.controller;


import com.flightManagement.dto.RouteDto;
import com.flightManagement.service.RouteService;
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
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/routes")
public class RouteController {
    @Autowired
    RouteService routeService;

    @GetMapping("/")
    ResponseEntity<List<RouteDto>> getAllRoute(){
        return Optional.of(new ResponseEntity<>(
                routeService.getAllRoute(), HttpStatus.OK
        )).orElse(new ResponseEntity<>(null,HttpStatus.NOT_FOUND));
    }

    @GetMapping("/between")
    ResponseEntity<List<RouteDto>> getRouteBetweenDeptAndArrival(@PathParam("deptAirport") String deptAirport
    ,@PathParam("arrival") String arrival){
        return Optional.of(new ResponseEntity<>(
                routeService.getRoutesBetween(deptAirport, arrival),HttpStatus.OK
        )).orElse(new ResponseEntity<>(null,HttpStatus.NOT_FOUND));
    }


}
