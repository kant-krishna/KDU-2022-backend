package com.flightManagement.service;

import com.flightManagement.dto.CityDto;

import java.util.List;

public interface CityService {
    CityDto addCity(CityDto cityDto);
    List<CityDto> getAllCity();
}
