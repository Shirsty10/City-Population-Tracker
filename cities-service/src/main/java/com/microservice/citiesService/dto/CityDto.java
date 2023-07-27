package com.microservice.citiesService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {
    private long cityId;
    private String cityName;
    private String countryName;
    private String pinCode;
}
