package com.example.serviceshedule.repository;

import com.example.serviceshedule.entity.Building;
import com.example.serviceshedule.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, Long> {

}

