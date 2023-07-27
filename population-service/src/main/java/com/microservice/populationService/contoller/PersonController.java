package com.microservice.populationService.contoller;

import com.microservice.populationService.dto.ApiResponseDto;
import com.microservice.populationService.dto.PersonDto;
import com.microservice.populationService.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persons")
@AllArgsConstructor
public class PersonController {

    public PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDto> savePerson(@RequestBody PersonDto personDto){
        PersonDto savedPersonDto = personService.savePerson(personDto);
        return new ResponseEntity<>(savedPersonDto, HttpStatus.CREATED);
    }

    @GetMapping("{unique-no}")
    public ResponseEntity<ApiResponseDto> getPersonByUniqueNo(@PathVariable("unique-no") String uniqueNo){
        ApiResponseDto getPersonDto = personService.getPersonByUniqueNo(uniqueNo);
        return new ResponseEntity<>(getPersonDto,HttpStatus.OK);
    }
}
