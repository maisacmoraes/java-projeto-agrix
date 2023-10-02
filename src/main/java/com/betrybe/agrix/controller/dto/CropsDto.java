package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.model.entities.Crops;
import java.time.LocalDate;

/**
 * Crops DTO.
 */
public record CropsDto(
    Integer id,
    String name,
    Double plantedArea,
    LocalDate plantedDate,
    LocalDate harvestDate,
    Integer farmId
) {

  /**
   * Crops DTO.
   *
   * @param crops Crops entity
   */
  public static CropsDto fromEntity(Crops crops) {
    return new CropsDto(
        crops.getId(),
        crops.getName(),
        crops.getplantedArea(),
        crops.getPlantedDate(),
        crops.getHarvestDate(),
        crops.getFarm().getId()
    );
  }

  /**
   * Crops DTO to entity.
   *
   */
  public Crops toEntity() {
    Crops crops = new Crops();
    crops.setName(name);
    crops.setplantedArea(plantedArea);
    crops.setPlantedDate(plantedDate);
    crops.setHarvestDate(harvestDate);
    return crops;
  }

}
