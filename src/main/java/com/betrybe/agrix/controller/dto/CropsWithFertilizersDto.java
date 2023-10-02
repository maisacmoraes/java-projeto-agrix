package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.model.entities.Crops;
import java.time.LocalDate;
import java.util.List;

/**
 * Crops DTO.
 */
public record CropsWithFertilizersDto(
    Integer id,
    String name,
    Double plantedArea,
    LocalDate plantedDate,
    LocalDate harvestDate,
    Integer farmId,
    List<FertilizerDto> fertilizers) {

  /**
   * Crops DTO.
   *
   * @param crops Crops entity
   */
  public static CropsWithFertilizersDto fromEntity(Crops crops) {
    return new CropsWithFertilizersDto(
        crops.getId(),
        crops.getName(),
        crops.getplantedArea(),
        crops.getPlantedDate(),
        crops.getHarvestDate(),
        crops.getFarm().getId(),
        crops.getFertilizers()
            .stream()
            .map(FertilizerDto::fromEntity)
            .toList()
    );
  }
}
