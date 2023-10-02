package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.CropsDto;
import com.betrybe.agrix.controller.dto.FarmDto;
import com.betrybe.agrix.model.entities.Crops;
import com.betrybe.agrix.model.entities.Farm;
import com.betrybe.agrix.service.CropsService;
import com.betrybe.agrix.service.FarmService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Farm controller.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {

  private final FarmService farmService;
  private final CropsService cropsService;

  @Autowired
  public FarmController(FarmService farmService, CropsService cropsService) {
    this.farmService = farmService;
    this.cropsService = cropsService;
  }

  @PostMapping
  public ResponseEntity<FarmDto> createFarm(@RequestBody FarmDto farmDto) {
    Farm farm = farmService.insertFarm(farmDto.toEntity());
    return ResponseEntity.status(HttpStatus.CREATED).body(FarmDto.fromEntity(farm));
  }

  /**
   * Get all farms.
   *
   * @return List of farms.
   */
  @GetMapping
  public ResponseEntity<List<FarmDto>> getAllFarms() {
    List<Farm> allFarms = farmService.getAllFarms();
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(allFarms
            .stream()
            .map((farm) -> new FarmDto(farm.getId(), farm.getName(), farm.getSize()))
            .collect(Collectors.toList())
        );
  }

  @GetMapping("{id}")
  public ResponseEntity<FarmDto> getFarmById(@PathVariable Integer id) {
    Farm farm = farmService.getFarmById(id);
    return ResponseEntity.status(HttpStatus.OK).body(FarmDto.fromEntity(farm));
  }

  /**
   * Get all crops from a farm.
   *
   * @param farmId Farm id.
   * @return List of crops.
   */
  @PostMapping("{farmId}/crops")
  public ResponseEntity<CropsDto> insertCrops(
      @PathVariable Integer farmId, @RequestBody CropsDto cropsDto) {

    Farm getFarm = farmService.getFarmById(farmId);

    Crops crop = cropsDto.toEntity();
    crop.setFarm(getFarm);


    Crops newCrop = cropsService.insertCrops(crop);
    return ResponseEntity.status(HttpStatus.CREATED).body(CropsDto.fromEntity(newCrop));

  }

  /**
   * Get all crops from a farm.
   *
   * @param farmId Farm id.
   * @return List of crops.
   */
  @GetMapping("{farmId}/crops")
  public ResponseEntity<List<CropsDto>> getAllCrops(@PathVariable Integer farmId) {

    Farm getFarm = farmService.getFarmById(farmId);
    List<Crops> getCrops = getFarm.getCrops();

    return ResponseEntity
        .status(HttpStatus.OK)
        .body(getCrops
            .stream()
            .map((crops) -> new CropsDto(crops
                .getId(), crops.getName(), crops.getplantedArea(), crops.getPlantedDate(),
                crops.getHarvestDate(), farmId))
            .collect(Collectors.toList())
        );
  }
}
