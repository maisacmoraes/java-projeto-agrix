package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.CropsDto;
import com.betrybe.agrix.controller.dto.CropsWithFertilizersDto;
import com.betrybe.agrix.controller.dto.FertilizerDto;
import com.betrybe.agrix.model.entities.Crops;
import com.betrybe.agrix.service.CropsService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Crops controller.
 */

@RestController
@RequestMapping("/crops")
public class CropController {

  private final CropsService service;

  @Autowired
  public CropController(CropsService service) {
    this.service = service;
  }

  /**
   * Get all crops.
   *
   * @return List of crops.
   */
  @GetMapping
  @Secured({"ROLE_ADMIN", "ROLE_MANAGER"})
  public ResponseEntity<List<CropsDto>> getAllCrops() {
    List<Crops> allCrops = service.getAllCrops();
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(allCrops
            .stream()
            .map((crop) -> new CropsDto(
                crop.getId(),
                crop.getName(),
                crop.getplantedArea(),
                crop.getPlantedDate(),
                crop.getHarvestDate(),
                crop.getFarm().getId()
            ))
            .collect(Collectors.toList())
        );
  }

  @GetMapping("{id}")
  public ResponseEntity<CropsDto> getCropById(@PathVariable Integer id) {
    Crops crop = service.getCropById(id);
    return ResponseEntity.status(HttpStatus.OK).body(CropsDto.fromEntity(crop));
  }

  /**
   * Search crops by harvest date.
   *
   * @param start Start date.
   * @param end   End date.
   * @return List of crops.
   */
  @GetMapping("/search")
  public ResponseEntity<List<CropsDto>> searchCropsByHarvestDate(
      @RequestParam("start") String start,
      @RequestParam("end") String end) {
    List<Crops> allCrops = service.searchCropsByHarvestDate(start, end);
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(allCrops
            .stream()
            .map((crop) -> new CropsDto(
                crop.getId(),
                crop.getName(),
                crop.getplantedArea(),
                crop.getPlantedDate(),
                crop.getHarvestDate(),
                crop.getFarm().getId()
            ))
            .collect(Collectors.toList())
        );
  }

  /**
   * Get all crops from a farm.
   *
   * @param cropId Crop id.
   * @param fertilizerId Fertilizer id.
   * @return associate crop and fertilizer.
   */
  @PostMapping("{cropId}/fertilizers/{fertilizerId}")
  public ResponseEntity<String> insertFertilizer(
      @PathVariable Integer cropId,
      @PathVariable Integer fertilizerId) {

    Crops crop = service.associateCropandFertilizer(cropId, fertilizerId);

    CropsWithFertilizersDto.fromEntity(crop);

    return ResponseEntity.status(HttpStatus.CREATED)
        .body("Fertilizante e plantação associados com sucesso!");
  }

  /**
   * Get all fertilizers from a crop.
   *
   * @param cropId Crop id.
   * @return List of fertilizers.
   */
  @GetMapping("{cropId}/fertilizers")
  public List<FertilizerDto> getCropsFertilizers(@PathVariable Integer cropId) {
    Crops crop = service.getCropById(cropId);
    return crop.getFertilizers()
        .stream()
        .map(FertilizerDto::fromEntity)
        .collect(Collectors.toList());
  }
}
