package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.model.entities.Farm;

/**
 * Farm DTO.
 */
public record FarmDto(Integer id, String name, Double size) {


  /**
   * Farm DTO.
   *
   * @param farm Farm entity
   */
  public static FarmDto fromEntity(Farm farm) {
    return new FarmDto(
        farm.getId(),
        farm.getName(),
        farm.getSize()
    );
  }

  /**
   * Farm DTO to entity.
   *
   */
  public Farm toEntity() {
    Farm farm = new Farm();
    farm.setName(name);
    farm.setSize(size);
    return farm;
  }
}
