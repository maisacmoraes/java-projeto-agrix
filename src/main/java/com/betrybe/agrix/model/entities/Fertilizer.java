package com.betrybe.agrix.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Fertilizer entity.
 */
@Entity
@Table(name = "fertilizer")
public class Fertilizer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private String brand;
  private String composition;

  @ManyToMany(mappedBy = "fertilizers")
  List<Crops> crops;

  public Fertilizer() {
  }

  /**
   * Fertilizer.
   *
   * @param id   fertilizer id
   * @param name fertilizer name
   * @param brand fertilizer brand
   * @param composition fertilizer composition
   */
  @Autowired
  public Fertilizer(Integer id, String name, String brand, String composition, List<Crops> crops) {
    this.id = id;
    this.name = name;
    this.brand = brand;
    this.composition = composition;
    this.crops = crops;
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

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getComposition() {
    return composition;
  }

  public void setComposition(String composition) {
    this.composition = composition;
  }

  public List<Crops> getCrops() {
    return crops;
  }

  public void setCrops(List<Crops> crops) {
    this.crops = crops;
  }
}
