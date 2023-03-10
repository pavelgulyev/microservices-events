package com.example.serviceshedule.service;

//import com.example.serviceshedule.dto.EventDto;
//import com.example.serviceshedule.entity.Event;

import com.example.serviceshedule.dto.LocationDto;
import com.example.serviceshedule.entity.TypeLocation;
import com.example.serviceshedule.repository.BuildingRepository;
import com.example.serviceshedule.repository.LocationRepository;
import com.example.serviceshedule.repository.TypeLocationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TypeLocationService {
    @Autowired
    private TypeLocationRepository typeLocationRepository;
    @Modifying
    @Transactional
    public TypeLocation create(TypeLocation dto) {
        return  typeLocationRepository.save(dto);
    }
    public List<TypeLocation> readAll() {
        return typeLocationRepository.findAll();
    }
    @Modifying
    @Transactional
    public TypeLocation update(TypeLocation location) {
        return typeLocationRepository.save(location);
    }
    public TypeLocation getEventById(Long id) {
        return typeLocationRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        typeLocationRepository.deleteById(id);
    }
}
