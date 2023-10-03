package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.model.entities.Person;
import com.betrybe.agrix.security.Role;

/**
 * DTO representing a person.
 */
public record PersonDto(Long id, String username, String password, Role role) {

  /**
   * Creates a PersonDto from a Person entity.
   *
   * @param person the Person entity.
   * @return the PersonDto.
   */
  public static PersonDto fromEntity(Person person) {
    return new PersonDto(
        person.getId(),
        person.getUsername(),
        person.getPassword(),
        person.getRole()
    );
  }

  /**
   * Creates a Person entity from a PersonDto.
   *
   * @return the Person entity.
   */
  public Person toEntity() {
    Person person = new Person();
    person.setUsername(username);
    person.setPassword(password);
    person.setRole(role);
    return person;
  }
}
