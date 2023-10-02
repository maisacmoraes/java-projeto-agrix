package com.betrybe.agrix.model.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 * Farm.
 */
@Entity
@Table(name = "farms")
public class Farm {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private double size;

  @OneToMany(mappedBy = "farm")
  @JsonIgnore
  List<Crops> crops;

  public Farm() {
  }

  /**
   * Farm.
   *
   * @param id farm id
   * @param name farm name
   * @param size farm size
   */
  public Farm(Integer id, String name, double size, List<Crops> crops) {
    this.id = id;
    this.name = name;
    this.size = size;
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

  public double getSize() {
    return size;
  }

  public void setSize(double size) {
    this.size = size;
  }

  public List<Crops> getCrops() {
    return crops;
  }

  public void setCrops(List<Crops> crops) {
    this.crops = crops;
  }
}
