package com.flightManagement.mapper;

import com.flightManagement.dto.CountryDto;
import com.flightManagement.entity.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {

    public CountryDto fromEntity(Country country){
        CountryDto countryDto= new CountryDto();
        countryDto.setCountryCode(country.getCountryCode());
        countryDto.setCountryName(country.getCountryName());
        return countryDto;
    }
}
