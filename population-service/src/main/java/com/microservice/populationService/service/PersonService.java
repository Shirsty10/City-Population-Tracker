package com.microservice.populationService.service;

import com.microservice.populationService.dto.ApiResponseDto;
import com.microservice.populationService.dto.PersonDto;

public interface PersonService {

    public PersonDto savePerson(PersonDto personDto);

    public ApiResponseDto getPersonByUniqueNo(String uniqueNo);
}
