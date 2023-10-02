package com.betrybe.agrix.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;

/**
 * Crops entity.
 */
@Entity
@Table(name = "crops")
public class Crops {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private Double plantedArea;

  private LocalDate plantedDate;

  private LocalDate harvestDate;

  @ManyToOne
  @JoinColumn(name = "farm_id")
  Farm farm;

  @ManyToMany
  @JoinTable(
      name = "crop_fertilizer",
      joinColumns = @JoinColumn(name = "crop_id"),
      inverseJoinColumns = @JoinColumn(name = "fertilizer_id")
  )
  List<Fertilizer> fertilizers;

  public Crops() {
  }


  /**
   * Crops.
   *
   * @param id   crops id
   * @param name crops name
   * @param plantedArea crops plantedArea
   */
  public Crops(Integer id, String name, Double plantedArea, Farm farm,
      LocalDate plantedDate, LocalDate harvestDate, List<Fertilizer> fertilizers) {
    this.id = id;
    this.name = name;
    this.plantedArea = plantedArea;
    this.farm = farm;
    this.plantedDate = plantedDate;
    this.harvestDate = harvestDate;
    this.fertilizers = fertilizers;
  }

  public List<Fertilizer> getFertilizers() {
    return fertilizers;
  }

  public void setFertilizers(List<Fertilizer> fertilizers) {
    this.fertilizers = fertilizers;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getplantedArea() {
    return plantedArea;
  }

  public void setplantedArea(Double plantedArea) {
    this.plantedArea = plantedArea;
  }

  public LocalDate getPlantedDate() {
    return plantedDate;
  }

  public void setPlantedDate(LocalDate plantedDate) {
    this.plantedDate = plantedDate;
  }

  public LocalDate getHarvestDate() {
    return harvestDate;
  }

  public void setHarvestDate(LocalDate harvestDate) {
    this.harvestDate = harvestDate;
  }

  public Farm getFarm() {
    return farm;
  }

  public void setFarm(Farm farm) {
    this.farm = farm;
  }
}
