package com.example.serviceshedule.controller;

import com.example.serviceshedule.entity.Building;
import com.example.serviceshedule.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webshedule")
public class BuildingController {
    @Autowired
    private BuildingService service;
    @PostMapping("/building")
    public ResponseEntity<Building> create(@RequestBody Building dto) {
        return mappingResponseBuilding(service.createBuilding(dto));
    }
    @GetMapping("/buildings")
    public ResponseEntity<List<Building>> readAll() {
        return mappingResponseListBuilding(service.readAll());
    }
    @GetMapping("/building/{id}")
    public ResponseEntity<Building> fingById(@PathVariable Long id) {
        Building findFaculty = service.getBuildingById(id);
        return mappingResponseBuilding(findFaculty);
    }
    @PutMapping("/building")
    public ResponseEntity<Building> update(@PathVariable Long id,
                                          @RequestBody Building faculty) {
        return mappingResponseBuilding(service.update(faculty));
    }
    private ResponseEntity<Building> mappingResponseBuilding(Building category) {
        if (category ==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    @DeleteMapping("/building/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        service.delete(id);
        return HttpStatus.OK;
    }

    private ResponseEntity<List<Building>> mappingResponseListBuilding(List<Building> categories) {
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
