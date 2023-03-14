package com.example.serviceshedule.controller;


import com.example.serviceshedule.entity.TypeLocation;
import com.example.serviceshedule.service.TypeLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webshedule")
public class TypeLocationController {
    @Autowired
    private TypeLocationService service;
    @PostMapping("/typelocation")
    public ResponseEntity<TypeLocation> create(@RequestBody TypeLocation dto) {
        return mappingResponseFaculty(service.create(dto));
    }
    @GetMapping("/typelocations")
    public ResponseEntity<List<TypeLocation>> readAll() {
        return mappingResponseListFaculty(service.readAll());
    }
    @GetMapping("/typelocation/{id}")
    public ResponseEntity<TypeLocation> fingById(@PathVariable Long id) {
        return mappingResponseFaculty(service.getEventById(id));
    }
    @PutMapping("/typelocation/{id}")
    public ResponseEntity<TypeLocation> update(@PathVariable Long id,
                                          @RequestBody TypeLocation faculty) {
        return mappingResponseFaculty(service.update(faculty));
    }
    private ResponseEntity<TypeLocation> mappingResponseFaculty(TypeLocation faculty) {
        if (faculty ==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(faculty, HttpStatus.OK);
    }

    private ResponseEntity<List<TypeLocation>> mappingResponseListFaculty(List<TypeLocation> locations) {
        if (locations.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }
}
