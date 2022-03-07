package com.flightManagement.mapper;

import com.flightManagement.dto.CityDto;
import com.flightManagement.entity.City;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component

@Data
public class CityMapper {

    public CityDto fromEntity(City city){
        CityDto cityDto= new CityDto();
        cityDto.setCityCode(city.getCityCode());
        cityDto.setCityName(city.getCityName());
        cityDto.setCountryCode(city.getCountry().getCountryCode());
        return cityDto;
    }
}
