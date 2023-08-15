package com.microservice.populationService.service.impl;

import com.microservice.populationService.dto.CityDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "localhost:8080", value = "City-Service")
@FeignClient(name = "CITY-SERVICE") //for load balancing
public interface APIFeignClient {

    @GetMapping("/api/cities/{pin-code}")
    CityDto getCityByPinCode(@PathVariable("pin-code") String pinCode);
}
