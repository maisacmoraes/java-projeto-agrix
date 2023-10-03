package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.model.entities.Person;
import com.betrybe.agrix.security.Role;

/**
 * Person response DTO.
 */
public class PersonResponseDto {
  private Long id;
  private String username;

  private Role role;

  public PersonResponseDto() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }
}
