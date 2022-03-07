package com.flightManagement.repository;

import com.flightManagement.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query(value = "select * FROM flight_ fl where fl.route_id = :routeId",nativeQuery = true)
    List<Flight> findByRoute_Id(@Param("routeId") Long routeId);
}