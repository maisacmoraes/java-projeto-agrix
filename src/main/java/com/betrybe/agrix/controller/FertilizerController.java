package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.FertilizerDto;
import com.betrybe.agrix.model.entities.Fertilizer;
import com.betrybe.agrix.service.FertilizerService;
import java.util.List;
import java.util.stream.Collectors;
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
@RequestMapping("/fertilizers")
public class FertilizerController {

  private final FertilizerService fertilizerService;

  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  @PostMapping
  public ResponseEntity<FertilizerDto> createFertilizer(@RequestBody FertilizerDto fertilizerDto) {
    Fertilizer fertilizer = fertilizerService.insertFertilizer(fertilizerDto.toEntity());
    return ResponseEntity.status(HttpStatus.CREATED).body(FertilizerDto.fromEntity(fertilizer));
  }

  /**
   * Get all fertilizers.
   *
   * @return List of fertilizers.
   */
  @GetMapping
  public ResponseEntity<List<FertilizerDto>> getAllFertilizers() {
    List<Fertilizer> allFertilizers = fertilizerService.getAllFertilizers();
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(allFertilizers
            .stream()
            .map((fertilizer) -> new FertilizerDto(
                fertilizer.getId(), fertilizer.getName(), fertilizer.getBrand(),
                fertilizer.getComposition()))
            .collect(Collectors.toList()));
  }

  @GetMapping("{id}")
  public ResponseEntity<FertilizerDto> getFertilizerById(@PathVariable Integer id) {
    Fertilizer fertilizer = fertilizerService.getFertilizerById(id);
    return ResponseEntity.status(HttpStatus.OK).body(FertilizerDto.fromEntity(fertilizer));
  }

}
