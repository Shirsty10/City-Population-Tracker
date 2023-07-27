package com.microservice.populationService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private long personId;
    private String firstName;
    private String lastName;

    private String uniqueNo;
    private String cityPinCode;

}
