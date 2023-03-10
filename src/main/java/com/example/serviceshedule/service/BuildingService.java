package com.example.serviceshedule.service;

import com.example.serviceshedule.dto.FacultyDto;
import com.example.serviceshedule.entity.Building;
import com.example.serviceshedule.repository.BuildingRepository;
import com.example.serviceshedule.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {
    @Autowired
    private BuildingRepository repository;
//    public Faculty create(FacultyDto dto) {
//        return repository.save(Faculty.builder()
//                .nameFaculty(dto.getNameFaculty())
//                .build());
//    }
    public Building createBuilding(Building myfaculty) {
        Building faculty = new Building();
        faculty.setNamebuilding(myfaculty.getNamebuilding());
        return repository.save(faculty);
    }
    public List<Building> readAll() {
        return repository.findAll();
    }
    public Building update(Building building) {
        return repository.save(building);
    }
    public Building getBuildingById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
