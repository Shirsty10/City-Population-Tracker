package com.microservice.citiesService.service;

import com.microservice.citiesService.dto.CityDto;


public interface CityService {

    CityDto saveCity(CityDto cityDto);

    CityDto getCityByPinCode(String pinCode);
}
