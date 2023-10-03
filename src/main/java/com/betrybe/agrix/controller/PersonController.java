package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.PersonDto;
import com.betrybe.agrix.controller.dto.PersonResponseDto;
import com.betrybe.agrix.model.entities.Person;
import com.betrybe.agrix.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Farm controller.
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  /**
   * Creates a new person.
   */
  @PostMapping
  public ResponseEntity<PersonResponseDto> cratePerson(@RequestBody PersonDto personDto) {
    Person newPerson = personService.create(personDto.toEntity());

    PersonResponseDto personResponseDto = new PersonResponseDto();
    personResponseDto.setId(newPerson.getId());
    personResponseDto.setUsername(newPerson.getUsername());
    personResponseDto.setRole(newPerson.getRole());

    return ResponseEntity.status(HttpStatus.CREATED).body(personResponseDto);
  }

}
