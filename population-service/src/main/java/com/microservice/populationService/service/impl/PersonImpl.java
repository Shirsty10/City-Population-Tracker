package com.microservice.populationService.service.impl;

import com.microservice.populationService.dto.ApiResponseDto;
import com.microservice.populationService.dto.CityDto;
import com.microservice.populationService.dto.PersonDto;
import com.microservice.populationService.entity.Person;
import com.microservice.populationService.repository.PersonRepository;
import com.microservice.populationService.service.PersonService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class PersonImpl implements PersonService {

    private PersonRepository personRepository;
    private ModelMapper modelMapper;
    private WebClient webClient;
    @Override
    public PersonDto savePerson(PersonDto personDto) {
//        Person person = new Person(personDto.getPersonId(),
//                personDto.getFirstName(),
//                personDto.getLastName(),
//                personDto.getUniqueNo());
        Person person = modelMapper.map(personDto,Person.class);

        Person savedPerson = personRepository.save(person);

//        PersonDto savedPersonDto = new PersonDto(
//                savedPerson.getPersonId(),
//                savedPerson.getFirstName(),
//                savedPerson.getLastName(),
//                savedPerson.getUniqueNo()
//        );
        PersonDto savedPersonDto = modelMapper.map(savedPerson,PersonDto.class);

        return savedPersonDto;
    }

    @Override
    public ApiResponseDto getPersonByUniqueNo(String uniqueNo) {
        Person getPerson = personRepository.findByUniqueNo(uniqueNo);
          CityDto citydtodata = webClient.get()
                  .uri("http://localhost:8080/api/cities/" + getPerson.getCityPinCode())
                  .retrieve()
                  .bodyToMono(CityDto.class)
                  .block();
//        PersonDto getpersonDto = new PersonDto(
//                getPerson.getPersonId(),
//                getPerson.getFirstName(),
//                getPerson.getLastName(),
//                getPerson.getUniqueNo()
//        );

        PersonDto getpersonDto = modelMapper.map(getPerson,PersonDto.class);
        ApiResponseDto apiResponseDto = new ApiResponseDto(citydtodata,getpersonDto);
        return apiResponseDto;
    }
}
