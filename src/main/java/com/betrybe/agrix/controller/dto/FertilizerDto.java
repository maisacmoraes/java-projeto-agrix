package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.model.entities.Fertilizer;

/**
 * Fertilizer DTO.
 */
public record FertilizerDto(Integer id, String name, String brand, String composition) {

  /**
   * Fertilizer DTO.
   *
   * @param fertilizer Fertilizer entity
   * @return Fertilizer DTO
   */
  public static FertilizerDto fromEntity(Fertilizer fertilizer) {
    return new FertilizerDto(
        fertilizer.getId(),
        fertilizer.getName(),
        fertilizer.getBrand(),
        fertilizer.getComposition()
    );
  }

  /**
   * Fertilizer DTO to entity.
  */
  public Fertilizer toEntity() {
    Fertilizer fertilizer = new Fertilizer();
    fertilizer.setName(name);
    fertilizer.setBrand(brand);
    fertilizer.setComposition(composition);
    return fertilizer;
  }
}
