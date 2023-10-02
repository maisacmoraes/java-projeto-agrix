package com.betrybe.agrix.service;

import com.betrybe.agrix.exception.CropNotFoundException;
import com.betrybe.agrix.model.entities.Crops;
import com.betrybe.agrix.model.entities.Fertilizer;
import com.betrybe.agrix.model.repositories.CropsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Crop service.
 */
@Service
public class CropsService {

  private final CropsRepository cropsRepository;

  private final FertilizerService fertilizerService;

  @Autowired
  public CropsService(CropsRepository cropsRepository, FertilizerService fertilizerService) {
    this.cropsRepository = cropsRepository;
    this.fertilizerService = fertilizerService;
  }

  public Crops insertCrops(Crops crops) {
    return cropsRepository.save(crops);
  }

  public List<Crops> getAllCrops() {
    return cropsRepository.findAll();
  }

  public Crops getCropById(Integer id) {
    return cropsRepository.findById(id).orElseThrow(CropNotFoundException::new);
  }

  public List<Crops> searchCropsByHarvestDate(String start, String end) {
    return cropsRepository.findCropsByHarvestDateBetween(start, end);
  }

  /**
   * Associate a crop with a fertilizer.
   *
   * @param cropId       crop id
   * @param fertilizerId fertilizer id
   * @return Crops
   */
  public Crops associateCropandFertilizer(Integer cropId, Integer fertilizerId) {
    Crops crop = getCropById(cropId);
    Fertilizer fertlizer = fertilizerService.getFertilizerById(fertilizerId);

    crop.getFertilizers().add(fertlizer);

    return cropsRepository.save(crop);
  }
}
