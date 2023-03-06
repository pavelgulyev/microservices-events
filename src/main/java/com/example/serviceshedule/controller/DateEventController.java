package com.example.serviceshedule.controller;

import com.example.serviceshedule.dto.GroupUniversityDto;
import com.example.serviceshedule.entity.DateEvent;
import com.example.serviceshedule.service.DateEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/webshedule")
public class DateEventController {
//    @Autowired
//    private DateEventService service;
//    @PostMapping("/dateevent")
//    public ResponseEntity<DateEvent> create(@RequestBody DateEvent dto) {
//        return mappingResponseFaculty(service.createFaculty(dto));
//    }
//    @GetMapping("/newdateevent")
//    public ResponseEntity<DateEvent> readGroupUniversityDto() {
//        DateEvent dto = new DateEvent();
//        dto.setDateStartEvent(LocalDateTime.now());
//        dto.setDateEndEvent(LocalDateTime.now());
//        return new ResponseEntity<>(dto, HttpStatus.OK);
//    }
//    @GetMapping("/dateevents")
//    public ResponseEntity<List<DateEvent>> readAll() {
//        return mappingResponseListFaculty(service.readAll());
//    }
//    @GetMapping("/dateevent/{id}")
//    public ResponseEntity<DateEvent> fingById(@PathVariable Long id) {
//        DateEvent findFaculty = service.getFacultyById(id);
//
//        if (findFaculty ==null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return mappingResponseFaculty(findFaculty);
//    }
//    @PutMapping("/dateevent")
//    public ResponseEntity<DateEvent> update(@PathVariable Long id,
//                                          @RequestBody DateEvent faculty) {
//        return mappingResponseFaculty(service.update(faculty));
//    }
//    private ResponseEntity<DateEvent> mappingResponseFaculty(DateEvent faculty) {
//        return new ResponseEntity<>(faculty, HttpStatus.OK);
//    }
//    @DeleteMapping("/dateevent/{id}")
//    public HttpStatus delete(@PathVariable Long id) {
//        service.delete(id);
//        return HttpStatus.OK;
//    }
//
//    private ResponseEntity<List<DateEvent>> mappingResponseListFaculty(List<DateEvent> faculties) {
//        if (faculties.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(faculties, HttpStatus.OK);
//    }
}
