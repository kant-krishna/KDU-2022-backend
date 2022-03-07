package com.flightManagement.repository;

import com.flightManagement.entity.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneRepository extends JpaRepository<Airplane, String> {
}