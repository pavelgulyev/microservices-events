package com.example.serviceshedule.controller;

import com.example.serviceshedule.entity.ClassEvent;
import com.example.serviceshedule.service.ClassEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webshedule")
public class ClassEventController {
    @Autowired
    private ClassEventService classEventServiceService;
    @PostMapping("/classevent")
    public ResponseEntity<ClassEvent> create(@RequestBody ClassEvent dto) {
        return mappingResponseCategory(classEventServiceService.createFaculty(dto));
    }
    @GetMapping("/classesevent")
    public ResponseEntity<List<ClassEvent>> readAll() {
        return mappingResponseListCategory(classEventServiceService.readAll());
    }
    @GetMapping("/classevent/{id}")
    public ResponseEntity<ClassEvent> fingById(@PathVariable Long id) {
        ClassEvent findFaculty = classEventServiceService.getFacultyById(id);

        if (findFaculty ==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return mappingResponseCategory(findFaculty);
    }
    @PutMapping("/classevent/{id}")
    public ResponseEntity<ClassEvent> update(@PathVariable Long id,
                                          @RequestBody ClassEvent faculty) {
        return mappingResponseCategory(classEventServiceService.update(faculty));
    }
    private ResponseEntity<ClassEvent> mappingResponseCategory(ClassEvent classEvent) {
        return new ResponseEntity<>(classEvent, HttpStatus.OK);
    }
    @DeleteMapping("/classevent/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        classEventServiceService.delete(id);
        return HttpStatus.OK;
    }

    private ResponseEntity<List<ClassEvent>> mappingResponseListCategory(List<ClassEvent> classEvents) {
        if (classEvents.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(classEvents, HttpStatus.OK);
    }
}
