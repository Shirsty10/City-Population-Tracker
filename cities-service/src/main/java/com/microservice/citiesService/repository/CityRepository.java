package com.microservice.citiesService.repository;

import com.microservice.citiesService.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Long> {

    public City findByPinCode(String pinCode);
}
