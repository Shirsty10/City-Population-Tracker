package com.microservice.populationService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityDto {
    private long cityId;
    private String cityName;
    private String countryName;
    private String pinCode;
}
