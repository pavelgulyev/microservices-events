package com.example.serviceshedule.service;

//import com.example.serviceshedule.dto.EventDto;
//import com.example.serviceshedule.entity.Event;
import com.example.serviceshedule.dto.LocationDto;
import com.example.serviceshedule.entity.Location;
import com.example.serviceshedule.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class LocationService {
    @Autowired
    private TypeLocationRepository typeLocationRepository;
    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private LocationRepository locationRepository;
    @Modifying
    @Transactional
    public Location createFromDTO(LocationDto dto) {
        Location location =new Location();
        location.setNamelocation(dto.getNamelocation());
        location.setType_location(typeLocationRepository.getById(dto.getType_location()));
        location.setBuilding(buildingRepository.getById(dto.getBuilding()));
        return  locationRepository.save(location);
    }
    public List<Location> readAll() {
        return locationRepository.findAll();
    }
    @Modifying
    @Transactional
    public Location update(Location location) {
        return locationRepository.save(location);
    }
    public Location getEventById(Long id) {
        return locationRepository.findById(id).orElse(null);
    }
    public List<Location> findByLicationBuilding(String Building) {
        return locationRepository.findByBuilding(Long.parseLong(Building));
    }
    public List<Location> findByLicationType(String Building) {
        return locationRepository.findByType(Long.parseLong(Building));
    }
    public void delete(Long id) {
        locationRepository.deleteById(id);
    }
}
