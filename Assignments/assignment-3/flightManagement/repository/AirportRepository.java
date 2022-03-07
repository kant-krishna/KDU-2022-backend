package com.flightManagement.repository;

import com.flightManagement.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, String> {
    @Query(value = "Select * from airports ar where ar.City_code=:cityCode",nativeQuery = true)
    List<Airport> findByCityCode(String cityCode);
}