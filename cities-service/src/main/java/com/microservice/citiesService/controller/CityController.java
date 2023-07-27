package com.microservice.citiesService.controller;

import com.microservice.citiesService.dto.CityDto;
import com.microservice.citiesService.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cities")
@AllArgsConstructor
public class CityController {

    private CityService cityService;

    @PostMapping
    public ResponseEntity<CityDto> createNewCity(@RequestBody CityDto citydto){

        CityDto savedEntry = cityService.saveCity(citydto);

        return new ResponseEntity<>(savedEntry, HttpStatus.CREATED);
    }

    @GetMapping("{pin-code}")
    public ResponseEntity<CityDto> getCityByPinCode(@PathVariable("pin-code") String pinCode){
        CityDto getCityDto = cityService.getCityByPinCode(pinCode);
        return new ResponseEntity<>(getCityDto, HttpStatus.OK);
    }
}
