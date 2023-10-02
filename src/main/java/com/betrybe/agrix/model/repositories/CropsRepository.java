package com.betrybe.agrix.model.repositories;

import com.betrybe.agrix.model.entities.Crops;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Crops repository.
 */
@Repository
public interface CropsRepository extends JpaRepository<Crops, Integer> {

  @Query(
      value = "SELECT * FROM crops AS cr "
          +
              "WHERE cr.harvest_date >= :start AND cr.harvest_date <= :end",
      nativeQuery = true
  )
  List<Crops> findCropsByHarvestDateBetween(@Param("start") String start, @Param("end") String end);

}
