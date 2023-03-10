package com.example.serviceshedule.controller;


import com.example.serviceshedule.dto.LocationDto;
import com.example.serviceshedule.entity.Location;
import com.example.serviceshedule.service.EventService;
import com.example.serviceshedule.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webshedule")
public class LocationController {
    @Autowired
    private LocationService service;
    @PostMapping("/location")
    public ResponseEntity<Location> create(@RequestBody LocationDto dto) {
        //facultyService.create(dto);
        return mappingResponseFaculty(service.createFromDTO(dto));
    }
    @DeleteMapping("/location/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        service.delete(id);
        return HttpStatus.OK;
    }
    @GetMapping("/locations")
    public ResponseEntity<List<Location>> readAll() {
        return mappingResponseListLocations(service.readAll());
    }
    @GetMapping("/locationdto")
    public ResponseEntity<LocationDto> readGroupUniversityDto() {
        LocationDto dto = new LocationDto();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    @GetMapping("/location/{id}")
    public ResponseEntity<Location> findById(@PathVariable Long id) {
        Location findFaculty = service.getEventById(id);
        return mappingResponseFaculty(findFaculty);
    }
//    @GetMapping("/location/organizer")
//    public ResponseEntity<List<Location>> findByUserLogin(@RequestBody String login) {
//        //groupUniversity findFaculty = facultyService.readByCategoryId(id);
//        return mappingResponseListLocations(service.(login));
//    }
//    @GetMapping("/event/organizer")
//    public ResponseEntity<?> findByUserLogin(@RequestBody String login) {
//        //groupUniversity findFaculty = facultyService.readByCategoryId(id);
//        return new ResponseEntity<>(login, HttpStatus.OK);
//    }
    @PutMapping("/location")
    public ResponseEntity<Location> update(
                                          @RequestBody Location faculty) {
        return mappingResponseFaculty(service.update(faculty));
    }
    private ResponseEntity<Location> mappingResponseFaculty(Location faculty) {
        if (faculty ==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(faculty, HttpStatus.OK);
    }

    private ResponseEntity<List<Location>> mappingResponseListLocations(List<Location> list) {
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
