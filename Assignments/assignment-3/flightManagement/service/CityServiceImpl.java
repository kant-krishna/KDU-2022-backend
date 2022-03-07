package com.flightManagement.service;

import com.flightManagement.dto.CityDto;
import com.flightManagement.entity.City;
import com.flightManagement.entity.Country;
import com.flightManagement.mapper.CityMapper;
import com.flightManagement.repository.CityRepository;
import com.flightManagement.repository.CountryRepository;
import com.flightManagement.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CityServiceImpl implements CityService {
    @Autowired
    CityRepository cityRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    CityMapper cityMapper;

    @Override
    public CityDto addCity(CityDto cityDto) {
        Country country=countryRepository.getById(cityDto.getCountryCode());
        City city= new City();
        city.setCityName(cityDto.getCityName());
        city.setCityCode(cityDto.getCityCode());
        city.setCountry(country);
        cityRepository.save(city);
        return cityDto;
    }

    @Override
    public List<CityDto> getAllCity() {
        return cityRepository.findAll()
                .stream().map(cityMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
