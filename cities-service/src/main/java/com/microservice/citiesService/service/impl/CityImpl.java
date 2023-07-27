package com.microservice.citiesService.service.impl;

import com.microservice.citiesService.dto.CityDto;
import com.microservice.citiesService.entities.City;
import com.microservice.citiesService.repository.CityRepository;
import com.microservice.citiesService.service.CityService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CityImpl implements CityService {

    CityRepository cityRepository;
    ModelMapper modelMapper;
    @Override
    public CityDto saveCity(CityDto cityDto) {
//        City city = new City(cityDto.getCityId(),
//                cityDto.getCityName(),
//                cityDto.getCountryName(),
//                cityDto.getPinCode());
        City city = modelMapper.map(cityDto,City.class);

        City savedCity = cityRepository.save(city);

//        CityDto savedCityDto = new CityDto(savedCity.getCityId(),
//                savedCity.getCityName(),
//                savedCity.getCountryName(),
//                savedCity.getPinCode());
        CityDto savedCityDto = modelMapper.map(savedCity,CityDto.class);

        return savedCityDto;
    }

    @Override
    public CityDto getCityByPinCode(String pinCode) {
        City city = cityRepository.findByPinCode(pinCode);

//        CityDto cityDto = new CityDto(city.getCityId(),
//                city.getCityName(),
//                city.getCountryName(),
//                city.getPinCode());
        CityDto cityDto = modelMapper.map(city,CityDto.class);

        return cityDto;
    }
}
