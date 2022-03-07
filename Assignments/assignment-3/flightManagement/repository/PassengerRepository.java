package com.flightManagement.repository;

import com.flightManagement.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    @Query(value = "SELECT * FROM flight_data.passenger " +
            "WHERE Flight_inst_ID=:flightId",nativeQuery = true)
    List<Passenger> findByFlightId(@Param("flightId") Long flightId);
}