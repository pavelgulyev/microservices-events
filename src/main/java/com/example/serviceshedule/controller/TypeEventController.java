package com.example.serviceshedule.controller;


import com.example.serviceshedule.entity.TypeEvent;
import com.example.serviceshedule.service.TypeEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webshedule")
public class TypeEventController {
    @Autowired
    private TypeEventService typeEventService;
    @PostMapping("/typeevent")
    public ResponseEntity<TypeEvent> create(@RequestBody TypeEvent dto) {
        return mappingResponseFaculty(typeEventService.createTypeEvent(dto));
    }
    @GetMapping("/typeevents")
    public ResponseEntity<List<TypeEvent>> readAll() {
        return mappingResponseListFaculty(typeEventService.readAll());
    }
    @GetMapping("/typeevent/{id}")
    public ResponseEntity<TypeEvent> fingById(@PathVariable Long id) {
        TypeEvent findFaculty = typeEventService.getFacultyById(id);

        if (findFaculty ==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return mappingResponseFaculty(findFaculty);
    }
    @PutMapping("/typeevent/{id}")
    public ResponseEntity<TypeEvent> update(@PathVariable Long id,
                                          @RequestBody TypeEvent faculty) {
        return mappingResponseFaculty(typeEventService.update(faculty));
    }
    private ResponseEntity<TypeEvent> mappingResponseFaculty(TypeEvent faculty) {
        return new ResponseEntity<>(faculty, HttpStatus.OK);
    }

    private ResponseEntity<List<TypeEvent>> mappingResponseListFaculty(List<TypeEvent> faculties) {
        if (faculties.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(faculties, HttpStatus.OK);
    }
}
