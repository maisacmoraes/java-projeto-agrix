package com.betrybe.agrix.service;

import com.betrybe.agrix.exception.FertilizerNotFoundException;
import com.betrybe.agrix.model.entities.Fertilizer;
import com.betrybe.agrix.model.repositories.FertilizerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Fertilizer service.
 */
@Service
public class FertilizerService {

  private final FertilizerRepository fertilizerRepository;

  @Autowired
  public FertilizerService(FertilizerRepository fertilizerRepository) {
    this.fertilizerRepository = fertilizerRepository;
  }

  public Fertilizer insertFertilizer(Fertilizer fertilizer) {
    return fertilizerRepository.save(fertilizer);
  }

  public List<Fertilizer> getAllFertilizers() {
    return fertilizerRepository.findAll();
  }

  public Fertilizer getFertilizerById(Integer id) {
    return fertilizerRepository.findById(id).orElseThrow(FertilizerNotFoundException::new);
  }

}
