package com.example.serviceshedule.repository;

import com.example.serviceshedule.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query(
            value = "SELECT * FROM location where location.type_location_id = ?1",
            nativeQuery = true
    )
    List<Location> findByType(Long type_location_id);
    @Query(
            value = "SELECT * FROM location where location.building_id = ?1",
            nativeQuery = true
    )
    List<Location> findByBuilding(Long building_id);

}
