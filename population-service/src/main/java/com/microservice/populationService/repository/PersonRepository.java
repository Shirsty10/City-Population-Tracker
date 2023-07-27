package com.microservice.populationService.repository;

import com.microservice.populationService.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

    public Person findByUniqueNo(String uniqueNo);
}
