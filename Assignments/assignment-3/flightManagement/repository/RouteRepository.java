package com.flightManagement.repository;

import com.flightManagement.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {
    @Query(value ="SELECT * FROM flight_data.routes " +
            "where departure_airport_code=:deptAirport " +
            "AND arrival_airport_code=:arrAirport" ,nativeQuery = true)
    List<Route> findBetweenArrivalAndDeparture(String deptAirport,String arrAirport);
}